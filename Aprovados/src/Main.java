import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n;
        double media;

        System.out.print("Quantos alunos serão digitados? ");
        n = sc.nextInt();

        String[] nome = new String[n];
        double[] nota1 = new double[n];
        double[] nota2 = new double[n];
        
        for (int i = 0; i < n; i++){
            System.out.println("Digite o nome, primeira e segunda notas ");
            sc.nextLine();
            nome[i] = sc.nextLine();
            nota1[i] = sc.nextDouble();
            nota2[i] = sc.nextDouble();
        }

        for (int i = 0; i < n; i++){
            media = (nota1[i] + nota2[i]) / 2;
            if (media >= 6.0){
                System.out.printf("%s\n", nome[i]);
            }
        }
        sc.close();
    }
}