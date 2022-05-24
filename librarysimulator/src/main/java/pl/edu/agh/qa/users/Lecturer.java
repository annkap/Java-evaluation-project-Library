package pl.edu.agh.qa.users;

public class Lecturer extends User {

    public Lecturer(String firstName, String lastName) {
        super(firstName, lastName);
        this.typeOfUser = 'L';
        this.maxNumberOfItemsThatCanBeBorrowed = 10;
    }
}