import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Hussyvel");
        list.add("Edinara");
        list.add("Ethan");
        list.add("João");
        list.add("Juarez");
        list.add("Aldaíres");
        list.add("Voinha");
        list.add("Fernanda");
        list.add("Silva");


        list.add(2, "Dêniel");


        list.remove("Voinha");
        for (String a : list){
            System.out.println(a);
        }

    }
}