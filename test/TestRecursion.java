import java.util.ArrayList;
import java.util.List;

public class TestRecursion {
    public static void main(String[] args) {
        List<Transcript> transcripts = new ArrayList<>();
        Student s = new Student("S001", "John Doe", "Male", "2000-01-01", "CS");
        Course c1 = new Course("C101", "Math", 3, "Học đi");
        Course c2 = new Course("C102", "Physics", 4, "Học đi");

        transcripts.add(new Transcript(s, c1, 8.0f));
        transcripts.add(new Transcript(s, c2, 6.5f));

        System.out.println("Average grade: " + Recursion.averageGrade(transcripts));

        Recursion rec = new Recursion();
        System.out.println("Factorial 5: " + rec.factorial(5));
        System.out.println("Fibonacci 7: " + rec.fibonacci(7));
    }
}
