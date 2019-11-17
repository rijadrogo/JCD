package PredavanjeCetiri.Biblioteka;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public boolean addBook(Book b) {
        for (Object o : books) {
            Book book = (Book) o;
            if (book.equals(b))
                return false;
        }
        books.add(b);
        return true;
    }

    public void showAllBooks() {
        for (Object o : books) {
            ((Book) o).printBookDetails();
            System.out.println();
        }
    }

    public boolean removeBook(Book b) {
        for (Object o : books) {
            Book book = (Book) o;
            if (book.equals(b)) {
                books.remove(o);
                return true;
            }
        }
        return false;
    }

    public boolean showBookDetails(Book b) {
        for (Object o : books) {
            Book book = (Book) o;
            if (book.equals(b)) {
                book.printBookDetails();
                return true;
            }
        }
        return false;
    }

}
