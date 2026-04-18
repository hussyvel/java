package patrimonio.repository;

import patrimonio.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

    // Histórico completo de um bem
    List<Movimentacao> findByBemIdOrderByDataSaidaDesc(Long bemId);

    // Todas as saídas ainda não devolvidas (em aberto)
    @Query("SELECT m FROM Movimentacao m WHERE m.dataDevolucao IS NULL ORDER BY m.dataSaida DESC")
    List<Movimentacao> findEmAberto();

    // Todas as movimentações ordenadas por data de saída
    @Query("""
        SELECT m FROM Movimentacao m
        WHERE LOWER(m.responsavelRetirada) LIKE LOWER(CONCAT('%',:q,'%'))
           OR LOWER(m.destino)             LIKE LOWER(CONCAT('%',:q,'%'))
           OR LOWER(m.bem.descricao)       LIKE LOWER(CONCAT('%',:q,'%'))
           OR LOWER(m.bem.numeroPatrimonio) LIKE LOWER(CONCAT('%',:q,'%'))
        ORDER BY m.dataSaida DESC
        """)
    List<Movimentacao> search(@Param("q") String q);

    // Verifica se bem já tem saída em aberto
    @Query("SELECT COUNT(m) > 0 FROM Movimentacao m WHERE m.bem.id = :bemId AND m.dataDevolucao IS NULL")
    boolean existsSaidaEmAberto(@Param("bemId") Long bemId);

    // Saída em aberto de um bem específico
    @Query("SELECT m FROM Movimentacao m WHERE m.bem.id = :bemId AND m.dataDevolucao IS NULL")
    Optional<Movimentacao> findSaidaEmAberto(@Param("bemId") Long bemId);

    // Total de saídas em aberto
    @Query("SELECT COUNT(m) FROM Movimentacao m WHERE m.dataDevolucao IS NULL")
    long countEmAberto();
}
