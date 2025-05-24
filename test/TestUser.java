import java.util.Scanner;

public class TestUser {
    public static void main(String[] args) {
        // Tạo user mẫu
        User u1 = new User("U001", "alice", "pass123", "admin");
        User u2 = new User("U002", "bob", "123456", "student");

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== USER LOGIN =====");
        System.out.print("Username: ");
        String inputUsername = scanner.nextLine();

        System.out.print("Password: ");
        String inputPassword = scanner.nextLine();

        User loggedInUser = null;

        // Kiểm tra đăng nhập
        if (u1.getUsername().equals(inputUsername) && u1.getPassword().equals(inputPassword)) {
            loggedInUser = u1;
        } else if (u2.getUsername().equals(inputUsername) && u2.getPassword().equals(inputPassword)) {
            loggedInUser = u2;
        }

        if (loggedInUser != null) {
            System.out.println("Login successful! Role: " + loggedInUser.getRole());

            // Phân quyền menu
            if (loggedInUser.getRole().equalsIgnoreCase("admin")) {
                System.out.println("===== ADMIN MENU =====");
                System.out.println("1. Manage Students");
                System.out.println("2. Manage Courses");
                System.out.println("3. View All Transcripts");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Managing students...");
                        break;
                    case 2:
                        System.out.println("Managing courses...");
                        break;
                    case 3:
                        System.out.println("Viewing all transcripts...");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }

            } else if (loggedInUser.getRole().equalsIgnoreCase("student")) {
                System.out.println("===== STUDENT MENU =====");
                System.out.println("1. View My Transcript");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Showing your transcript...");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }

        } else {
            System.out.println("Login failed! Invalid username or password.");
        }

        scanner.close();
    }
}
