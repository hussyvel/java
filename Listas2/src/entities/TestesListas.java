package entities;

import java.util.ArrayList;
import java.util.List;

public class TestesListas {
    public static void main(String[] args) {
        List<String> linguagens = new ArrayList<>();

        // Adicionando elementos
        linguagens.add("Java");
        linguagens.add("Python");
        linguagens.add("C++");

        // Acessando elementos
        System.out.println("Primeira linguagem: " + linguagens.get(0));

        // Alterando um elemento
        linguagens.set(2, "C#");
        System.out.println("Lista após alteração: " + linguagens);

        // Removendo um elemento
        linguagens.remove("Python");
        System.out.println("Lista após remoção: " + linguagens);

        // Verificando se contém um elemento
        System.out.println("A lista contém Java? " + linguagens.contains("Java"));

        // Percorrendo a lista
        System.out.println("Linguagens na lista:");
        for (String linguagem : linguagens) {
            System.out.println(linguagem);
        }

        // Tamanho da lista
        System.out.println("Tamanho da lista: " + linguagens.size());

    }
}
