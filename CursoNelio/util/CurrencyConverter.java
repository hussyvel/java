package CursoNelio.util;

public class CurrencyConverter {

    public static final double IMPOSTO = 0.06;

    public static double converterRealtoDolar(double dolares, double taxaCambio, double imposto){

        double dolaresTotais = dolares * (1 + imposto);
        return dolaresTotais * taxaCambio;
    }
}
