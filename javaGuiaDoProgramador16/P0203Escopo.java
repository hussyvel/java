
public class P0203Escopo {

    public static void main(String[] args) {
        int x = 5;
        {
            int y = 0;
            y = x * 5;
            System.out.println(x); //5
            {
                x = 10;
                System.out.println(x); //10
                System.out.println(y); //25
            }
        }
        System.out.println(x); //5
       // System.out.println(y);
    }
}