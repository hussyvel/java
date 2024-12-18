package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Hussyvel");
        list.add("Edinara");
        list.add("João");
        list.add("Fernanda");
        list.add("Silva");

       System.out.println(list.size());//tamanho da lista

       for (String x : list){
           System.out.println(x);
       }

       System.out.println("-----------------");

       list.removeIf(x -> x.charAt(0) == 'S');//remove se a letra começar com S

       for (String x : list){
           System.out.println(x);
       }

       System.out.println("----------");
       System.out.println("Qual a posição ?: " + list.indexOf("Edinara"));
       List<String> result = list.stream().filter(x -> x.charAt(0) == 'E').collect(Collectors.toList());//filtra nome com a letra E

       for (String x : result) {
           System.out.println(x);
       }

       System.out.println("---------------");
       String name = list.stream().filter(x -> x.charAt(0) == 'H').findFirst().orElse(null);//lista com a letra H
       System.out.println(name);
    }
}