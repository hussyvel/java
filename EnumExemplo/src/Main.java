public class Main {
    public enum DiaDaSemana{
        SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO
    }

    public static void main(String[] args) {

        DiaDaSemana hoje = DiaDaSemana.TERCA;

        switch (hoje){
            case SEGUNDA:
                System.out.println("é segunda");
                break;
            case TERCA:
                System.out.println("é terça-feira");
                break;
            case DOMINGO:
                System.out.println("Fim de semana");
                break;
            default:
                System.out.println("Dia útil, continue trabalhando!!!");
                break;
        }
    }
}