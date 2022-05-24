package pl.edu.agh.qa.library;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.edu.agh.qa.items.Book;
import pl.edu.agh.qa.items.Item;
import pl.edu.agh.qa.users.Lecturer;
import pl.edu.agh.qa.users.Student;
import pl.edu.agh.qa.users.User;

public class Library_Tests {

    @Test
    public void itShouldBePossibleToBorrowAnItemToUser_Test() {
        User u1 = new Student("Jan", "Kowalski");
        Item i1 = new Book("A. Sapkowski", "Narrenturm");
        Library l1 = new Library();
        l1.addUserToLibrary(u1);
        l1.addItemToLibrary(i1);
        Assert.assertTrue(l1.rentItemToUser(i1, u1));
    }

    @Test
    public void itShouldNotBePossibleToBorrowAnItemToUserNotAddedToLibrary_Test() {
        User u1 = new Student("Jan", "Kowalski");
        User u2 = new Student("Jan", "Kowalski");
        Item i1 = new Book("A. Sapkowski", "Narrenturm");
        Library l1 = new Library();
        l1.addUserToLibrary(u1);
        l1.addItemToLibrary(i1);
        Assert.assertFalse(l1.rentItemToUser(i1, u2));
    }

    @Test
    public void itShouldNotBePossibleToBorrowAnItemToUserIfItemIsNotAvailableInLibrary_Test() {
        User u1 = new Student("Jan", "Kowalski");
        Item i1 = new Book("A. Sapkowski", "Narrenturm");
        Item i2 = new Book("A. Sapkowski", "Narrenturm");
        Library l1 = new Library();
        l1.addUserToLibrary(u1);
        l1.addItemToLibrary(i1);
        l1.rentItemToUser(i1, u1);
        Assert.assertFalse(l1.rentItemToUser(i2, u1));
    }

    @Test
    public void itShouldNotBePossibleToBorrowMoreItemsThanAreAvailableInTheLibrary_Test() {
        User u1 = new Student("Jan", "Kowalski");
        Item i1 = new Book("A. Sapkowski", "Narrenturm");
        Item i2 = new Book("A. Sapkowski", "Narrenturm");//not added to Library
        Library l1 = new Library();
        l1.addUserToLibrary(u1);
        l1.addItemToLibrary(i1);
        l1.rentItemToUser(i1, u1);
        Assert.assertFalse(l1.rentItemToUser(i2, u1));
    }

    @Test
    public void itShouldNotBePossibleToBorrowOneItemToTwoDifferentUsers_Test() {
        User u1 = new Student("Jan", "Kowalski");
        User u2 = new Student("Jan", "Kowalski");
        Item i1 = new Book("A. Sapkowski", "Narrenturm");
        Library l1 = new Library();
        l1.addUserToLibrary(u1, u2);
        l1.addItemToLibrary(i1);
        l1.rentItemToUser(i1, u1);
        Assert.assertFalse(l1.rentItemToUser(i1, u2));
    }

    @Test
    public void itShouldBePossibleToRent4ItemsToStudent_Test() {
        Student s1 = new Student("Jan", "Kowalski");
        Book b1 = new Book("A. Sapkowski", "Narrenturm");
        Library l1 = new Library();
        l1.addUserToLibrary(s1);
        l1.addItemToLibrary(b1, 4);
        l1.rentItemToUser(b1, s1);
        l1.rentItemToUser(b1, s1);
        l1.rentItemToUser(b1, s1);
        Assert.assertTrue(l1.rentItemToUser(b1, s1));
    }

    @Test
    public void itShouldNotBePossibleToRent5ItemsToStudent_Test() {
        Student s1 = new Student("Jan", "Kowalski");
        Book b1 = new Book("Narrenturm", "A. Sapkowski");
        Library l1 = new Library();
        l1.addUserToLibrary(s1);
        l1.addItemToLibrary(b1, 5);
        l1.rentItemToUser(b1, s1);
        l1.rentItemToUser(b1, s1);
        l1.rentItemToUser(b1, s1);
        l1.rentItemToUser(b1, s1);
        Assert.assertFalse(l1.rentItemToUser(b1, s1));
    }

    @Test
    public void itShouldBePossibleToRent10ItemsToLecturer_Test() {
        Lecturer lec1 = new Lecturer("Jan", "Kowalski");
        Book b1 = new Book("A. Sapkowski", "Narrenturm");
        Library l1 = new Library();
        l1.addUserToLibrary(lec1);
        l1.addItemToLibrary(b1, 10);
        l1.rentItemToUser(b1, lec1);
        l1.rentItemToUser(b1, lec1);
        l1.rentItemToUser(b1, lec1);
        l1.rentItemToUser(b1, lec1);
        l1.rentItemToUser(b1, lec1);
        l1.rentItemToUser(b1, lec1);
        l1.rentItemToUser(b1, lec1);
        l1.rentItemToUser(b1, lec1);
        l1.rentItemToUser(b1, lec1);
        Assert.assertTrue(l1.rentItemToUser(b1, lec1));
    }

    @Test
    public void itShouldNotBePossibleToRent11ItemsToLecturer_Test() {
        Lecturer lec1 = new Lecturer("Jan", "Kowalski");
        Book b1 = new Book("A. Sapkowski", "Narrenturm");
        Library l1 = new Library();
        l1.addUserToLibrary(lec1);
        l1.addItemToLibrary(b1, 10);
        l1.rentItemToUser(b1, lec1);
        l1.rentItemToUser(b1, lec1);
        l1.rentItemToUser(b1, lec1);
        l1.rentItemToUser(b1, lec1);
        l1.rentItemToUser(b1, lec1);
        l1.rentItemToUser(b1, lec1);
        l1.rentItemToUser(b1, lec1);
        l1.rentItemToUser(b1, lec1);
        l1.rentItemToUser(b1, lec1);
        l1.rentItemToUser(b1, lec1);
        Assert.assertFalse(l1.rentItemToUser(b1, lec1));
    }

    @Test
    public void isShouldBePossibleToImportItemsFromCSV_Test() {
        Library library = new Library();
        library.importItemsFromFile("\\C:\\Users\\Lenovo\\repos\\librarysimulator\\items.csv");
        boolean doesLibraryContainsItemFromCSV = library.listOfAllItems.containsKey(new Book("Ogniem i mieczem", "H. Sienkiewicz"));
        Assert.assertTrue(doesLibraryContainsItemFromCSV);
    }
}
