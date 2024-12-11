package application;

import entities.EstadoPedido;
import entities.Pedido;

public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();

        System.out.println("Estado inicial " + pedido.getEstado());

        pedido.setEstado(EstadoPedido.ENVIADO);

        if (pedido.getEstado().equals(EstadoPedido.ENVIADO)){
            System.out.println("O pedido foi enviado ");
        }

        if (pedido.seEnviado()){
            System.out.println("Confirmação: o pedido está no estado ENVIADO.");
        }
    }

}