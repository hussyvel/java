package fundamentos;

import java.util.Locale;

public class Wrappers {
    public static void main(String[] args) {
        Byte b = 100;
        Short s = 1000;
        Integer i = 1000000000;
        Long l = 10000000000000000L;

        System.out.println(b.byteValue());
        System.out.println(s.toString());
        System.out.println(i * 5);
        System.out.println(l / 3);

        Float f = 123.10F;
        System.out.println(f);

        Double d = 1234.5678;
        System.out.println(d);

        Boolean bo = Boolean.parseBoolean("True");
        System.out.println(bo);
        System.out.println(bo.toString().toUpperCase());

        Character c = '#';
        System.out.println(c + "...");


    }
}
