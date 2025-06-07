import java.util.Scanner;

public class TestUser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Khởi tạo danh sách user
        ListUser userList = new ListUser();
        userList.addUser(new User("U001", "alice", "pass123", "admin"));
        userList.addUser(new User("U002", "mary", "123456", "student"));

        System.out.println("==== USER LOGIN ====");
        System.out.print("Username: ");
        String inputUsername = scanner.nextLine();

        System.out.print("Password: ");
        String inputPassword = scanner.nextLine();

        User loggedInUser = null;

        // Kiểm tra đăng nhập từ danh sách user
        for (User u : userList.getUsers()) {
            if (u.getUsername().equals(inputUsername) && u.getPassword().equals(inputPassword)) {
                loggedInUser = u;
                break;
            }
        }

        if (loggedInUser != null) {
            System.out.println("Login successful! Role: " + loggedInUser.getRole());

            // Phân quyền theo vai trò
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
