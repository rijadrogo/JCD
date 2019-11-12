package PredavanjeTri;

import java.util.Scanner;

class Card {

    private double balance;

    Card(double pBalance) {
        balance = pBalance;
    }

    public void charge(double n) {
        if (n <= balance) {
            balance -= n;
            System.out.println("Transakcija je uspjesno izvrsena.");
        } else {
            System.out.println("Nema dovoljno novca na kartici. Trenutno stanje je " + balance +
                    "iznos naplate je " + n);
        }
    }
}

public class VjezbaKartice {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Unesite stanje na kartici: ");
        Card c = new Card(input.nextDouble());

        System.out.println("Unesite nesta: ");
        double naplata = input.nextDouble();
        c.charge(naplata);
    }

}

