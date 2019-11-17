package PredavanjeCetiri.Biblioteka;

public class Book {
    private String title;
    private String author;
    private int isbn;

    public Book(String pTitle, String pAuthor, int pIsbn) {
        title = pTitle;
        author = pAuthor;
        isbn = pIsbn;
    }

    void printBookDetails() {
        System.out.println("Title: " + title + ".\nAuthor: " + author + ".\nInternational standard book numer: " + isbn);
    }
}
