package application;

import entities.Pedido;
import entities.EstadoPedido;

public class Main {
    public static void main(String[] args) {

        Pedido pedido = new Pedido();
        System.out.println("Estado inicial do pedido: " + pedido.getEstado());

        pedido.avancarPedido();
        System.out.println("Estado do pedido após avanço: " + pedido.getEstado());

        pedido.avancarPedido();
        System.out.println("Estado do pedido após avanço: " + pedido.getEstado());

        pedido.avancarPedido();
        System.out.println("Estado do pedido após avanço: " + pedido.getEstado());

        pedido.avancarPedido();
    }
}
