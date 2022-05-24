package pl.edu.agh.qa.library;

import pl.edu.agh.qa.items.Book;
import pl.edu.agh.qa.items.Item;
import pl.edu.agh.qa.items.ItemState;
import pl.edu.agh.qa.items.Magazine;
import pl.edu.agh.qa.users.User;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    public Map<Item, ItemState> listOfAllItems = new HashMap<>(); //public uzyty na potrzeby testow
    public List<User> listOfAllUsers = new ArrayList<>(); //public uzyty na potrzeby testow

    static int id_counter = 1;
    static final int TITLE_POSITION_IN_CSV = 0;
    static final int MAGAZINE_NUMBER_POSITION_IN_CSV = 0;
    static final int AUTHOR_POSITION_IN_CSV = 1;
    static final int AMOUNT_OF_ITEMS_IN_CSV = 2;
    static final int TYPE_OF_ITEM_IN_CSV = 3;

    public void addUserToLibrary(User... users) {
        for (User user : users) {
            user.setUserID(id_counter);
            listOfAllUsers.add(user);
            id_counter++;
        }
    }

    public void printListOfUsers() {
        for (User user : listOfAllUsers)
            System.out.println(user);
    }

    public void addItemToLibrary(Item... items) {
        for (Item item : items) {
            if (listOfAllItems.containsKey(item)) {
                listOfAllItems.get(item).addAnItem();
            } else {
                if (item.getTitle().length() > 0)
                    listOfAllItems.put(item, new ItemState());
            }
        }
    }

    public void addItemToLibrary(Item item, int number) {
        for (int i = 0; i < number; i++) {
            if (listOfAllItems.containsKey(item)) {
                listOfAllItems.get(item).addAnItem();
            } else {
                if (item.getTitle().length() > 0)
                    listOfAllItems.put(item, new ItemState());
            }
        }
    }

    public boolean rentItemToUser(Item item, User user) {
        boolean isItPossibleToRent = false;

        if (listOfAllUsers.contains(user))
            if ((listOfAllItems.containsKey(item) && listOfAllItems.get(item).getNumberOfAvailableItems() > 0)
                    && (user.getMaxNumberOfItemsThatCanBeBorrowed() > user.getListOfBorrowedItems().size())) {
                isItPossibleToRent = listOfAllItems.get(item).borrowAnItem();
                user.getListOfBorrowedItems().add(item);
            }
        return isItPossibleToRent;
    }

    public void printListOffAllMagazines() {
        for (Map.Entry<Item, ItemState> entry : listOfAllItems.entrySet()) {
            if (entry.getKey() instanceof Magazine)
                System.out.println(entry.getKey() + ";" + entry.getValue().getNumberOfItemsInTheLibrary() + ";" + entry.getValue().getNumberOfAvailableItems());
        }
    }

    public void printListOffAllBooks() {
        for (Map.Entry<Item, ItemState> entry : listOfAllItems.entrySet()) {
            if (entry.getKey() instanceof Book)
                System.out.println(entry.getKey().toString() + ";" + entry.getValue().getNumberOfItemsInTheLibrary() + ";" + entry.getValue().getNumberOfAvailableItems());
        }
    }

    public void importItemsFromFile(String csvFile) {
        File fileWithBooks = new File(csvFile);
        try (FileReader fileReader = new FileReader(fileWithBooks);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] itemData = line.split(";");
                int numberOfItems = Integer.valueOf(itemData[AMOUNT_OF_ITEMS_IN_CSV]);
                if (itemData[TYPE_OF_ITEM_IN_CSV].equals("B")) {
                    addItemToLibrary((new Book(itemData[TITLE_POSITION_IN_CSV], itemData[AUTHOR_POSITION_IN_CSV])), numberOfItems);
                } else if (itemData[TYPE_OF_ITEM_IN_CSV].equals("M")) {
                    addItemToLibrary((new Magazine(itemData[MAGAZINE_NUMBER_POSITION_IN_CSV], itemData[AUTHOR_POSITION_IN_CSV])), numberOfItems);
                } else {
                    System.out.println("Incorrect type of item.");
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    public void exportUsersWithItemsToFile(String csvFile) {
        File fileWithBooks = new File(csvFile);
        boolean append = false;
        for (User user : listOfAllUsers) {
            if (user.getListOfBorrowedItems().size() > 0) {
                try (FileWriter fileWriter = new FileWriter(fileWithBooks, append); //jesli juz jest jakas tresc to ja kasuje i dodaje nowe linijki, przy append true nadpisuje istniejacy plik
                     BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                    bufferedWriter.append(user.printListOfBorrowedItemsByUser());
                    bufferedWriter.newLine();
                    append = true;

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

