//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Contagem regressiva:");

        for (int i = 5; i < 0; i++) {
            System.out.println(i);
        }
        System.out.println("Fora do escopo");
    }
}