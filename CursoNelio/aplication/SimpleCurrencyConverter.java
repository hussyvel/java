package CursoNelio.aplication;

import CursoNelio.util.ConversorCalculadora;
import CursoNelio.util.CurrencyConverter;

public class SimpleCurrencyConverter implements ConversorCalculadora {
    private final double dolar;
    private final double taxa;

    public SimpleCurrencyConverter(double dolar, double taxa) {
        this.dolar = dolar;
        this.taxa = taxa;
    }

    @Override
    public double convert(double amount) {
        double totalAmount = amount * (1 + taxa);
        return totalAmount * dolar;
    }
}
