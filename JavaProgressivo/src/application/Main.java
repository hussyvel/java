package application;

public class Main {
    public static void main(String[] args) {
        int a, b = 1;
            System.out.println("b = " + b);
            System.out.println("a = b++ ");
            a = b++;
            System.out.println("Então: a = " + a);
            System.out.println();

            System.out.println("b = " + b);
            System.out.println("a = ++b ");
            a = ++b;
            System.out.println("Então: a = " + a);
    }
}