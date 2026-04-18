package patrimonio.controller;

import patrimonio.model.Bem;
import patrimonio.service.RelatorioService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/relatorios")
public class RelatorioController {

    private final RelatorioService service;

    public RelatorioController(RelatorioService service) {
        this.service = service;
    }

    @GetMapping("/bens")
    public ResponseEntity<byte[]> gerar(
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) String responsavel,
            @RequestParam(required = false) String cpf,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim,
            @RequestParam String formato) {

        Bem.Categoria cat = null;
        if (categoria != null && !categoria.isBlank()) {
            try { cat = Bem.Categoria.valueOf(categoria.toUpperCase()); }
            catch (IllegalArgumentException ignored) {}
        }

        List<Bem> bens = service.filtrar(cat, responsavel, cpf, dataInicio, dataFim);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmm"));

        if ("excel".equalsIgnoreCase(formato)) {
            byte[] bytes = service.gerarExcel(bens, cat, responsavel, cpf, dataInicio, dataFim);
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"relatorio_bens_" + timestamp + ".xlsx\"")
                    .body(bytes);
        }

        byte[] bytes = service.gerarPdf(bens, cat, responsavel, cpf, dataInicio, dataFim);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"relatorio_bens_" + timestamp + ".pdf\"")
                .body(bytes);
    }
}
