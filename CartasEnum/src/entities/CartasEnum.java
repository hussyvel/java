package entities;

public class CartasEnum {

    public enum Cartas {
        j(11), q(12), k(13), a(14);

        public int valorCarta;

        Cartas(int valor){
            this.valorCarta = valor;
        }

        public int getValorCarta(){
            return valorCarta;
        }

    }
}