package pl.edu.agh.qa.items;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.edu.agh.qa.library.Library;

public class Adding_Items_Tests {

    @Test
    public void itShouldBePossibleToAddNewMagazineToLibrary() {
        Item item1 = new Magazine("01/2002", "National Geographic");
        Library library1 = new Library();
        library1.addItemToLibrary(item1);
        Assert.assertTrue(library1.listOfAllItems.size() > 0);
    }

    @Test
    public void AddingNewBookToLibrary_Test() {
        Item item1 = new Book("W. Szymborska", "Wiersze");
        Library library1 = new Library();
        library1.addItemToLibrary(item1);
        Assert.assertTrue(library1.listOfAllItems.size() > 0);
    }

    @Test
    public void itShouldBePossibleToAddFewItemsToLibrary() {
        Item item1 = new Magazine("01/2002", "National Geographic");
        Item item2 = new Book("W. Szymborska", "Wiersze");
        Book item3 = new Book("A. Sapkowski", "Narrenturm");
        Library library1 = new Library();
        library1.addItemToLibrary(item1, item2, item3);
        Assert.assertTrue(library1.listOfAllItems.size() == 3);
    }

    @Test
    public void itShouldNotBePossibleToAddItemWithNoTitelToLibrary() {
        Item item1 = new Magazine("01/2002", "");
        Library library1 = new Library();
        library1.addItemToLibrary(item1);
        Assert.assertTrue(library1.listOfAllItems.size() == 0);
    }
}
