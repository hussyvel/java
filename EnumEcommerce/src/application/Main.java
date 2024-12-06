package application;

import entities.Pedido;
import entities.EstadoDoPedido;


public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        System.out.println("Estado inicial " + Pedido.getEstadoDoPedido());

        Pedido.avancarEstado();
        System.out.println("Estado atualizado " + Pedido.getEstadoDoPedido());

        Pedido.avancarEstado();
        System.out.println("Estado atual: " + Pedido.getEstadoDoPedido());

        Pedido.avancarEstado();
        System.out.println("Estado atual: " + Pedido.getEstadoDoPedido());

        Pedido.avancarEstado();
    }
}