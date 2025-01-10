package exemplo1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Prog1 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Hussyvel");
        list.add("Edinara");
        list.add("Fernanda");
        list.add("João");
        list.add("Ethan");
        list.add(2, "Ribeiro");
        for (String a : list) {
            System.out.println(a);
        }

        System.out.println("--------------");

        list.set(2, "Nascimento");

        for (String x : list) {
            System.out.println(x);
        }


        System.out.println("----------------Remove da lista, caso exista---------------");
        list.removeIf(x -> x.charAt(0) == 'N');
        for (String x : list) {
            System.out.println(x);
        }

        System.out.println("--------------Imprime se existir-------------------");
        System.out.println("Index of Ethan: " + list.indexOf("Ethan"));
        System.out.println("Index of Alfredo: " + list.indexOf("Alfredo"));

        System.out.println("----------------Imprime quem começa com a letra E----------------");

        List<String> result = list.stream().filter(x -> x.charAt(0) == 'E').collect(Collectors.toList());
        for (String x : result) {
            System.out.println(x);
        }

        System.out.println("--------------Encontra o primeiro valor com a letra E---------------");
        String name = list.stream().filter(x -> x.charAt(0) == 'E').findFirst().orElse(null);
        System.out.println(name);


    }
}