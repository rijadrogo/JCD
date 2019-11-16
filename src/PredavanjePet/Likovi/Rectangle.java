package PredavanjePet.Likovi;

public class Rectangle extends Shape {
    private double w;
    private double h;

    public Rectangle(double x, double y, String ime, String boja, double width, double height) {
        super(x, y, ime, boja);
        w = width;
        h = height;
    }

    public double Povrsina() {
        return w * h;
    }

    public double Obim() {
        return 2 * w + 2 * h;
    }
}
