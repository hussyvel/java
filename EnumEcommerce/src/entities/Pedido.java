package entities;

public class Pedido {
    private static EstadoDoPedido estadoDoPedido;

    public Pedido(){
        this.estadoDoPedido = EstadoDoPedido.NOVO;
    }

    public static void avancarEstado(){
        switch (estadoDoPedido){
            case NOVO:
                estadoDoPedido = EstadoDoPedido.PROCESSANDO;
                break;
            case PROCESSANDO:
                estadoDoPedido = EstadoDoPedido.ENVIADO;
                break;
            case ENVIADO:
                estadoDoPedido = EstadoDoPedido.ENTREGUE;
                break;
            default:
                System.out.println("Não é possível avançar ainda mais o estado." + estadoDoPedido);
        }
    }

    public static EstadoDoPedido getEstadoDoPedido(){
        return estadoDoPedido;
    }
}
