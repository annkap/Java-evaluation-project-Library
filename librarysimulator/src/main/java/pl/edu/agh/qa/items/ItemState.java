package pl.edu.agh.qa.items;

public class ItemState {
    private int numberOfItemsInTheLibrary;
    private int numberOfAvailableItems;

    public ItemState() {
        this(1, 1);
    }

    public ItemState(int numberOfItemsInTheLibrary, int numberOfBorrowedItems) {
        this.numberOfItemsInTheLibrary = numberOfItemsInTheLibrary;
        this.numberOfAvailableItems = numberOfBorrowedItems;
    }

   public void addAnItem() {
        numberOfItemsInTheLibrary++;
        numberOfAvailableItems++;
    }

    public boolean borrowAnItem() {
        boolean result = false;
        if (numberOfAvailableItems > 0) {
            numberOfAvailableItems--;
            result = true;
        }
        return result;
    }

    public int getNumberOfItemsInTheLibrary() {
        return numberOfItemsInTheLibrary;
    }

    public int getNumberOfAvailableItems() {
        return numberOfAvailableItems;
    }

}





