package pl.edu.agh.qa.users;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.edu.agh.qa.library.Library;

public class Adding_Users_Tests {

    @Test
    public void itShouldBePossibleToAddLecturerToLibraryTest() {
        User user1 = new Lecturer("Jan", "Kowalski");
        Library library = new Library();
        library.addUserToLibrary(user1);
        Assert.assertNotNull(library.listOfAllUsers.size());
    }

    @Test
    public void itShouldBePossibleToAddStudentToLibraryTest() {
        User user1 = new Student("Jan", "Kowalski");
        Library library = new Library();
        library.addUserToLibrary(user1);
        Assert.assertNotNull(library.listOfAllUsers.size());
    }

    @Test
    public void itShouldBePossibleToAddFewUsersToLibraryTest() {
        User user1 = new Student("Jan", "Kowalski");
        User user2 = new Lecturer("Paweł", "Kowalski");
        User user3 = new Student("Anna", "Kowalska");
        Library library3 = new Library();
        library3.addUserToLibrary(user1, user2, user3);
        Assert.assertEquals(library3.listOfAllUsers.size(), 3);
    }

    @Test
    public void itShouldBePossibleToAddFewUsersWithTheSameNameToLibraryTest() {
        User user1 = new Student("Jan", "Kowalski");
        User user2 = new Student("Jan", "Kowalski");
        User user3 = new Lecturer("Jan", "Kowalski");
        Library library = new Library();
        library.addUserToLibrary(user1, user2, user3);
        Assert.assertTrue(library.listOfAllUsers.size() == 3);
    }

    @Test
    public void isShouldBeEmptyLibraryIfNoUserAddedTest() {
        Library library2 = new Library();
        Assert.assertTrue(library2.listOfAllUsers.size() == 0);
    }
}
