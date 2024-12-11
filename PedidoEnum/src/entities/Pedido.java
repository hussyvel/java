package entities;

public class Pedido {
    private EstadoPedido estado;    

    public Pedido(){
        this.estado = EstadoPedido.NOVO;
    }
    
    public void avancarEstado(){
        switch (estado) {
            case NOVO : estado = EstadoPedido.PROCESSANDO;
            break;
            case PROCESSANDO: estado = EstadoPedido.ENVIADO;
            break;
            case ENVIADO: estado = EstadoPedido.ENTREGUE;
            break;
            default:System.out.println("O pedido não pode avançar.");
        }
    }
    
    public EstadoPedido getEstado(){
        return estado;
    }
}
