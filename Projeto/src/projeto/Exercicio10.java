package projeto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.Date;


public class Exercicio10 {
    public static void main(String[] args) throws ParseException {
        diferencaData();
    }

    public static void diferencaData() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date firstDate = sdf.parse("01/02/2022");
        Date secondDate = sdf.parse("01/02/2022");

        long diffEmMil = Math.abs(secondDate.getTime() - firstDate.getTime());
        long diferenca = TimeUnit.DAYS.convert(diffEmMil, TimeUnit.MILLISECONDS);

        if (diferenca == 0) {
            System.out.println("As Datas são iguais, por favor digite outra data");
        } else {
            System.out.println("Qual a diferença entre esses dois meses é de " + diferenca + " dias");
        }
    }
}
