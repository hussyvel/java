package boxing;

import java.util.ArrayList;

public class BoxingExemplos {

    public static void main(String[] args) {

        ArrayList<Integer> lista = new ArrayList<>();

        long initial = System.currentTimeMillis();
        for (int i = 0; i < 10_000_000; i++){
            lista.add(i);
        }

        long finish = System.currentTimeMillis();

        System.out.println("Tempo gasto: " + (finish - initial) + " ms");
    }
}
