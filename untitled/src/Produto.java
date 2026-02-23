import java.util.Objects;

public class Produto {
    private Integer id;
    private String sku;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);

    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
