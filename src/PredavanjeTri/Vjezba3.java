package PredavanjeTri;

import java.util.Scanner;

public class Vjezba3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Unesite proizvodjaca automobila: ");
        String carMake = input.nextLine();
        System.out.println("Unesite broj vrata");

        int doors = input.nextInt();
        if (carMake.toLowerCase().equals("ford")) {
            System.out.println("Marka automobila je ford, ima " + doors + " vrata.");
        } else {
            System.out.println("Marka automobila nepoznata, ima " + doors + " vrata.");
        }
    }
}
