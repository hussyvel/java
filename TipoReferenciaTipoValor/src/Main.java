//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Hussyvel");
        Pessoa p2 = p1;

        p2.nome = "atata";

        System.out.println(p1.nome);
        System.out.println(p2.nome);

    }
}