package PredavanjeTri;

import java.util.Scanner;

public class PravougaonikNula {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Unesite sirinu i visinu pravougaonika: ");
        int width = input.nextInt();
        int height = input.nextInt();
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (i == 0 || j == 0 || i == height - 1 || j == width - 1)
                    System.out.print("*");
                else
                    System.out.print("0");
            }
            System.out.print("\n");
        }
    }
}
