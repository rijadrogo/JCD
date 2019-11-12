package PredavanjeTri;

public class TablicaMnozenja {
    public static void main(String[] args) {
        System.out.println("********************************");
        System.out.printf("%-10c%-10d%-10d%-10d\n", '#', 1, 2, 3);
        System.out.println("********************************");
        for (int i = 1; i <= 10; ++i) {
            System.out.printf("%-10d", i);
            for (int j = 1; j <= 3; ++j) {
                System.out.printf("%-10d", i * j);
            }
            System.out.print("\n");
        }
    }
}
