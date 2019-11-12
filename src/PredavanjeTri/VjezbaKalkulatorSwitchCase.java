package PredavanjeTri;

import java.util.Scanner;

public class VjezbaKalkulatorSwitchCase {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Unesite operaciju koju zelite izvrsiti: ");
        char operation = input.next().charAt(0);
        System.out.println("Unesite dva operanda");
        double x = input.nextDouble();
        double y = input.nextDouble();
        switch (operation) {
            case '+':
                System.out.println("Rezultat je: " + (x + y));
                break;
            case '-':
                System.out.println("Rezultat je: " + (x - y));
                break;
            case '*':
                System.out.println("Rezultat je: " + (x * y));
                break;
            case '/':
                System.out.println("Rezultat je: " + (x / y));
                break;
            default:
                System.out.println("Unijeli ste nepoznatu operaciju");
        }

    }
}
