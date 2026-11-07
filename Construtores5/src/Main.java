import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        System.out.println("Iniciando a linha de montagem");

        Produto notebook = new Produto("Notebook Pro", new BigDecimal("5000.00"));
        System.out.println(notebook);
    }
}