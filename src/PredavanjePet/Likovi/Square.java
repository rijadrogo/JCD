package PredavanjePet.Likovi;

public class Square extends Shape {
    private double stranica;

    public Square(double x, double y, String ime, String boja, double stranica) {
        super(x, y, ime, boja);
        this.stranica = stranica;
    }

    public double Povrsina() {
        return stranica * stranica;
    }

    public double Obim() {
        return 4 * stranica;
    }

    public void Info() {
        InternalInfo();
        System.out.println(" Stranica kvadrata je " + stranica + ".");
    }
}
