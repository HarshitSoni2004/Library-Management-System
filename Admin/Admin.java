
class Admin {
    private String adminId;

    public Admin(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminId() {
        return adminId;
    }

    public void addBook(Library lib, Book book) {
        lib.getBooks().put(book.getBookId(), book);
        lib.getBookList().add(book);
    }

    public void removeBook(Library lib, long bookId) {
        Book book = lib.getBooks().remove(bookId);
        if (book != null) {
            lib.getBookList().remove(book);
        }
    }
}