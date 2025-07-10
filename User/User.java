
import java.util.*;

abstract class User {
    protected String userId, name;
    protected List<Long> borrowedBooks = new ArrayList<>();

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public void borrowBook(Book book) throws Exception {
        if (borrowedBooks.size() >= getLimit()) {
            throw new Exception("Borrowing limit reached.");
        }
        if (!book.isAvailable()) {
            throw new Exception("Book is not available.");
        }
        borrowedBooks.add(book.getBookId());
        book.setAvailable(false);
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book.getBookId())) {
            book.setAvailable(true);
        }
    }

    public abstract int getLimit();
}

class Student extends User {
    public Student(String userId, String name) {
        super(userId, name);
    }
    public int getLimit() { return 3; }
}

class Teacher extends User {
    public Teacher(String userId, String name) {
        super(userId, name);
    }
    public int getLimit() { return 5; }
}
