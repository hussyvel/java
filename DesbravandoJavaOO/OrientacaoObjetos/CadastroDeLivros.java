package DesbravandoJavaOO.OrientacaoObjetos;

import java.awt.*;

public class CadastroDeLivros {


        private String nome;
        private String descricao;
        private double valor;
        private String isbn;

    void mostrarDetalhes(){
        String mensagem = "Mostrando detalhes do livro";
        System.out.println("Nome " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Valor: " + valor);
        System.out.println("ISBN" + isbn);
        System.out.println("---");

    }

    public static void main(String[] args) {

        CadastroDeLivros livro = new CadastroDeLivros();
        livro.nome = "Java 8 Prático";
        livro.descricao = "Novos recursos da linguagem";
        livro.valor = 59.90;
        livro.isbn = "987-654-321-6";

        livro.mostrarDetalhes();

        CadastroDeLivros outroLivro = new CadastroDeLivros();
        outroLivro.nome = "Lógica de programação";
        outroLivro.descricao = "Crie seus próprios programas";
        outroLivro.valor = 59.90;
        outroLivro.isbn ="988877337";

        outroLivro.mostrarDetalhes();
    }

}