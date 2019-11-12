package PredavanjeCetiri;

import java.util.Random;

public class VjezbaStringovi {
    public static void main(String[] args) {
        String[] array = {"Heart", "Cherry", "Coin", "Melon", "Jocker"};
        System.out.println("Combination is: ");
        for (int i = 0; i < array.length; ++i) {
            Random randomNumber = new Random();
            int choosen = randomNumber.nextInt(array.length);
            System.out.println(array[choosen] + " ");
        }
    }
}
