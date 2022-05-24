package pl.edu.agh.qa.items;

import java.util.Objects;

public class Book extends Item{
    private String author;

    public Book (String author, String title) {
        super(title);
        this.author = author;
    }

    @Override
    public String toString() {
        return getTitle() + ";" + author;
    }

    @Override
    public String toStringInFileExport() {
        return getTitle() + "-" + author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author);
    }
}


