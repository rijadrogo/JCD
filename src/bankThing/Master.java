package bankThing;

public class Master implements ICard {
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
