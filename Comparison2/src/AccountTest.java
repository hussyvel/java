import java.util.Scanner;

public class AccountTest {

    public static void main(String[] args) {

        Account account1 = new Account();
        Account account2 = new Account();

        System.out.printf("Initial name is %s%n%n", account1.getName());
        System.out.printf("Initial name is %s%n%n", account2.getName());

        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Please enter the name:");

            String name = input.nextLine();
            account1.setName(name);
        }

        System.out.println();
        System.out.printf("Name in object myAccount is:%n%s%n", account1.getName());
        System.out.printf("Name in object myAccount is:%n%s%n", account2.getName());
    }
}