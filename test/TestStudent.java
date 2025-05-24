import java.util.ArrayList;
import java.util.Scanner;

public class TestStudent {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        // Create some sample students
        students.add(new Student("S001", "Lan", "Female", "2003-01-01", "IT"));
        students.add(new Student("S002", "Minh", "Male", "2002-12-12", "CS"));

        Scanner sc = new Scanner(System.in);

        System.out.println("Initial list of students:");
        for (Student s : students) {
            System.out.println(s);
        }

        System.out.print("\nEnter the student ID to delete: ");
        String idToDelete = sc.nextLine();

        // Delete student by entered ID
        boolean removed = false;
        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(idToDelete)) {
                students.remove(s);
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("Deleted student with ID: " + idToDelete);
        } else {
            System.out.println("Student with ID " + idToDelete + " not found.");
        }

        System.out.println("\nList of students after deletion:");
        for (Student s : students) {
            System.out.println(s);
        }

        sc.close();
    }
}
