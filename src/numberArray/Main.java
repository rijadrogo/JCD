package numberArray;

public class Main {
    public static void main(String[] args) {
        NumberArray<Integer> na = new NumberArray<>();
        na.add(5);
        na.add(6);
        for (int i = 0; i < na.size(); ++i) {
            System.out.println(na.get(i));
        }
    }
}
