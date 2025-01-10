import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Hussyvel");
        list.add("Edinara");
        list.add("Ethan");
        list.add("João");
        list.add(2,"Marco");

        System.out.println(list.size());
        for (String a : list){
            System.out.println(a);
        }

        System.out.println("----------");
        list.set(1,"Fernanda");

        for (String a : list){
            System.out.println(a);
        }

        System.out.println("-----------");
        list.remove(2);
        for (String a : list){
            System.out.println(a);
        }

    }
}