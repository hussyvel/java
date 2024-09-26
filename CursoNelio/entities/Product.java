package CursoNelio.entities;

public class Product {

    public String nome;
    public double preco;
    public int quantidade;

    public double valorTotalEstoque(){
        return preco * quantidade;
    }

    public void adicionarProduto( int quantidade){
        this.quantidade += quantidade;
    }

    public void removerProduto(int quantidade){
        this.quantidade -= quantidade;
    }

    @Override
    public String toString(){
        return "Nome: " + nome +
                ", Preço: " + preco +
                ", Quantidade: " + quantidade +
                " unidades, Total de Estoque: $" +
                String.format("%.2f", valorTotalEstoque());
    }
}