package DesbravandoJavaOO;

public class For {
    public static void main(String args[]){
        double soma = 0;

      for(int contador = 0; contador < 35; contador++){
            soma += 59.90;
      }
      System.out.println(soma);

      if (soma <  150){
          System.out.println("O seu estoque está muito baio"+ soma);
      } else if (soma > 2000) {
          System.out.println("O seu estoque está muito alto" + soma);
      }else {
          System.out.println("O seu estoque está dentro do padrão" + soma);
      }
    }
}
