package bankThing;

public class Visa implements ICard {
    private double amount;

    @Override
    public void getMoney(double amount) {
        this.amount -= amount;
    }

    @Override
    public boolean validate() {

        return false;
    }
}
