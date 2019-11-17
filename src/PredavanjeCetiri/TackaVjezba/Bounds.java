package PredavanjeCetiri.TackaVjezba;

public class Bounds {
    /*
        Point p je donja lijeva tacka
     */
    public Point p;
    public double width;
    public double height;

    public Bounds(Point pP, double w, double h) {
        p = pP;
        width = w;
        height = h;
    }

    public Bounds(double x, double y, double w, double h) {
        this(new Point(x, y), w, h);
    }
}
