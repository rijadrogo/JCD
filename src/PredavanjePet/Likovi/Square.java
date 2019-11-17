package PredavanjePet.Likovi;

public class Square extends Shape {
    private double stranica;

    public Square(double x, double y, String ime, String boja, double stranica) {
        super(x, y, ime, boja);
        this.stranica = stranica;
    }

    public final double Povrsina() {
        return stranica * stranica;
    }

    public final double Obim() {
        return 4 * stranica;
    }

    @Override
    public void Info() {
        InternalInfo();
        System.out.println(" Stranica kvadrata je " + stranica + ".");
    }
}
