package DesbravandoJavaOO;

public class ContinueBreak {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i == 7) {
                //continue; o continue "pula" o valor 7 da condicional
                break; // o break "querbra" antes do valor 7
            }
            System.out.println(i);
        }
    }
}
