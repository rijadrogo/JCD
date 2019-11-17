package PredavanjeCetiri.TackaVjezba;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Unesite broj tacaka koje zelite unijeti: ");
        Scanner input = new Scanner(System.in);
        int brojTacaka = input.nextInt();
        List points = new ArrayList();
        for (int i = 0; i < brojTacaka; i++) {
            System.out.println("Unesite x i y koordinate tacke " + (i + 1) + ": ");
            double x = input.nextDouble();
            double y = input.nextDouble();
            points.add(new Point(x, y));
        }
        System.out.println("Unesite zonu\nUnesite pocetnu tacku zone: ");
        double x = input.nextDouble();
        double y = input.nextDouble();

        System.out.println("Unesite visinu i sirinu zone: ");
        double h = input.nextDouble();
        double w = input.nextDouble();
        Bounds b = new Bounds(x, y, w, h);

        double leftX = b.p.x;
        double rightX = b.p.x + b.width;
        double upperY = b.p.y + b.height;
        double lowerY = b.p.y;

        System.out.println("Tacke unutar zone su:\n");
        for (Object point : points) {
            Point currentPoint = (Point) point;
            if (currentPoint.x >= leftX && currentPoint.x <= rightX && currentPoint.y >= lowerY && currentPoint.y <= upperY) {
                System.out.println("'" + currentPoint.x + ", " + currentPoint.y + "'\n");
            }
        }

    }
}
