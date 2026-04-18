package patrimonio.service;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import patrimonio.model.Bem;
import patrimonio.repository.BemRepository;
import org.springframework.stereotype.Service;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RelatorioService {

    private final BemRepository repo;

    private static final DateTimeFormatter FMT_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter FMT_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");

    private static final Color AZUL_ESCURO = new Color(0x1e, 0x3c, 0x64);
    private static final Color AZUL_MEDIO  = new Color(0x25, 0x3a, 0x5e);
    private static final Color AZUL_CLARO  = new Color(0xd6, 0xea, 0xf8);
    private static final Color BRANCO      = Color.WHITE;
    private static final Color CINZA_LINHA = new Color(0xf7, 0xf9, 0xfc);

    private static final String[] COLUNAS_PDF = {
        "Nº Patrimônio", "Descrição", "Categoria", "Status",
        "Responsável", "Localização", "Data Aquisição", "Valor (R$)"
    };
    private static final String[] COLUNAS_XLS = {
        "Nº Patrimônio", "Descrição", "Categoria", "Marca", "Modelo",
        "Nº Série", "Status", "Responsável", "CPF", "E-mail", "Telefone",
        "Localização", "Data Aquisição", "Valor (R$)", "Observações"
    };

    public RelatorioService(BemRepository repo) {
        this.repo = repo;
    }

    public List<Bem> filtrar(Bem.Categoria categoria, String responsavel, String cpf,
                              LocalDate dataInicio, LocalDate dataFim) {
        return repo.filtrar(
                categoria,
                responsavel == null || responsavel.isBlank() ? null : responsavel,
                cpf         == null || cpf.isBlank()         ? null : cpf,
                dataInicio, dataFim);
    }

    // ------------------------------------------------------------------ PDF
    public byte[] gerarPdf(List<Bem> bens, Bem.Categoria categoria,
                            String responsavel, String cpf, LocalDate dataInicio, LocalDate dataFim) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Document doc = new Document(PageSize.A4.rotate(), 30, 30, 30, 30);
            PdfWriter.getInstance(doc, out);
            doc.open();

            com.lowagie.text.Font fTitulo    = new com.lowagie.text.Font(com.lowagie.text.Font.HELVETICA, 18, com.lowagie.text.Font.BOLD,   BRANCO);
            com.lowagie.text.Font fSubtitulo = new com.lowagie.text.Font(com.lowagie.text.Font.HELVETICA, 10, com.lowagie.text.Font.NORMAL, new Color(0xb0, 0xc4, 0xde));
            com.lowagie.text.Font fFiltro    = new com.lowagie.text.Font(com.lowagie.text.Font.HELVETICA,  9, com.lowagie.text.Font.NORMAL, new Color(0x44, 0x44, 0x44));
            com.lowagie.text.Font fColHead   = new com.lowagie.text.Font(com.lowagie.text.Font.HELVETICA,  9, com.lowagie.text.Font.BOLD,   BRANCO);
            com.lowagie.text.Font fCell      = new com.lowagie.text.Font(com.lowagie.text.Font.HELVETICA,  8, com.lowagie.text.Font.NORMAL, new Color(0x22, 0x22, 0x22));
            com.lowagie.text.Font fTotal     = new com.lowagie.text.Font(com.lowagie.text.Font.HELVETICA,  9, com.lowagie.text.Font.BOLD,   AZUL_ESCURO);

            // Cabeçalho institucional
            PdfPTable header = new PdfPTable(1);
            header.setWidthPercentage(100);
            header.setSpacingAfter(10);
            PdfPCell cHeader = new PdfPCell();
            cHeader.setBackgroundColor(AZUL_ESCURO);
            cHeader.setPadding(14);
            cHeader.setBorder(Rectangle.NO_BORDER);
            Paragraph pTit = new Paragraph();
            pTit.add(new Chunk("SISTEMA PATRIMONIAL", fTitulo));
            pTit.add(Chunk.NEWLINE);
            pTit.add(new Chunk("Controle de Bens Patrimoniais — Relatório Gerencial", fSubtitulo));
            cHeader.addElement(pTit);
            header.addCell(cHeader);
            doc.add(header);

            // Barra de info e filtros
            PdfPTable infoBar = new PdfPTable(2);
            infoBar.setWidthPercentage(100);
            infoBar.setWidths(new float[]{1, 1});
            infoBar.setSpacingAfter(8);
            infoBar.addCell(celulaSemBorda("Gerado em: " + LocalDateTime.now().format(FMT_HORA), fFiltro, Element.ALIGN_LEFT,  AZUL_CLARO, 6));
            infoBar.addCell(celulaSemBorda("Filtros: " + montarDescricaoFiltros(categoria, responsavel, cpf, dataInicio, dataFim), fFiltro, Element.ALIGN_RIGHT, AZUL_CLARO, 6));
            doc.add(infoBar);

            // Tabela de dados
            PdfPTable tabela = new PdfPTable(COLUNAS_PDF.length);
            tabela.setWidthPercentage(100);
            tabela.setWidths(new float[]{10, 22, 10, 9, 16, 12, 10, 11});
            tabela.setSpacingAfter(10);
            for (String col : COLUNAS_PDF) {
                PdfPCell c = new PdfPCell(new Phrase(col, fColHead));
                c.setBackgroundColor(AZUL_MEDIO);
                c.setPadding(6);
                c.setBorderColor(AZUL_ESCURO);
                tabela.addCell(c);
            }
            boolean alt = false;
            for (Bem b : bens) {
                Color bg = alt ? CINZA_LINHA : BRANCO;
                tabela.addCell(celulaTabela(b.getNumeroPatrimonio(), fCell, bg));
                tabela.addCell(celulaTabela(b.getDescricao(), fCell, bg));
                tabela.addCell(celulaTabela(fmtCategoria(b.getCategoria()), fCell, bg));
                tabela.addCell(celulaTabela(fmtStatus(b.getStatus()), fCell, bg));
                tabela.addCell(celulaTabela(nvl(b.getResponsavel()), fCell, bg));
                tabela.addCell(celulaTabela(nvl(b.getLocalizacao()), fCell, bg));
                tabela.addCell(celulaTabela(b.getDataAquisicao() != null ? b.getDataAquisicao().format(FMT_DATA) : "—", fCell, bg));
                tabela.addCell(celulaTabela(b.getValor() != null ? fmtMoeda(b.getValor()) : "—", fCell, bg));
                alt = !alt;
            }
            doc.add(tabela);

            // Rodapé
            BigDecimal valorTotal = bens.stream().filter(b -> b.getValor() != null)
                    .map(Bem::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
            PdfPTable rodape = new PdfPTable(2);
            rodape.setWidthPercentage(100);
            rodape.setWidths(new float[]{1, 1});
            rodape.addCell(celulaSemBorda("Total de bens: " + bens.size(), fTotal, Element.ALIGN_LEFT,  AZUL_CLARO, 6));
            rodape.addCell(celulaSemBorda("Valor total: " + fmtMoeda(valorTotal), fTotal, Element.ALIGN_RIGHT, AZUL_CLARO, 6));
            doc.add(rodape);

            doc.close();
            return out.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar PDF", e);
        }
    }

    // ---------------------------------------------------------------- Excel
    public byte[] gerarExcel(List<Bem> bens, Bem.Categoria categoriaFiltro,
                              String responsavelFiltro, String cpfFiltro, LocalDate dataInicio, LocalDate dataFim) {
        try (XSSFWorkbook wb = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            XSSFCellStyle sTituloAba  = estiloTitulo(wb);
            XSSFCellStyle sCabecalho  = estiloCabecalho(wb);
            XSSFCellStyle sCelula     = estiloCelula(wb, false);
            XSSFCellStyle sCelulaAlt  = estiloCelula(wb, true);
            XSSFCellStyle sValor      = estiloValor(wb, false);
            XSSFCellStyle sValorAlt   = estiloValor(wb, true);
            XSSFCellStyle sRodape     = estiloRodape(wb);
            XSSFCellStyle sInfo       = estiloInfo(wb);

            criarAba(wb, "Todos os Bens", bens,
                    sTituloAba, sCabecalho, sCelula, sCelulaAlt,
                    sValor, sValorAlt, sRodape, sInfo,
                    categoriaFiltro, responsavelFiltro, cpfFiltro, dataInicio, dataFim);

            Map<Bem.Categoria, List<Bem>> porCategoria = bens.stream()
                    .collect(Collectors.groupingBy(Bem::getCategoria, LinkedHashMap::new, Collectors.toList()));
            for (Map.Entry<Bem.Categoria, List<Bem>> e : porCategoria.entrySet()) {
                criarAba(wb, fmtCategoria(e.getKey()), e.getValue(),
                        sTituloAba, sCabecalho, sCelula, sCelulaAlt,
                        sValor, sValorAlt, sRodape, sInfo,
                        e.getKey(), responsavelFiltro, cpfFiltro, dataInicio, dataFim);
            }

            wb.write(out);
            return out.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar Excel", e);
        }
    }

    private void criarAba(XSSFWorkbook wb, String nomeAba, List<Bem> bens,
                           XSSFCellStyle sTituloAba, XSSFCellStyle sCabecalho,
                           XSSFCellStyle sCelula, XSSFCellStyle sCelulaAlt,
                           XSSFCellStyle sValor, XSSFCellStyle sValorAlt,
                           XSSFCellStyle sRodape, XSSFCellStyle sInfo,
                           Bem.Categoria catFiltro, String respFiltro, String cpfFiltro,
                           LocalDate dataInicio, LocalDate dataFim) {

        XSSFSheet sheet = wb.createSheet(nomeAba);
        int lin = 0;

        // Título
        XSSFRow rowTit = sheet.createRow(lin++);
        rowTit.setHeightInPoints(28);
        XSSFCell cTit = rowTit.createCell(0);
        cTit.setCellValue("SISTEMA PATRIMONIAL — " + nomeAba.toUpperCase());
        cTit.setCellStyle(sTituloAba);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, COLUNAS_XLS.length - 1));

        // Info / filtros
        XSSFRow rowInfo = sheet.createRow(lin++);
        rowInfo.setHeightInPoints(18);
        XSSFCell cInfo = rowInfo.createCell(0);
        cInfo.setCellValue("Gerado em: " + LocalDateTime.now().format(FMT_HORA)
                + "   |   Filtros: " + montarDescricaoFiltros(catFiltro, respFiltro, cpfFiltro, dataInicio, dataFim));
        cInfo.setCellStyle(sInfo);
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, COLUNAS_XLS.length - 1));

        lin++; // linha em branco

        // Cabeçalho
        XSSFRow rowHead = sheet.createRow(lin++);
        rowHead.setHeightInPoints(18);
        for (int i = 0; i < COLUNAS_XLS.length; i++) {
            XSSFCell c = rowHead.createCell(i);
            c.setCellValue(COLUNAS_XLS[i]);
            c.setCellStyle(sCabecalho);
        }

        // Dados
        boolean alt = false;
        for (Bem b : bens) {
            XSSFRow row = sheet.createRow(lin++);
            XSSFCellStyle cs  = alt ? sCelulaAlt : sCelula;
            XSSFCellStyle csv = alt ? sValorAlt  : sValor;
            setCell(row, 0,  b.getNumeroPatrimonio(), cs);
            setCell(row, 1,  b.getDescricao(), cs);
            setCell(row, 2,  fmtCategoria(b.getCategoria()), cs);
            setCell(row, 3,  b.getMarca(), cs);
            setCell(row, 4,  b.getModelo(), cs);
            setCell(row, 5,  b.getNumeroSerie(), cs);
            setCell(row, 6,  fmtStatus(b.getStatus()), cs);
            setCell(row, 7,  b.getResponsavel(), cs);
            setCell(row, 8,  b.getResponsavelCpf(), cs);
            setCell(row, 9,  b.getResponsavelEmail(), cs);
            setCell(row, 10, b.getResponsavelTelefone(), cs);
            setCell(row, 11, b.getLocalizacao(), cs);
            setCell(row, 12, b.getDataAquisicao() != null ? b.getDataAquisicao().format(FMT_DATA) : null, cs);
            if (b.getValor() != null) {
                XSSFCell cv = row.createCell(13);
                cv.setCellValue(b.getValor().doubleValue());
                cv.setCellStyle(csv);
            } else {
                setCell(row, 13, null, cs);
            }
            setCell(row, 14, b.getObservacoes(), cs);
            alt = !alt;
        }

        // Rodapé
        lin++;
        BigDecimal valorTotal = bens.stream().filter(b -> b.getValor() != null)
                .map(Bem::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
        XSSFRow rowRod = sheet.createRow(lin);
        rowRod.setHeightInPoints(18);
        XSSFCell cRod = rowRod.createCell(0);
        cRod.setCellValue("Total: " + bens.size() + " bem(ns)   |   Valor total: " + fmtMoeda(valorTotal));
        cRod.setCellStyle(sRodape);
        sheet.addMergedRegion(new CellRangeAddress(lin, lin, 0, COLUNAS_XLS.length - 1));

        int[] larguras = {14, 30, 14, 14, 14, 16, 12, 20, 14, 24, 14, 18, 14, 14, 28};
        for (int i = 0; i < larguras.length; i++) sheet.setColumnWidth(i, larguras[i] * 256);
    }

    // ------------------------------------------------ helpers PDF
    private PdfPCell celulaSemBorda(String txt, com.lowagie.text.Font font, int align, Color bg, float pad) {
        PdfPCell c = new PdfPCell(new Phrase(txt, font));
        c.setBorder(Rectangle.NO_BORDER);
        c.setBackgroundColor(bg);
        c.setPadding(pad);
        c.setHorizontalAlignment(align);
        return c;
    }

    private PdfPCell celulaTabela(String txt, com.lowagie.text.Font font, Color bg) {
        PdfPCell c = new PdfPCell(new Phrase(txt != null ? txt : "—", font));
        c.setBackgroundColor(bg);
        c.setPaddingTop(4); c.setPaddingBottom(4);
        c.setPaddingLeft(5); c.setPaddingRight(5);
        c.setBorderColor(new Color(0xe0, 0xe0, 0xe0));
        return c;
    }

    // ------------------------------------------------ helpers Excel
    private XSSFCellStyle estiloTitulo(XSSFWorkbook wb) {
        XSSFCellStyle s = wb.createCellStyle();
        XSSFFont f = wb.createFont();
        f.setFontHeightInPoints((short) 14);
        f.setBold(true);
        f.setColor(new XSSFColor(BRANCO, null));
        s.setFont(f);
        s.setFillForegroundColor(new XSSFColor(AZUL_ESCURO, null));
        s.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        s.setAlignment(HorizontalAlignment.CENTER);
        s.setVerticalAlignment(VerticalAlignment.CENTER);
        return s;
    }

    private XSSFCellStyle estiloCabecalho(XSSFWorkbook wb) {
        XSSFCellStyle s = wb.createCellStyle();
        XSSFFont f = wb.createFont();
        f.setFontHeightInPoints((short) 10);
        f.setBold(true);
        f.setColor(new XSSFColor(BRANCO, null));
        s.setFont(f);
        s.setFillForegroundColor(new XSSFColor(AZUL_MEDIO, null));
        s.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        s.setAlignment(HorizontalAlignment.CENTER);
        s.setVerticalAlignment(VerticalAlignment.CENTER);
        s.setBorderBottom(BorderStyle.THIN);
        s.setBottomBorderColor(new XSSFColor(AZUL_ESCURO, null));
        return s;
    }

    private XSSFCellStyle estiloCelula(XSSFWorkbook wb, boolean alt) {
        XSSFCellStyle s = wb.createCellStyle();
        if (alt) {
            s.setFillForegroundColor(new XSSFColor(CINZA_LINHA, null));
            s.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        s.setVerticalAlignment(VerticalAlignment.CENTER);
        s.setBorderBottom(BorderStyle.THIN);
        s.setBottomBorderColor(new XSSFColor(new Color(0xe0, 0xe0, 0xe0), null));
        return s;
    }

    private XSSFCellStyle estiloValor(XSSFWorkbook wb, boolean alt) {
        XSSFCellStyle s = wb.createCellStyle();
        if (alt) {
            s.setFillForegroundColor(new XSSFColor(CINZA_LINHA, null));
            s.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        s.setVerticalAlignment(VerticalAlignment.CENTER);
        s.setAlignment(HorizontalAlignment.RIGHT);
        s.setDataFormat(wb.createDataFormat().getFormat("#,##0.00"));
        s.setBorderBottom(BorderStyle.THIN);
        s.setBottomBorderColor(new XSSFColor(new Color(0xe0, 0xe0, 0xe0), null));
        return s;
    }

    private XSSFCellStyle estiloRodape(XSSFWorkbook wb) {
        XSSFCellStyle s = wb.createCellStyle();
        XSSFFont f = wb.createFont();
        f.setBold(true);
        f.setFontHeightInPoints((short) 10);
        f.setColor(new XSSFColor(AZUL_ESCURO, null));
        s.setFont(f);
        s.setFillForegroundColor(new XSSFColor(AZUL_CLARO, null));
        s.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        s.setAlignment(HorizontalAlignment.LEFT);
        s.setVerticalAlignment(VerticalAlignment.CENTER);
        return s;
    }

    private XSSFCellStyle estiloInfo(XSSFWorkbook wb) {
        XSSFCellStyle s = wb.createCellStyle();
        XSSFFont f = wb.createFont();
        f.setFontHeightInPoints((short) 9);
        f.setItalic(true);
        f.setColor(new XSSFColor(new Color(0x44, 0x44, 0x44), null));
        s.setFont(f);
        s.setFillForegroundColor(new XSSFColor(AZUL_CLARO, null));
        s.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        s.setAlignment(HorizontalAlignment.LEFT);
        s.setVerticalAlignment(VerticalAlignment.CENTER);
        return s;
    }

    private void setCell(XSSFRow row, int col, String val, XSSFCellStyle style) {
        XSSFCell c = row.createCell(col);
        c.setCellValue(val != null ? val : "");
        c.setCellStyle(style);
    }

    // ------------------------------------------------ formatadores
    private String fmtCategoria(Bem.Categoria c) {
        if (c == null) return "—";
        return switch (c) {
            case NOTEBOOK   -> "Notebook";
            case DESKTOP    -> "Desktop";
            case DRONE      -> "Drone";
            case MONITOR    -> "Monitor";
            case IMPRESSORA -> "Impressora";
            case PERIFERICO -> "Periférico";
            case OUTRO      -> "Outro";
        };
    }

    private String fmtStatus(Bem.Status s) {
        if (s == null) return "—";
        return switch (s) {
            case ATIVO      -> "Ativo";
            case MANUTENCAO -> "Manutenção";
            case EMPRESTADO -> "Emprestado";
            case BAIXADO    -> "Baixado";
        };
    }

    private String fmtMoeda(BigDecimal v) {
        return "R$ " + String.format("%,.2f", v).replace(',', 'X').replace('.', ',').replace('X', '.');
    }

    private String nvl(String s) { return s != null ? s : "—"; }

    private String montarDescricaoFiltros(Bem.Categoria categoria, String responsavel,
                                           String cpf, LocalDate dataInicio, LocalDate dataFim) {
        List<String> partes = new ArrayList<>();
        if (categoria   != null)                           partes.add("Categoria: " + fmtCategoria(categoria));
        if (responsavel != null && !responsavel.isBlank()) partes.add("Responsável: " + responsavel);
        if (cpf         != null && !cpf.isBlank())         partes.add("CPF: " + cpf);
        if (dataInicio  != null)                           partes.add("De: " + dataInicio.format(FMT_DATA));
        if (dataFim     != null)                           partes.add("Até: " + dataFim.format(FMT_DATA));
        return partes.isEmpty() ? "Todos os registros" : String.join("  |  ", partes);
    }
}
