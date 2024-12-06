package boxing;

public class Boxing {

    public static void main(String[] args) {

    int x = 10;

    Object obj = x;

    System.out.println(obj);

    int y = (int) obj * 5;

    System.out.println(y);

    }
}