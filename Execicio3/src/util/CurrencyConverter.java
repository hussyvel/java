package util;

public class CurrencyConverter {

    public static final double IOF = 3.38;

    public static double convert(double amount, double dollarPrice) {

        double total = amount * dollarPrice;
        return total * (1.0 + IOF) ;
    }
}
