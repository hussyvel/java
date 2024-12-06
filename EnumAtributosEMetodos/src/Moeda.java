public enum Moeda {
    REAL("R$", 1),
    DOLAR("US$", 5.14),
    EURO("€", 5.47);

    private String simbolo;
    private double valorEmReais;

    Moeda(String simbolo, double valorEmReais) {
        this.simbolo = simbolo;
        this.valorEmReais = valorEmReais;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public double getValorEmReais() {
        return valorEmReais;
    }

    public double converterParaReais(double quantidade) {
        return quantidade * valorEmReais;
    }
}