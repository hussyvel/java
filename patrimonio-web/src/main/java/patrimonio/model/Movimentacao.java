package patrimonio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimentacoes")
public class Movimentacao {

    public enum Tipo { SAIDA, DEVOLUCAO, TRANSFERENCIA }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bem_id", nullable = false)
    private Bem bem;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Tipo tipo;

    @NotBlank(message = "Nome de quem levou é obrigatório")
    @Column(name = "responsavel_retirada", nullable = false, length = 100)
    private String responsavelRetirada;

    @Column(name = "cpf_retirada", length = 14)
    private String cpfRetirada;

    @Column(name = "local_origem", length = 150)
    private String localOrigem;

    @Column(length = 150)
    private String destino;

    @Column(nullable = false)
    private Integer quantidade = 1;

    @Column(name = "data_saida", nullable = false)
    private LocalDateTime dataSaida;

    @Column(name = "data_devolucao")
    private LocalDateTime dataDevolucao;

    @Column(name = "usuario_saida", length = 80)
    private String usuarioSaida;       // login do funcionário que registrou a saída

    @Column(name = "usuario_devolucao", length = 80)
    private String usuarioDevolucao;   // login do funcionário que registrou a devolução

    @Column(name = "numero_chamado", length = 30)
    private String numeroChamado;

    @Column(name = "obs_saida", columnDefinition = "TEXT")
    private String obsSaida;

    @Column(name = "obs_devolucao", columnDefinition = "TEXT")
    private String obsDevolucao;

    @Column(name = "setor_anterior", length = 100)
    private String setorAnterior;

    @Column(name = "setor_atual", length = 100)
    private String setorAtual;

    // --- Getters & Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Bem getBem() { return bem; }
    public void setBem(Bem bem) { this.bem = bem; }

    public Tipo getTipo() { return tipo; }
    public void setTipo(Tipo tipo) { this.tipo = tipo; }

    public String getResponsavelRetirada() { return responsavelRetirada; }
    public void setResponsavelRetirada(String r) { this.responsavelRetirada = r; }

    public String getCpfRetirada() { return cpfRetirada; }
    public void setCpfRetirada(String c) { this.cpfRetirada = c; }

    public String getLocalOrigem() { return localOrigem; }
    public void setLocalOrigem(String l) { this.localOrigem = l; }

    public String getDestino() { return destino; }
    public void setDestino(String d) { this.destino = d; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer q) { this.quantidade = q; }

    public LocalDateTime getDataSaida() { return dataSaida; }
    public void setDataSaida(LocalDateTime d) { this.dataSaida = d; }

    public LocalDateTime getDataDevolucao() { return dataDevolucao; }
    public void setDataDevolucao(LocalDateTime d) { this.dataDevolucao = d; }

    public String getUsuarioSaida() { return usuarioSaida; }
    public void setUsuarioSaida(String u) { this.usuarioSaida = u; }

    public String getUsuarioDevolucao() { return usuarioDevolucao; }
    public void setUsuarioDevolucao(String u) { this.usuarioDevolucao = u; }

    public String getNumeroChamado() { return numeroChamado; }
    public void setNumeroChamado(String n) { this.numeroChamado = n; }

    public String getObsSaida() { return obsSaida; }
    public void setObsSaida(String o) { this.obsSaida = o; }

    public String getObsDevolucao() { return obsDevolucao; }
    public void setObsDevolucao(String o) { this.obsDevolucao = o; }

    public String getSetorAnterior() { return setorAnterior; }
    public void setSetorAnterior(String s) { this.setorAnterior = s; }

    public String getSetorAtual() { return setorAtual; }
    public void setSetorAtual(String s) { this.setorAtual = s; }

    public boolean isDevolvido() { return dataDevolucao != null; }
}
