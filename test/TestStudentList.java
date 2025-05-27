import java.util.Scanner;

public class TestStudentList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentList studentList = new StudentList();

        while (true) {
            System.out.println("=== Student Management ===");
            System.out.println("1. Add student");
            System.out.println("2. Update student");
            System.out.println("3. Delete student");
            System.out.println("4. Show all students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    // Thêm sinh viên mới
                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter gender: ");
                    String gender = scanner.nextLine();

                    System.out.print("Enter date of birth (YYYY-MM-DD): ");
                    String dob = scanner.nextLine();

                    System.out.print("Enter major: ");
                    String major = scanner.nextLine();

                    Student s = new Student(id, name, gender, dob, major);
                    studentList.add(s);
                    System.out.println("Student added successfully.\n");
                    break;

                case 2:
                    // Cập nhật sinh viên theo ID
                    System.out.print("Enter student ID to update: ");
                    String updateId = scanner.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter new major: ");
                    String newMajor = scanner.nextLine();

                    boolean updated = studentList.update(updateId, newName, newMajor);
                    if (updated) {
                        System.out.println("Student updated successfully.\n");
                    } else {
                        System.out.println("Student ID not found.\n");
                    }
                    break;

                case 3:
                    // Xóa sinh viên theo ID
                    System.out.print("Enter student ID to delete: ");
                    String deleteId = scanner.nextLine();

                    boolean deleted = studentList.delete(deleteId);
                    if (deleted) {
                        System.out.println("Student deleted successfully.\n");
                    } else {
                        System.out.println("Student ID not found.\n");
                    }
                    break;

                case 4:
                    // Hiển thị danh sách sinh viên
                    System.out.println("List of students:");
                    studentList.showAll();
                    break;

                case 5:
                    // Thoát chương trình
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.\n");
            }
        }
    }
}
