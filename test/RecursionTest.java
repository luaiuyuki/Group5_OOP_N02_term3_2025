import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecursionTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of transcripts: ");
        int n = scanner.nextInt();
        scanner.nextLine();  // consume newline

        List<Transcript> transcripts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Transcript " + (i + 1) + ":");

            System.out.print("  Enter student name: ");
            String studentName = scanner.nextLine();

            System.out.print("  Enter course name: ");
            String courseName = scanner.nextLine();

            System.out.print("  Enter grade (10 point): ");
            float grade = scanner.nextFloat();
            scanner.nextLine(); // consume newline

            // Tạo đối tượng Student và Course giả, cần có setter tương ứng trong class Student và Course
            Student student = new Student();
            student.setName(studentName);

            Course course = new Course();
            course.setCourseName(courseName);

            Transcript transcript = new Transcript(student, course, grade);
            transcripts.add(transcript);
        }

        // Tính tổng và trung bình điểm
        float sum = Recursion.sumGrades(transcripts, 0);
        float avg = Recursion.averageGrade(transcripts);

        System.out.printf("Sum of grades: %.2f\n", sum);
        System.out.printf("Average grade: %.2f\n", avg);

        // Test factorial và fibonacci
        Recursion rec = new Recursion();
        System.out.printf("Factorial of 5: %d\n", rec.factorial(5));
        System.out.printf("Fibonacci of 7: %d\n", rec.fibonacci(7));

        scanner.close();
    }
}
