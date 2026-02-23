public class CalculoDelta {
    public static void main(String[] args) {
        var a = 1.0;
        var b = -3.0;
        var c = -10.0;

        var delta = Math.pow(b, 2) - (4 * a * c);

        var x1 = (-b + Math.sqrt(delta)) / (2 * a);
        var x2 = (-b - Math.sqrt(delta)) / (2 * a);

        System.out.println(x1);
        System.out.println(x2);
        System.out.println(delta);
    }
}
