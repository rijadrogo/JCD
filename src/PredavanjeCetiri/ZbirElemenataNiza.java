package PredavanjeCetiri;

import java.util.Scanner;

public class ZbirElemenataNiza {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Unesite broj elmenata niza: ");
        int arrayLenght1 = input.nextInt();

        int[] array1 = new int[arrayLenght1];
        System.out.println("Unesite elmenate niza 1: ");
        for (int i = 0; i < arrayLenght1; ++i)
            array1[i] = input.nextInt();

        int[] array2 = new int[arrayLenght1];
        System.out.println("Unesite elmenate niza 2: ");
        for (int i = 0; i < arrayLenght1; ++i)
            array2[i] = input.nextInt();

        int[] result = new int[arrayLenght1];
        for (int i = 0; i < arrayLenght1; ++i)
            result[i] = array1[i] + array2[i];

        System.out.println("Elementi rezultirajuceg niza s: ");
        for (int i = 0; i < arrayLenght1; ++i)
            System.out.print(result[i] + " ");
    }
}
