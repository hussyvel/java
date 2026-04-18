package patrimonio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "bens")
public class Bem {

    public enum Status { ATIVO, MANUTENCAO, EMPRESTADO, BAIXADO }

    public enum Categoria {
        NOTEBOOK, DESKTOP, DRONE, MONITOR, IMPRESSORA, PERIFERICO, OUTRO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Número de patrimônio é obrigatório")
    @Column(name = "numero_patrimonio", nullable = false, unique = true, length = 30)
    private String numeroPatrimonio;

    @NotBlank(message = "Descrição é obrigatória")
    @Column(nullable = false, length = 200)
    private String descricao;

    @NotNull(message = "Categoria é obrigatória")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Categoria categoria;

    @Column(length = 80)
    private String marca;

    @Column(length = 80)
    private String modelo;

    @Column(name = "numero_serie", length = 80)
    private String numeroSerie;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Status status = Status.ATIVO;

    @Column(length = 150)
    private String localizacao;

    @Column(length = 100)
    private String responsavel;

    @Column(name = "responsavel_cpf", length = 14)
    private String responsavelCpf;

    @Column(name = "responsavel_email", length = 150)
    private String responsavelEmail;

    @Column(name = "responsavel_telefone", length = 20)
    private String responsavelTelefone;

    @Column(name = "data_aquisicao")
    private LocalDate dataAquisicao;

    @Column(precision = 12, scale = 2)
    private BigDecimal valor;

    @Column(length = 50)
    private String hostname;

    @Column(length = 100)
    private String setor;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    @Column(name = "criado_em", updatable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm = LocalDateTime.now();

    @PreUpdate
    public void preUpdate() { this.atualizadoEm = LocalDateTime.now(); }

    // --- Getters & Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumeroPatrimonio() { return numeroPatrimonio; }
    public void setNumeroPatrimonio(String n) { this.numeroPatrimonio = n; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String d) { this.descricao = d; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria c) { this.categoria = c; }

    public String getMarca() { return marca; }
    public void setMarca(String m) { this.marca = m; }

    public String getModelo() { return modelo; }
    public void setModelo(String m) { this.modelo = m; }

    public String getNumeroSerie() { return numeroSerie; }
    public void setNumeroSerie(String n) { this.numeroSerie = n; }

    public Status getStatus() { return status; }
    public void setStatus(Status s) { this.status = s; }

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String l) { this.localizacao = l; }

    public String getResponsavel() { return responsavel; }
    public void setResponsavel(String r) { this.responsavel = r; }

    public String getResponsavelCpf() { return responsavelCpf; }
    public void setResponsavelCpf(String c) { this.responsavelCpf = c; }

    public String getResponsavelEmail() { return responsavelEmail; }
    public void setResponsavelEmail(String e) { this.responsavelEmail = e; }

    public String getResponsavelTelefone() { return responsavelTelefone; }
    public void setResponsavelTelefone(String t) { this.responsavelTelefone = t; }

    public LocalDate getDataAquisicao() { return dataAquisicao; }
    public void setDataAquisicao(LocalDate d) { this.dataAquisicao = d; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal v) { this.valor = v; }

    public String getHostname() { return hostname; }
    public void setHostname(String h) { this.hostname = h; }

    public String getSetor() { return setor; }
    public void setSetor(String s) { this.setor = s; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String o) { this.observacoes = o; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime d) { this.criadoEm = d; }

    public LocalDateTime getAtualizadoEm() { return atualizadoEm; }
    public void setAtualizadoEm(LocalDateTime d) { this.atualizadoEm = d; }
}
