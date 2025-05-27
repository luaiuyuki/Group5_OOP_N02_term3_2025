import java.util.ArrayList;
import java.util.Scanner;

public class CourseTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Course> courseList = new ArrayList<>();

        System.out.print("Enter the number of courses: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter information for course " + (i + 1) + ":");

            System.out.print("Course ID: ");
            String id = sc.nextLine();

            System.out.print("Course Name: ");
            String name = sc.nextLine();

            System.out.print("Credits: ");
            int credits = Integer.parseInt(sc.nextLine());

            System.out.print("Status (Studying/Retake): ");
            String status = sc.nextLine();

            Course c = new Course(id, name, credits, status);
            courseList.add(c);
        }

        System.out.println("\n===== COURSE LIST =====");
        for (Course c : courseList) {
            c.printCourseInfo(); // in chi tiết từng môn học 
        }

        sc.close();
    }
}
