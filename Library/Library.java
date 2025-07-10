import java.util.*;

class Library {
    private Map<Long, Book> books = new HashMap<>();
    private Map<String, User> users = new HashMap<>();
    private List<Book> bookList = new ArrayList<>();

    public Library() {
        bookList.add(new Book(101L, "Java Basics", "James Gosling"));
        bookList.add(new Book(102L, "Python 101", "Guido van Rossum"));
        bookList.add(new Book(103L, "Effective Java", "Joshua Bloch"));
        bookList.add(new Book(104L, "Clean Code", "Robert C. Martin"));
        bookList.add(new Book(105L, "C++ Primer", "Stanley B. Lippman"));

        for (Book book : bookList) {
            books.put(book.getBookId(), book);
        }
    }

    public Map<Long, Book> getBooks() { return books; }
    public Map<String, User> getUsers() { return users; }
    public List<Book> getBookList() { return bookList; }

    public void registerUser(User user) {
        users.put(user.userId, user);
    }

    public void issueBook(String userId, long bookId) {
        try {
            User user = users.get(userId);
            Book book = books.get(bookId);
            if (user == null || book == null) throw new Exception("User or Book not found");
            user.borrowBook(book);
            System.out.println("Book issued successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void receiveBook(String userId, long bookId) {
        User user = users.get(userId);
        Book book = books.get(bookId);
        if (user != null && book != null) {
            user.returnBook(book);
            System.out.println("Book returned successfully.");
        }
    }

    public void listBooks() {
        if (bookList.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("\nList of Books:");
        for (Book book : bookList) {
            System.out.println(book.toString());
        }
    }
}

