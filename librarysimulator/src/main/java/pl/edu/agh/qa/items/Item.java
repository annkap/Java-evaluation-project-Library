package pl.edu.agh.qa.items;

import java.util.Objects;

public abstract class Item {
    private String title;

    public Item(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract String toString();

    public abstract String toStringInFileExport();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return getTitle().equals(item.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }
}
