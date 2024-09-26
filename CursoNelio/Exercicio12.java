package CursoNelio;

import java.util.Locale;
import java.util.SplittableRandom;

public class Exercicio12 {
    public static void main(String[] args) {

        String original = "abcde FGHIJ ABC abc DEFG    ";
        String s01 = original.toLowerCase();
        String s02 = original.toUpperCase();
        String s03 = original.trim();
        String s04 = original.substring(2);
        String s05 = original.substring(2, 9);
        String s06 = original.replace('a', 'x');
        String s07 = original.replace("abc", "xy");
        int i = original.indexOf("bc");
        int j = original.lastIndexOf("bc");

        System.out.println("Com toLowerCase -" + s01 + "-");
        System.out.println("Com toUpperCase -" + s02 + "-");
        System.out.println("Original -" + original + "-");
        System.out.println("trim -" + s03 + "-");
        System.out.println("substring -" + s04 + "-");
        System.out.println("recorte -" + s05 + "-");
        System.out.println("replace ('a', 'x'): -" + s06 + "-");
        System.out.println("replace ('abc', 'xy'): -" + s07 + "-");
        System.out.println(i);
        System.out.println(j);
    }
}
