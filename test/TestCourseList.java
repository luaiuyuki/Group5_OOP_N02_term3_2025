import java.util.Scanner;

public class TestCourseList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseList courseList = new CourseList();

        while (true) {
            System.out.println("\n--- Course Management ---");
            System.out.println("1. Add Course");
            System.out.println("2. Update Course");
            System.out.println("3. Delete Course");
            System.out.println("4. Show All Courses");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng thừa

            switch (choice) {
                case 1:
                    System.out.print("Enter course ID: ");
                    String courseID = scanner.nextLine();

                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();

                    System.out.print("Enter credits: ");
                    int credits = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter status (Studying / Retake): ");
                    String status = scanner.nextLine();

                    Course newCourse = new Course(courseID, courseName, credits, status);
                    courseList.add(newCourse);
                    System.out.println("Course added successfully.");
                    break;

                case 2:
                    System.out.print("Enter course ID to update: ");
                    String updateID = scanner.nextLine();

                    System.out.print("Enter new credits: ");
                    int newCredits = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new status (Studying / Retake): ");
                    String newStatus = scanner.nextLine();

                    boolean updated = courseList.update(updateID, newCredits, newStatus);
                    if (updated) {
                        System.out.println("Course updated successfully.");
                    } else {
                        System.out.println("Course ID " + updateID + " not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter course ID to delete: ");
                    String deleteID = scanner.nextLine();

                    boolean deleted = courseList.delete(deleteID);
                    if (deleted) {
                        System.out.println("Course deleted successfully.");
                    } else {
                        System.out.println("Course ID " + deleteID + " not found.");
                    }
                    break;

                case 4:
                    System.out.println("All courses:");
                    courseList.showAll();
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
