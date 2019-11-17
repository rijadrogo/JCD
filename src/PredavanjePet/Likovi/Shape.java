package PredavanjePet.Likovi;

public abstract class Shape {
    private double x;
    private double y;
    private String ime;
    private String boja;

    public Shape(double x, double y, String ime, String boja) {
        this.x = x;
        this.y = y;
        this.ime = ime;
        this.boja = boja;
    }

    public abstract double Povrsina();

    public abstract double Obim();

    public String Boja() {
        return boja;
    }

    public String Ime() {
        return ime;
    }

    public double XKordinata() {
        return x;
    }

    public double YKordinata() {
        return y;
    }
}
