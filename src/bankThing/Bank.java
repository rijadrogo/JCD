package bankThing;

public class Bank<T extends ICard> {
    private T card;

    public void pay(double amount) {
        if (!card.validate()) {
            // uradi nesta
        }
        card.getMoney(amount);
    }

}
