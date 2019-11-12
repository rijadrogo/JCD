package PredavanjeTri;

import java.util.Random;
import java.util.Scanner;

public class RandomGenerator {
    static public void main(String[] args) {
        Random rg = new Random();
        int randomNumber = rg.nextInt(10);
        Scanner input = new Scanner(System.in);
        System.out.println("Koji broj sam zamislio?");
        while (true) {
            System.out.println("Unesi broj");
            int guessedNumber = input.nextInt();
            if (randomNumber == guessedNumber) {
                System.out.println("Jeste!");
                break;
            } else {
                System.out.println("Nije!");
            }
        }
    }
}
