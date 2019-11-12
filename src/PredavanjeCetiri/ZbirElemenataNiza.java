package PredavanjeCetiri;

import java.util.Scanner;

public class ZbirElemenataNiza {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Unesite broj elmenata niza: ");
        int arrayLength1 = input.nextInt();

        int[] array1 = new int[arrayLength1];
        System.out.println("Unesite elmenate niza 1: ");
        for (int i = 0; i < arrayLength1; ++i)
            array1[i] = input.nextInt();

        int[] array2 = new int[arrayLength1];
        System.out.println("Unesite elmenate niza 2: ");
        for (int i = 0; i < arrayLength1; ++i)
            array2[i] = input.nextInt();

        int[] result = new int[arrayLength1];
        for (int i = 0; i < arrayLength1; ++i)
            result[i] = array1[i] + array2[i];

        System.out.println("Elementi rezultirajuceg niza su: ");
        for (int e : result)
            System.out.print(e + " ");
    }
}
