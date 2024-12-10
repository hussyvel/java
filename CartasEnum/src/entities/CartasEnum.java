package entities;

public class CartasEnum {

    public enum TipoDeCartas{
        j(11), q(12), l(13), k(14);

        private final int valorDasCartas;

        TipoDeCartas(int quaquerVariavelaqui){
            this.valorDasCartas = quaquerVariavelaqui;
        }

        public int getValorDasCartas(){
            return valorDasCartas;
        }
    }
}