package pl.edu.agh.qa.library;

import pl.edu.agh.qa.items.Book;
import pl.edu.agh.qa.items.Item;
import pl.edu.agh.qa.items.Magazine;
import pl.edu.agh.qa.users.Lecturer;
import pl.edu.agh.qa.users.Student;
import pl.edu.agh.qa.users.User;

public class LibrarySimulator {
    public static void main(String[] args) {

        Library myLibrary = new Library();

        User user1 = new Student("Ania", "Nowak");
        User user2 = new Lecturer("Ania", "Nowak");
        User user3 = new Lecturer("Jan", "Nowak");

        myLibrary.addUserToLibrary(user1, user2, user3);
        System.out.println("Users added to library:");
        myLibrary.printListOfUsers();

        Book item1 = new Book( "M. Twain", "Przygody Tomka Sawyera");
        Item item2 = new Magazine("01/2022", "National Geografic" );
        Magazine item3 = new Magazine(  "01/2022", "Focus");
        Item item4 = new Book("H. Sienkiewicz", "Ogniem i mieczem");
        var item5 = new Book("Mickiewicz A.", "Dziady");
        var item6 = new Magazine("11/2020", "Polityka");
        var item7 = new Magazine("01/2019", "Focus");
        var item8 = new Magazine("01/2019", "Focus");
        var item9 = new Magazine("01/2019", "Focus");

        myLibrary.addItemToLibrary(item1, item2, item3, item4, item2, item5, item6, item7, item8, item9);
        myLibrary.rentItemToUser(new Book("M. Twain", "Przygody Tomka Sawyera"), user1);
        myLibrary.rentItemToUser(new Magazine("01/2022", "National Geografic"), user2);
        myLibrary.rentItemToUser(new Book("H. Sienkiewicz", "Ogniem i mieczem"), user1);
        myLibrary.rentItemToUser(new Magazine("01/2019", "Focus"), user1);
        myLibrary.rentItemToUser(new Magazine("11/2020", "Polityka"), user1);
        myLibrary.rentItemToUser(new Magazine("01/2019", "Focus"), user3);

        myLibrary.importItemsFromFile("\\C:\\Users\\Lenovo\\repos\\librarysimulator\\items.csv");

        System.out.println("List of all books:");
        myLibrary.printListOffAllBooks();
        System.out.println("List of all magazines:");
        myLibrary.printListOffAllMagazines();

        myLibrary.exportUsersWithItemsToFile("C:\\Users\\Lenovo\\repos\\librarysimulator\\libraryExport.csv");
    }
}