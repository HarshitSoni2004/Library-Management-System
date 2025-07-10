
import java.util.Scanner;

public class LMS {

    public static void main(String[] args) {
        Library library = new Library();
        Admin admin = new Admin("admin1");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Library Management System!");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. List all books");
            System.out.println("2. Register user");
            System.out.println("3. Issue book");
            System.out.println("4. Return book");
            System.out.println("5. Add book (Admin only)");
            System.out.println("6. Remove book (Admin only)");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    library.listBooks();
                    break;

                case "2":
                    System.out.print("Enter user type (student/teacher): ");
                    String userType = scanner.nextLine().trim().toLowerCase();
                    System.out.print("Enter user ID: ");
                    String userId = scanner.nextLine().trim();
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine().trim();

                    if (library.getUsers().containsKey(userId)) {
                        System.out.println("User ID already exists.");
                    } else {
                        User newUser = null;
                        if (userType.equals("student")) {
                            newUser = new Student(userId, userName);
                        } else if (userType.equals("teacher")) {
                            newUser = new Teacher(userId, userName);
                        } else {
                            System.out.println("Invalid user type.");
                        }
                        if (newUser != null) {
                            library.registerUser(newUser);
                            System.out.println("User registered successfully.");
                        }
                    }
                    break;

                case "3":
                    System.out.print("Enter user ID: ");
                    String issueUserId = scanner.nextLine().trim();
                    System.out.print("Enter book ID to issue: ");
                    long issueBookId = Long.parseLong(scanner.nextLine().trim());
                    library.issueBook(issueUserId, issueBookId);
                    break;

                case "4":
                    System.out.print("Enter user ID: ");
                    String returnUserId = scanner.nextLine().trim();
                    System.out.print("Enter book ID to return: ");
                    long returnBookId = Long.parseLong(scanner.nextLine().trim());
                    library.receiveBook(returnUserId, returnBookId);
                    break;

                case "5":
                    System.out.print("Enter admin ID: ");
                    String adminId = scanner.nextLine().trim();
                    if (!adminId.equals(admin.getAdminId())) {
                        System.out.println("Invalid admin ID.");
                        break;
                    }

                    System.out.print("Enter new book ID: ");
                    long newBookId = Long.parseLong(scanner.nextLine().trim());
                    System.out.print("Enter book title: ");
                    String newBookTitle = scanner.nextLine().trim();
                    System.out.print("Enter book author: ");
                    String newBookAuthor = scanner.nextLine().trim();

                    if (library.getBooks().containsKey(newBookId)) {
                        System.out.println("Book ID already exists.");
                    } else {
                        Book newBook = new Book(newBookId, newBookTitle, newBookAuthor);
                        admin.addBook(library, newBook);
                        System.out.println("Book added successfully.");
                    }
                    break;

                case "6":
                    System.out.print("Enter admin ID: ");
                    String adminIdRemove = scanner.nextLine().trim();
                    if (!adminIdRemove.equals(admin.getAdminId())) {
                        System.out.println("Invalid admin ID.");
                        break;
                    }

                    System.out.print("Enter book ID to remove: ");
                    long removeBookId = Long.parseLong(scanner.nextLine().trim());
                    if (!library.getBooks().containsKey(removeBookId)) {
                        System.out.println("Book ID not found.");
                    } else {
                        admin.removeBook(library, removeBookId);
                        System.out.println("Book removed successfully.");
                    }
                    break;

                case "7":
                    System.out.println("Exiting... Thank you for using LMS!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
