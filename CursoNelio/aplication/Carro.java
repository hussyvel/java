package CursoNelio.aplication;

public class Carro {
    private String marca;
    private String modelo;

    public Carro(String marca, String modelo){
        this.marca = "Gol";
        this.modelo = "Wolks";
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public static void main(String[] args) {
        Carro carroParametro = new Carro("Fiat", "Uno");
        System.out.println("A marca é " + carroParametro.getMarca());
        System.out.println("O modelo é " + carroParametro.getModelo());
    }
}
