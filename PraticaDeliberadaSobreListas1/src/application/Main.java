package application;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println(list);
        System.out.println("Pegando um elemento específico: " + list.get(0));
        System.out.println("---------");

        list.remove(1);
        System.out.println(list);
        System.out.println("---------");

        //System.out.println("Verificando se existe o ítem: " + list.contains("Banana"));
        System.out.println("----------");
        list.removeIf(x -> x.charAt(0) == 'B');
        for (String x : list){
            System.out.println(x);
        }
    }
}