package PredavanjeSest.Vjezba1Parse;

public class Main {
    public static void main(String[] args) {
        String s = "15-Rijad-90";
        User korisnik = new User();
        korisnik.parse(s);
        System.out.println(korisnik.id + "\n" + korisnik.name + "\n" + korisnik.score);
    }
}
