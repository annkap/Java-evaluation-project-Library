package pl.edu.agh.qa.users;

import pl.edu.agh.qa.items.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private String firstName;
    private String lastName;
    protected int userID;
    protected char typeOfUser;
    protected int maxNumberOfItemsThatCanBeBorrowed;
    private List<Item> listOfBorrowedItems = new ArrayList<>();

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String printListOfBorrowedItemsByUser() {
        String userData = "";
        String id = String.valueOf(getUserID());
        for (int i = 0; i < listOfBorrowedItems.size(); i++) {
            if (i != listOfBorrowedItems.size() - 1) {
                userData = userData + listOfBorrowedItems.get(i).toStringInFileExport() + "; ";
            } else {
                userData = userData + listOfBorrowedItems.get(i).toStringInFileExport();
            }
        }
        return "ID" + id + "[" + userData + "]";
    }

    public String toString() {
        return firstName + ";" + lastName + ";" + userID + ";" + typeOfUser;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public int getMaxNumberOfItemsThatCanBeBorrowed() {
        return maxNumberOfItemsThatCanBeBorrowed;
    }

    public List<Item> getListOfBorrowedItems() {
        return listOfBorrowedItems;
    }
}

