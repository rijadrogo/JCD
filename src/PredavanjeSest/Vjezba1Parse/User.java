package PredavanjeSest.Vjezba1Parse;

public class User {
    public String id;
    public String name;
    public String score;

    void parse(String str) {
        String[] arr = str.split("-");
        id = arr[0];
        name = arr[1];
        score = arr[2];
    }
}
