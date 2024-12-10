package pgComWhile;

public class ProgressaoGeometrica {
    public static void main(String[] args) {
        int inicial = 1, quociente = 2, p = inicial, valor_max = 32;

        System.out.printf("Elementos da PG, de valor inicial %d e razão %d, menores que %d\n", inicial, quociente, valor_max);
        while (p <= valor_max){
            System.out.println(p);
            p *= quociente;
        }
    }
}
