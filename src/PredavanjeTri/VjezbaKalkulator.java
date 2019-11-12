package PredavanjeTri;

import java.util.Scanner;

public class VjezbaKalkulator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Unesite operaciju koju zelite izvrsiti: ");
        char operation = input.next().charAt(0);
        System.out.println("Unesite dva operanda");
        double x = input.nextDouble();
        double y = input.nextDouble();
        if (operation == '+') {
            System.out.println("Rezultat je: " + (x + y));
        } else if (operation == '-') {
            System.out.println("Rezultat je: " + (x - y));
        } else if (operation == '*') {
            System.out.println("Rezultat je: " + (x * y));
        } else if (operation == '/') {
            System.out.println("Rezultat je: " + (x / y));
        } else {
            System.out.println("Unijeli ste nepoznatu operaciju");
        }
    }
}
