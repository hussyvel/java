package CursoNelio.aplication;

public class AreaCalc {
    public static void main(String[] args) {
        double b, B, h, area;

        b = 6.0;
        B = 8.0;
        h = 5.0;

        area = (b + B) / 2.0 * h;

        System.out.printf("O valor da área é %.2f %n" ,area);
    }
}
