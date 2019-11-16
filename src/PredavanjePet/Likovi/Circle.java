package PredavanjePet.Likovi;

public class Circle extends Shape {
    private double poluprecnik;

    public final static double Pi = 4 * Math.atan(1.);

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
