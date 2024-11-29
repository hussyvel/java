package application;

import entities.Livros;

public class CadastroDeLivros {
    public static void main(String[] args) {


        Livros livro = new Livros();
        livro.nome = "Hussyvel";
        livro.descricao = "testes";
        livro.valor = 12154.25;
        livro.isbn = "895-632-236-14";

        System.out.println(livro.nome);
        System.out.println(livro.descricao);
        System.out.println(livro.valor);
        System.out.println(livro.isbn);
    }
}
