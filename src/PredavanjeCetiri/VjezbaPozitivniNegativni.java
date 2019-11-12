package PredavanjeCetiri;

import java.util.Arrays;
import java.util.Scanner;

public class VjezbaPozitivniNegativni {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Unesite broj elmenata niza: ");
        int arrayLenght = input.nextInt();

        int[] array = new int[arrayLenght];
        System.out.println("Unesite elmenate niza: ");
        for (int i = 0; i < arrayLenght; ++i)
            array[i] = input.nextInt();

        int[] arrayPositive = new int[arrayLenght];
        int[] arrayNegative = new int[arrayLenght];

        int arrayPositiveSize = 0;
        int arrayNegativeSize = 0;
        for (int e : array)
            if (e < 0)
                arrayNegative[arrayNegativeSize++] = e;
            else
                arrayPositive[arrayPositiveSize++] = e;

        System.out.print("Pozitivni brojevi niza su: ");
        for (int e : arrayPositive)
            System.out.print(e + " ");

        System.out.print("\nNegativni brojevi niza su: ");
        for (int e : arrayNegative)
            System.out.print(e + " ");

    }
}
