package patrimonio.controller;

import patrimonio.model.Bem;
import patrimonio.model.Movimentacao;
import patrimonio.repository.BemRepository;
import patrimonio.repository.MovimentacaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/movimentacoes")
public class MovimentacaoController {

    private final MovimentacaoRepository repo;
    private final BemRepository bemRepo;

    public MovimentacaoController(MovimentacaoRepository repo, BemRepository bemRepo) {
        this.repo    = repo;
        this.bemRepo = bemRepo;
    }

    // Lista todas (com filtro opcional)
    @GetMapping
    public List<Movimentacao> listar(
            @RequestParam(required = false, defaultValue = "") String q) {
        return q.isBlank() ?
                repo.findAll().stream()
                        .sorted(Comparator.comparing(Movimentacao::getDataSaida).reversed())
                        .toList()
                : repo.search(q);
    }

    // Lista apenas as saídas ainda em aberto
    @GetMapping("/em-aberto")
    public List<Movimentacao> emAberto() {
        return repo.findEmAberto();
    }

    // Histórico de um bem específico
    @GetMapping("/bem/{bemId}")
    public List<Movimentacao> historicoBem(@PathVariable Long bemId) {
        return repo.findByBemIdOrderByDataSaidaDesc(bemId);
    }

    // Registrar SAÍDA
    @PostMapping("/saida")
    public ResponseEntity<?> registrarSaida(@RequestBody Map<String, Object> body) {
        Long bemId = Long.valueOf(body.get("bemId").toString());

        // Valida se bem existe
        Bem bem = bemRepo.findById(bemId)
                .orElse(null);
        if (bem == null)
            return ResponseEntity.badRequest().body(erro("Bem não encontrado"));

        // Impede saída dupla
        if (repo.existsSaidaEmAberto(bemId))
            return ResponseEntity.badRequest()
                    .body(erro("Este bem já possui uma saída em aberto. Registre a devolução primeiro."));

        String responsavel = str(body, "responsavelRetirada");
        if (responsavel == null || responsavel.isBlank())
            return ResponseEntity.badRequest().body(erro("Nome de quem levou é obrigatório"));

        Movimentacao mov = new Movimentacao();
        // Captura localização de origem (campo informado ou localizacao atual do bem)
        String localOrigem = str(body, "localOrigem");
        if (localOrigem == null || localOrigem.isBlank()) localOrigem = bem.getLocalizacao();

        mov.setBem(bem);
        mov.setTipo(Movimentacao.Tipo.SAIDA);
        mov.setResponsavelRetirada(responsavel);
        mov.setCpfRetirada(str(body, "cpfRetirada"));
        mov.setLocalOrigem(localOrigem);
        mov.setDestino(str(body, "destino"));
        mov.setSetorAnterior(bem.getSetor());
        String destSaida = str(body, "destino");
        mov.setSetorAtual(destSaida != null && !destSaida.isBlank() ? destSaida : bem.getSetor());
        mov.setQuantidade(body.get("quantidade") != null ?
                Integer.valueOf(body.get("quantidade").toString()) : 1);
        mov.setNumeroChamado(str(body, "numeroChamado"));
        mov.setDataSaida(LocalDateTime.now());
        mov.setObsSaida(str(body, "obs"));
        mov.setUsuarioSaida(loginAtual());

        // Atualiza status do bem para EMPRESTADO e campos opcionais
        bem.setStatus(Bem.Status.EMPRESTADO);
        String hostname = str(body, "hostname");
        String setor    = str(body, "setor");
        if (hostname != null && !hostname.isBlank()) bem.setHostname(hostname);
        if (setor    != null && !setor.isBlank())    bem.setSetor(setor);
        bemRepo.save(bem);

        return ResponseEntity.ok(repo.save(mov));
    }

    // Registrar DEVOLUÇÃO
    @PostMapping("/devolucao/{movId}")
    public ResponseEntity<?> registrarDevolucao(
            @PathVariable Long movId,
            @RequestBody(required = false) Map<String, Object> body) {

        Movimentacao mov = repo.findById(movId).orElse(null);
        if (mov == null)
            return ResponseEntity.notFound().build();

        if (mov.isDevolvido())
            return ResponseEntity.badRequest().body(erro("Devolução já registrada"));

        mov.setDataDevolucao(LocalDateTime.now());
        mov.setUsuarioDevolucao(loginAtual());
        if (body != null) mov.setObsDevolucao(str(body, "obs"));

        // Atualiza status do bem de volta para ATIVO e restaura localização de origem
        Bem bem = mov.getBem();
        bem.setStatus(Bem.Status.ATIVO);
        if (mov.getLocalOrigem() != null && !mov.getLocalOrigem().isBlank())
            bem.setLocalizacao(mov.getLocalOrigem());
        bemRepo.save(bem);

        return ResponseEntity.ok(repo.save(mov));
    }

    // Registrar TRANSFERÊNCIA de setor
    @PostMapping("/transferencia")
    public ResponseEntity<?> registrarTransferencia(@RequestBody Map<String, Object> body) {
        Long bemId = Long.valueOf(body.get("bemId").toString());

        Bem bem = bemRepo.findById(bemId).orElse(null);
        if (bem == null)
            return ResponseEntity.badRequest().body(erro("Bem não encontrado"));

        if (repo.existsSaidaEmAberto(bemId))
            return ResponseEntity.badRequest()
                    .body(erro("Bem possui saída em aberto. Registre a devolução antes de transferir."));

        String setorDestino = str(body, "setorDestino");
        if (setorDestino == null || setorDestino.isBlank())
            return ResponseEntity.badRequest().body(erro("Setor de destino é obrigatório"));

        String responsavel = str(body, "responsavel");
        if (responsavel == null || responsavel.isBlank())
            return ResponseEntity.badRequest().body(erro("Responsável pela transferência é obrigatório"));

        Movimentacao mov = new Movimentacao();
        mov.setBem(bem);
        mov.setTipo(Movimentacao.Tipo.TRANSFERENCIA);
        mov.setLocalOrigem(bem.getSetor());
        mov.setDestino(setorDestino);
        mov.setSetorAnterior(bem.getSetor());
        mov.setSetorAtual(setorDestino);
        mov.setResponsavelRetirada(responsavel);
        mov.setCpfRetirada(str(body, "cpf"));
        mov.setDataSaida(LocalDateTime.now());
        mov.setUsuarioSaida(loginAtual());
        mov.setObsSaida(str(body, "obs"));
        mov.setQuantidade(1);

        bem.setSetor(setorDestino);
        String novaLocalizacao = str(body, "localizacao");
        if (novaLocalizacao != null && !novaLocalizacao.isBlank())
            bem.setLocalizacao(novaLocalizacao);
        bemRepo.save(bem);

        return ResponseEntity.ok(repo.save(mov));
    }

    // Resumo para dashboard
    @GetMapping("/resumo")
    public ResponseEntity<Map<String, Object>> resumo() {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("emAberto", repo.countEmAberto());
        m.put("totalMovimentacoes", repo.count());
        m.put("saidas", repo.findEmAberto());
        return ResponseEntity.ok(m);
    }

    // --- helpers ---
    private String str(Map<String, Object> m, String key) {
        Object v = m.get(key);
        return v != null ? v.toString().trim() : null;
    }

    private Map<String, String> erro(String msg) {
        return Map.of("erro", msg);
    }

    private String loginAtual() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth != null ? auth.getName() : "sistema";
    }
}
