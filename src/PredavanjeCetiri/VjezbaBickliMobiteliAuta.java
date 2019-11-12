package PredavanjeCetiri;

public class VjezbaBickliMobiteliAuta {
    public static void main(String[] args) {
        String[] items = {"Bicycle", "Car", "Mobile Phone"};
        String[] itemNames = {"Bmx", "Renault 4", "I-Phone"};
        double[] costOfItems = {150.55, 100, 500};
        for (int i = 0; i < items.length; ++i) {
            System.out.println(itemNames[i] + " is type of " + items[i] + " and it costs " + costOfItems[i] + ".");
        }
    }
}
