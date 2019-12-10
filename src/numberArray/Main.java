package numberArray;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(4);
        // System.out.println(a.size());
        a.add(-1);
        a.add(-1);
        a.toArray();

        NumberArray<Integer> arr = new NumberArray<>(2);
        arr.add(5);
        arr.add(5);

        arr.addAll(1, a);

        arr.removeAll((Integer) (-1));
        for (Integer e : arr) {
            System.out.println(e);
        }

    }
}
