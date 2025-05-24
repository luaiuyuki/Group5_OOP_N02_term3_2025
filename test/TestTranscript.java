import java.util.ArrayList;

public class TestTranscript {
    public static void main(String[] args) {
        ArrayList<Transcript> transcripts = new ArrayList<>();

        // Sample data
        Student s = new Student("S001", "Lan", "Female", "2003-01-01", "IT");
        Course c = new Course("C001", "Java Programming", 3, "Học đi");

        // Create
        Transcript t1 = new Transcript(s, c, 8.0f);
        transcripts.add(t1);

        // Read
        System.out.println("Transcript:");
        for (Transcript t : transcripts) {
            System.out.println(t);
        }

        // Update
        t1.setGrade10(9.5f);
        System.out.println("\nAfter updating grade:");
        System.out.println(t1);

        // Delete
        transcripts.remove(t1);
        System.out.println("\nAfter deleting transcript:");
        if (transcripts.isEmpty()) {
            System.out.println("No transcripts available.");
        }
    }
}