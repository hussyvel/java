package org.devmedia;

public class Program {

    //psvm e main são usados para criar o método main
    public static void main(String[] args) {

        HelloWorld aritmetica = new HelloWorld();
            aritmetica.SayHello();
            aritmetica.somaNumero();
            aritmetica.multiplica();

            System.out.println(aritmetica);

    }
}