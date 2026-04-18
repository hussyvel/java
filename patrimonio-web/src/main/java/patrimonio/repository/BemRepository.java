package patrimonio.repository;

import patrimonio.model.Bem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BemRepository extends JpaRepository<Bem, Long> {

    Optional<Bem> findByNumeroPatrimonio(String numeroPatrimonio);

    boolean existsByNumeroPatrimonioAndIdNot(String numero, Long id);

    @Query("""
        SELECT b FROM Bem b
        WHERE LOWER(b.numeroPatrimonio) LIKE LOWER(CONCAT('%',:q,'%'))
           OR LOWER(b.descricao)        LIKE LOWER(CONCAT('%',:q,'%'))
           OR LOWER(b.marca)            LIKE LOWER(CONCAT('%',:q,'%'))
           OR LOWER(b.modelo)           LIKE LOWER(CONCAT('%',:q,'%'))
           OR LOWER(b.responsavel)      LIKE LOWER(CONCAT('%',:q,'%'))
           OR LOWER(b.hostname)         LIKE LOWER(CONCAT('%',:q,'%'))
           OR LOWER(b.setor)            LIKE LOWER(CONCAT('%',:q,'%'))
        ORDER BY b.numeroPatrimonio
        """)
    List<Bem> search(@Param("q") String query);

    @Query("SELECT CAST(b.categoria AS string), COUNT(b) FROM Bem b GROUP BY b.categoria")
    List<Object[]> countByCategoria();

    @Query("SELECT CAST(b.status AS string), COUNT(b) FROM Bem b GROUP BY b.status")
    List<Object[]> countByStatus();

    @Query("SELECT COUNT(b), COALESCE(SUM(b.valor), 0) FROM Bem b WHERE b.status != 'BAIXADO'")
    List<Object[]> resumoGeral();

    @Query("SELECT b FROM Bem b WHERE b.status != 'BAIXADO' ORDER BY b.setor, b.numeroPatrimonio")
    List<Bem> findExcetoBaixados();

    @Query("""
        SELECT b FROM Bem b
        WHERE (:categoria   IS NULL OR b.categoria = :categoria)
          AND (:responsavel IS NULL OR LOWER(b.responsavel)     LIKE LOWER(CONCAT('%', CAST(:responsavel AS string), '%')))
          AND (:cpf         IS NULL OR LOWER(b.responsavelCpf)  LIKE LOWER(CONCAT('%', CAST(:cpf AS string), '%')))
          AND (:dataInicio  IS NULL OR b.dataAquisicao >= :dataInicio)
          AND (:dataFim     IS NULL OR b.dataAquisicao <= :dataFim)
        ORDER BY b.categoria, b.numeroPatrimonio
        """)
    List<Bem> filtrar(
        @Param("categoria")   Bem.Categoria categoria,
        @Param("responsavel") String responsavel,
        @Param("cpf")         String cpf,
        @Param("dataInicio")  LocalDate dataInicio,
        @Param("dataFim")     LocalDate dataFim
    );
}
