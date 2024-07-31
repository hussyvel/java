import java.util.Locale;
import java.util.Scanner;

public class UriOnline_1009 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        Locale.setDefault(new Locale("en", "US"));

        String nome;
        double salario_fixo;
        final double COMISSAO_PERCENTUAL = 0.15;
        double vendas;
        double comissao;
        double salario_total;

        nome = sc.next();
        salario_fixo = sc.nextDouble();
        vendas = sc.nextDouble();

        comissao = vendas + COMISSAO_PERCENTUAL;
        salario_total = salario_fixo + comissao;


        System.out.printf("Com os acréscimos de 15%: %.2f%n", salario_total );

        sc.close();
    }
}
