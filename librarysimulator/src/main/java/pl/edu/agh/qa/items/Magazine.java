package pl.edu.agh.qa.items;

import java.util.Objects;

public class Magazine extends Item {
    private String number;

    public Magazine(String number, String title) {
        super(title);
        this.number = number;
    }

    @Override
    public String toString() {
        return getTitle() + ";" + number;
    }

    @Override
    public String toStringInFileExport() {
        return getTitle() + "-" + number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Magazine)) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return number.equals(magazine.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), number);
    }
}

