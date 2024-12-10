package application;

import entities.CartasEnum;

public class Main {
    public static void main(String[] args) {
        for (CartasEnum.Cartas carta: CartasEnum.Cartas.values()){
            System.out.println("Carta: " + carta.name() + " | Valor: " + carta.getValorCarta());
        }
    }
}
