package PredavanjeCetiri;

import java.util.Random;
import java.util.Scanner;

class Statistika {
    private int korisnik;
    private int racunar;
    private int brojIgara;

    public Statistika() {
        korisnik = 0;
        racunar = 0;
        brojIgara = 0;
    }

    public void rezultat(int k, int r) {
        ++brojIgara;
        // kamen
        if (k == 0) {
            System.out.println("Korisnik je odigrao kamen.");
            // makaze
            if (r == 1) {
                System.out.println("Racunar je odigrao makaze.");
                ++korisnik;
                return;
            }
            // papir
            if (r == 2) {
                System.out.println("Racunar je odigrao papir.");
                ++racunar;
                return;
            }
            // kamen
            System.out.println("Racunar je odigrao kamen.");
            return;
        }
        // makaze
        if (k == 1) {
            System.out.println("Korisnik je odigrao makaze.");
            // kamen
            if (r == 0) {
                System.out.println("Racunar je odigrao kamen.");
                ++racunar;
                return;
            }
            // papir
            if (r == 2) {
                System.out.println("Racunar je odigrao papir.");
                ++korisnik;
            }
            // makaze
            System.out.println("Racunar je odigrao makaze.");
            return;
        }
        // papir
        // k == 2
        System.out.println("Korisnik je odigrao papir.");
        // kamen
        if (r == 0) {
            System.out.println("Racunar je odigrao kamen.");
            ++korisnik;
            return;
        }
        // makaze
        if (r == 1) {
            System.out.println("Racunar je odigrao makaze.");
            ++racunar;
            return;
        }
        // papir
        System.out.println("Racunar je odigrao papir.");

    }

    public void ispisiStatistiku() {
        System.out.println("Odigrano je: " + brojIgara + " meceva.");
        System.out.println("Korisnik je pobjedio " + korisnik + " puta, dok je racunar pobjedio " + racunar + " puta.\n");
    }

}

public class ZimZamZum {
    public static void main(String[] args) {
        Random racunar = new Random();
        Scanner input = new Scanner(System.in);
        Statistika st = new Statistika();
        while (true) {
            System.out.println("1. Kamen\n2. Makaze\n3. Papir\n4. Statistika");
            System.out.println("Unesite broj od 1 do 3: ");
            int korisnik = input.nextInt();
            if (korisnik == 4) {
                st.ispisiStatistiku();
                continue;
            }
            if (korisnik != 1 && korisnik != 2 && korisnik != 3) {
                break;
            }
            st.rezultat(korisnik - 1, racunar.nextInt(2));
        }
        st.ispisiStatistiku();
    }
}
