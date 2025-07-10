
import java.util.*;

public class Book {
    private long bookId;
    private String title, author;
    private boolean isAvailable;

    public Book(long bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public long getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { this.isAvailable = available; }

    @Override
    public String toString() {
        return String.format("ID: %d, Title: %s, Author: %s", bookId, title, author);
    }
}
