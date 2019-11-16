package PredavanjePet.Likovi;

public class Circle extends Shape {
    private double poluprecnik;

    public static double Pi = Math.atan(1) * 4.;

    public Circle(double x, double y, String ime, String boja, double poluprecnik) {
        super(x, y, ime, boja);
        this.poluprecnik = poluprecnik;
    }

    public double Povrsina() {
        return poluprecnik * poluprecnik * Pi;
    }

    public double Obim() {
        return 2 * poluprecnik * Pi;
    }

}
