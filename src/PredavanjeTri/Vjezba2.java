package PredavanjeTri;

import java.util.Scanner;

public class Vjezba2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Unesite dva broja: ");

        int x = input.nextInt();
        int y = input.nextInt();

        int remainder = x % y;
        if (remainder == 0)
            System.out.println("Ostatak pri dijeljenju ne postoji");
        else if (remainder < 1000)
            System.out.println("Ostatk je manji od 1000");
        else
            System.out.println("Ostatk je veci od 1000");
    }
}
