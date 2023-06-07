package DesbravandoJavaOO;

import java.awt.*;

public class CalculadoraDeEstoque {
    public static void main(String args[]){
        double soma = 0;
        for(double i = 0; i < 35; i++){
            soma += 59.90;
            System.out.println(soma);
        }


        if (soma > 1500){
            System.out.println("Seu estoque está muito baixo!");
        } else if (soma <= 2000) {
            System.out.println("Seu estoque está muito alto");
        }else {
            System.out.println("Seu estoque está bom");
        }
    }
}
