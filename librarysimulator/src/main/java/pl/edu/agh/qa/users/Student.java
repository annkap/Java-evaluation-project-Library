package pl.edu.agh.qa.users;

public class Student extends User {

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
        this.typeOfUser = 'S';
        this.maxNumberOfItemsThatCanBeBorrowed = 4;
    }
}
