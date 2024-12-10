package application;

import entities.CartasEnum;

public class Main {
    public static void main(String[] args) {
        for (CartasEnum.TipoDeCartas carta: CartasEnum.TipoDeCartas.values()){
            System.out.println("Carta: " + carta.name() + " | Valor: " + carta.getValorDasCartas());
        }
    }
}
