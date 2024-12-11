package entities;

public class Pedido {
    private EstadoPedido estado;

    public Pedido() {
        this.estado = EstadoPedido.NOVO;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido novoestado) {
        this.estado = novoestado;
    }

    public boolean seEnviado(){
        return estado.equals(EstadoPedido.ENVIADO);
    }
}
