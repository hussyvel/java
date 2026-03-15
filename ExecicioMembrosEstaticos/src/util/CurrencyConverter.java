package util;

public class CurrencyConverter {

    private double cotacaoDolar;

    private double quantidadeDolar;

    public CurrencyConverter(double cotacaoDolar, double quantidadeDolar) {
        this.cotacaoDolar = cotacaoDolar;
        this.quantidadeDolar = quantidadeDolar;
    }


    public double calcularTotal(){
        double valorEmReais = cotacaoDolar * quantidadeDolar;
        double totalComIOF = valorEmReais * 1.06;
        return totalComIOF;
    }
}
