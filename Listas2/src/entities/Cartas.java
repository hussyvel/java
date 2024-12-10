package entities;

public class Cartas {

    public enum TipoDeCarta{
        J(11), Q(12);

        private final int valorCarta;

        TipoDeCarta(int valorCarta){
            this.valorCarta = valorCarta;
        }

        public int getValorCarta(){
            return valorCarta;
        }
    }

}