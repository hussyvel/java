package DesbravandoJavaOO;

import java.awt.*;
import java.sql.SQLSyntaxErrorException;

public class Testes {

    private String nome;
    private double cpf;
    private double number;

    void detalhesTestes(){
        String mensagem = "Mostrando detalhes de testes";
        System.out.println("O seu nome é: " + nome);
        System.out.println("O seu cpf é: " + cpf);
        System.out.println("O seu número é: " + number);
        System.out.println("---");
    }
    public static void main(String[] args) {

        Testes teste = new Testes();
        teste.nome = "Hussyvel";
        teste.cpf = 1608453654;
        teste.number = 4444990;

        teste.detalhesTestes();

        Testes teste2 = new Testes();
        teste2.nome = "Edinara";
        teste2.cpf = 89230098;
        teste2.number = 234958;

        teste2.detalhesTestes();
    }
}
