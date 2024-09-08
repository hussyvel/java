import java.io.IOException;

public class EntradaNãoFormatada {

    public static void main(String[] args) {
        System.out.println("Pressione uma tecla e depois Enter: ");

        try {
            int input = System.in.read();
            char character = (char) input;

            System.out.println("Você pressionou: " + character);
            System.out.println("O valor ASCII é: " + input);
        } catch (IOException i){
            i.printStackTrace();
        }
    }
}
