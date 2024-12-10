package application;

import entities.Cartas;

public class Main {
    public static void main(String[] args) {
        TipoCarta cartaJ = TipoCarta.J;
        TipoCarta cartaQ = TipoCarta.Q;

        System.out.println("Carta: " + cartaJ + " | Valor: " + cartaJ.getValorCarta());
        System.out.println("Carta: " + cartaQ + " | Valor: " + cartaQ.getValorCarta());
    }
}
