public class Example01 {
    public static void main(String[] args) {
        int beerNumber = 5;
        String word = "bottles";

        while (beerNumber > 0) {
            if (beerNumber == 1) {
                word = "bottles";
            }
            System.out.println(beerNumber + " " + word + " of beer on the wall");
            System.out.println(beerNumber + " " + word + " of beer");
            System.out.println("Take one down.");
            System.out.println(" Pass it around.");
            beerNumber--;

            if (beerNumber == 0) {
                System.out.println(beerNumber + " " + word + " of beer on the wall");
            }else {
                System.out.println("No more bottles on the wall");
            }
        }
    }
}
