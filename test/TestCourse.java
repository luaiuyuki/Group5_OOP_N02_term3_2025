import java.util.ArrayList;

public class TestCourse {
    public static void main(String[] args) {
        ArrayList<Course> courses = new ArrayList<>();

        // Create
        Course c1 = new Course("C001", "Java Programming", 3, "Học đi");
        Course c2 = new Course("C002", "Database", 2, "Học lại");
        courses.add(c1);
        courses.add(c2);

        // Read
        System.out.println("List of Courses:");
        for (Course c : courses) {
            System.out.println(c);
        }

        // Update
        c2.setStatus("Học đi");
        c2.setCredits(3);
        System.out.println("\nAfter updating c2:");
        System.out.println(c2);

        // Delete
        courses.remove(c1);
        System.out.println("\nAfter deleting c1:");
        for (Course c : courses) {
            System.out.println(c);
        }
    }
}