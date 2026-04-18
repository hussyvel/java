package patrimonio.controller;

import patrimonio.model.Bem;
import patrimonio.model.Setor;
import patrimonio.repository.BemRepository;
import patrimonio.repository.MovimentacaoRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Arrays;

@RestController
@RequestMapping("/api/bens")
public class BemController {

    private final BemRepository repo;
    private final MovimentacaoRepository movRepo;

    public BemController(BemRepository repo, MovimentacaoRepository movRepo) {
        this.repo    = repo;
        this.movRepo = movRepo;
    }

    @GetMapping
    public List<Bem> listar(@RequestParam(required = false, defaultValue = "") String q) {
        return q.isBlank() ? repo.findAll() : repo.search(q);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bem> buscarPorId(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> criar(@Valid @RequestBody Bem bem) {
        if (repo.existsByNumeroPatrimonioAndIdNot(bem.getNumeroPatrimonio(), -1L)) {
            return ResponseEntity.badRequest()
                    .body(Map.of("erro", "Número de patrimônio já cadastrado"));
        }
        return ResponseEntity.ok(repo.save(bem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id,
                                       @Valid @RequestBody Bem bem) {
        Bem atual = repo.findById(id).orElse(null);
        if (atual == null) return ResponseEntity.notFound().build();
        if (repo.existsByNumeroPatrimonioAndIdNot(bem.getNumeroPatrimonio(), id)) {
            return ResponseEntity.badRequest()
                    .body(Map.of("erro", "Número de patrimônio já pertence a outro bem"));
        }
        // Se o bem possui saída em aberto, o setor é controlado pela movimentação
        if (movRepo.existsSaidaEmAberto(id)) {
            bem.setSetor(atual.getSetor());
        }
        bem.setId(id);
        return ResponseEntity.ok(repo.save(bem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        movRepo.deleteAll(movRepo.findByBemIdOrderByDataSaidaDesc(id));
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<?> excluirTodos() {
        movRepo.deleteAll();
        repo.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/dashboard")
    public ResponseEntity<Map<String, Object>> dashboard() {
        Map<String, Object> data = new LinkedHashMap<>();

        // Totais gerais
        List<Object[]> resumoList = repo.resumoGeral();
        Object[] resumo = resumoList.isEmpty() ? new Object[]{0L, java.math.BigDecimal.ZERO} : resumoList.get(0);
        data.put("totalBens", resumo[0]);
        data.put("valorTotal", resumo[1]);

        // Por categoria
        Map<String, Long> porCategoria = new LinkedHashMap<>();
        for (Object[] row : repo.countByCategoria()) {
            porCategoria.put((String) row[0], (Long) row[1]);
        }
        data.put("porCategoria", porCategoria);

        // Por status
        Map<String, Long> porStatus = new LinkedHashMap<>();
        for (Object[] row : repo.countByStatus()) {
            porStatus.put((String) row[0], (Long) row[1]);
        }
        data.put("porStatus", porStatus);

        return ResponseEntity.ok(data);
    }

    @GetMapping("/enums")
    public ResponseEntity<Map<String, Object>> enums() {
        List<String> setores = Arrays.stream(Setor.values())
                .map(Setor::getLabel)
                .toList();
        return ResponseEntity.ok(Map.of(
                "categorias", Bem.Categoria.values(),
                "statuses",   Bem.Status.values(),
                "setores",    setores
        ));
    }

    @GetMapping("/por-setor")
    public ResponseEntity<Map<String, Object>> porSetor() {
        List<Bem> bens = repo.findExcetoBaixados();

        Map<String, List<Bem>> porSetor = bens.stream()
                .collect(Collectors.groupingBy(
                        b -> b.getSetor() != null && !b.getSetor().isBlank() ? b.getSetor() : "(sem setor)",
                        TreeMap::new,
                        Collectors.toList()
                ));

        Map<String, Long> resumo = new TreeMap<>();
        porSetor.forEach((setor, lista) -> resumo.put(setor, (long) lista.size()));

        Map<String, Object> resultado = new LinkedHashMap<>();
        resultado.put("resumo", resumo);
        resultado.put("setores", porSetor);
        return ResponseEntity.ok(resultado);
    }
}
