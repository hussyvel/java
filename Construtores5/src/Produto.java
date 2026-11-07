import java.math.BigDecimal;
import java.util.Objects;

public class Produto {
    private final String nome;
    private final BigDecimal preco;

    public Produto(String nome, BigDecimal preco) throws IllegalAccessException {

        Objects.requireNonNull(nome, "O nome não pode ser nulo ");
        Objects.requireNonNull(preco, "O preco não pode ser nulo ");

        if (nome.isEmpty()) {
            throw new IllegalArgumentException("O nome não pode estar em branco");
        }
        if (preco.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O preco deve ser maior que zero");
        }

        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto criado: Nome = " + nome + " - " + preco;
    }
}
