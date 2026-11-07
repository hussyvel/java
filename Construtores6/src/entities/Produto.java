package entities;

public class Produto {

    private final String nome;
    private final double descricao;
    private final int estoque;

    public Produto(String nome, double descricao, int estoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.estoque = estoque;
    }

    public Produto(String nome, double descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.estoque = 0;
    }

    public Produto(String nome) {
        this(nome, 0.0);
    }

    @Override
    public String toString() {
        return String.format("Produto{nome='%s', preco=%.2f, estoque=%d}", nome, descricao, estoque);
    }

}
