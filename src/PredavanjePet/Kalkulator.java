package PredavanjePet;

import javax.xml.transform.sax.SAXSource;

public class Kalkulator {
    private double operand1;
    private double operand2;

    Kalkulator(double x, double y) {
        operand1 = x;
        operand2 = y;
    }

    public double add() {
        return operand1 + operand2;
    }

    public double sub() {
        return operand1 - operand2;
    }

    public double mul() {
        return operand1 * operand2;
    }

    public double div() {
        return operand1 / operand2;
    }

    public static void main(String[] args) {
        Kalkulator k = new Kalkulator(5, 8);
        double rez = k.add() + k.div() * k.mul() - k.sub();
        System.out.print(rez);
    }
}
