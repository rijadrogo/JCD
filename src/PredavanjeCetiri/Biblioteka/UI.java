package PredavanjeCetiri.Biblioteka;

import java.util.Scanner;

public class UI {
    public int mainMenu() {
        System.out.println("1. Add book, 2. Show all books, 3. Remove book, 4. Show book details 5. Exit program\nChoose option: ");
        return new Scanner(System.in).nextInt();
    }

    public static void main(String[] args) {
        Library l = new Library();
        UI program = new UI();
        Scanner input = new Scanner(System.in);
        while (true) {
            int option = program.mainMenu();
            switch (option) {
                case 1: {
                    System.out.println("Unesite naslov knjige: ");
                    String title = input.nextLine();
                    System.out.println("Unesite autora knjige: ");
                    String autor = input.nextLine();
                    System.out.println("Unesite isbn knjige: ");
                    int isbn = input.nextInt();
                    l.addBook(new Book(title, autor, isbn));
                    break;
                }
                case 2:
                    l.showAllBooks();
                    break;
                case 3: {
                    System.out.println("Unesite naslov knjige: ");
                    String title = input.nextLine();
                    System.out.println("Unesite autora knjige: ");
                    String autor = input.nextLine();
                    System.out.println("Unesite isbn knjige: ");
                    int isbn = input.nextInt();
                    l.removeBook(new Book(title, autor, isbn));
                }
                case 4: {
                    System.out.println("Unesite naslov knjige: ");
                    String title = input.nextLine();
                    System.out.println("Unesite autora knjige: ");
                    String autor = input.nextLine();
                    System.out.println("Unesite isbn knjige: ");
                    int isbn = input.nextInt();
                    l.showBookDetails(new Book(title, autor, isbn));
                }
                case 5:
                    return;
            }
        }
    }

}
