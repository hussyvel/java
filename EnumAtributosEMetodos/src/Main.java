public class Main {
    public static void main(String[] args) {
        Moeda moeda = Moeda.DOLAR;
        System.out.println("Reais para Dollar: " + moeda.getSimbolo());
        System.out.println("Valor em reais: " + moeda.getValorEmReais());
        System.out.println("Conversão de 10 dólares: R$ " + moeda.converterParaReais(10));
    }
}