package PredavanjeTri;

class RecursionControl {
    public int value;
}

public class Rekurzija {
    public static void main(String[] args) {
        System.out.print(happening(4));

        RecursionControl stop = new RecursionControl();
        int start = 5;
        stop.value = 2;
        counter(start, stop);
    }

    public static void counter(int start, RecursionControl stop) {
        System.out.println("Hey i am called");
        if (stop.value > start) {
            return;
        }
        ++stop.value;
        counter(start--, stop);
    }

    public static int happening(int num) {
        if (num == 1)
            return 1;

        return happening(num - 1) + num;
    }
}
