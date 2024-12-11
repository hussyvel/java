package application;

import entities.Pedido;

public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        System.out.println("Estado inicial do pedido " + pedido.getEstado());

        pedido.avancarEstado();
        System.out.println("Estado do pedido após avanço: " + pedido.getEstado());

        pedido.avancarEstado();
        System.out.println("Estado do pedido após avanço: " + pedido.getEstado());

        pedido.avancarEstado();
        System.out.println("Estado do pedido após avanço: " + pedido.getEstado());

        pedido.avancarEstado();
    }
}