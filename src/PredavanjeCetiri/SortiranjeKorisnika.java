package PredavanjeCetiri;

import java.util.ArrayList;
import java.util.Scanner;

class User {
    public int id;
    public String ime;

    public User(int pId, String pIme) {
        id = pId;
        ime = pIme;
    }

    public void ispisi() {
        System.out.println("Id korsnika je: " + id + ", ime korisnika: " + ime + ".");
    }
}

public class SortiranjeKorisnika {
    public static void main(String[] args) {
        System.out.println("Koliko korisnika zelite unijeti:");
        Scanner input = new Scanner(System.in);
        int brojKorisnika = input.nextInt();

        ArrayList<User> al = new ArrayList<>();
        for (int i = 0; i < brojKorisnika; i++) {
            System.out.println("Unesite id korisnika i njegovo ime: ");
            al.add(new User(input.nextInt(), input.nextLine()));
        }

        for (int i = 0; i < brojKorisnika - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < brojKorisnika; j++) {
                if (al.get(j).id < al.get(minIdx).id) {
                    minIdx = j;
                }
            }
            User tmp = al.get(minIdx);
            al.set(minIdx, al.get(i));
            al.set(i, tmp);
        }

        for (User u : al) {
            u.ispisi();
        }

    }
}
