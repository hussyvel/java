package DesbravandoJavaOO;

import java.time.LocalDate;

public class Testes {

    private String nome;
    private String descricao;
    private double valor;
    private String isbn;
    private LocalDate minhaData;

    void detalhesTestes(){
        String mensagem = "Detalhes dos atributos";
        System.out.println("O seu nome é :" + nome);
        System.out.println("A sua descrição é: " + descricao);
        System.out.println("O seu valor é: " + valor);
        System.out.println("A data é "+ minhaData);
        System.out.println("---");

    }
    public static void main(String []args){

        Testes teste = new Testes();
        teste.nome = "Hussyvel";
        teste.descricao = "Software Engineer";
        teste.valor = 99.00;
        teste.minhaData = LocalDate.ofEpochDay(26/05/2023);

         teste.detalhesTestes();

         Testes outroTeste = new Testes();
         outroTeste.nome = "João Ethan";
         outroTeste.descricao = "Meu filho";
         outroTeste.valor = 100.98;
         outroTeste.minhaData = LocalDate.ofEpochDay(26/05/2023);

         outroTeste.detalhesTestes();
    }
}
