import java.util.ArrayList;

public class TestStudent {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        // Create
        Student s1 = new Student("S001", "Lan", "Female", "2003-01-01", "IT");
        Student s2 = new Student("S002", "Minh", "Male", "2002-12-12", "CS");
        students.add(s1);
        students.add(s2);

        // Read
        System.out.println("List of Students:");
        for (Student s : students) {
            System.out.println(s);
        }

        // Update
        s1.setName("Lan Anh");
        s1.setMajor("Software Engineering");
        System.out.println("\nAfter updating s1:");
        System.out.println(s1);

        // Delete
        students.remove(s2);
        System.out.println("\nAfter deleting s2:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}