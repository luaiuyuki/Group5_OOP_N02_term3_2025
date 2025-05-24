import java.util.ArrayList;
import java.util.Scanner;

public class TestTranscript {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Transcript> transcripts = new ArrayList<>();

        System.out.print("Enter the number of transcripts to input: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\nInput information for transcript " + (i + 1) + ":");

            // Nhập thông tin sinh viên
            System.out.print("Student ID: ");
            String studentId = sc.nextLine();

            System.out.print("Student Name: ");
            String studentName = sc.nextLine();

            System.out.print("Gender: ");
            String gender = sc.nextLine();

            System.out.print("Date of birth (YYYY-MM-DD): ");
            String dob = sc.nextLine();

            System.out.print("Major: ");
            String major = sc.nextLine();

            Student s = new Student(studentId, studentName, gender, dob, major);

            // Nhập thông tin môn học
            System.out.print("Course ID: ");
            String courseId = sc.nextLine();

            System.out.print("Course Name: ");
            String courseName = sc.nextLine();

            System.out.print("Credits: ");
            int credits = Integer.parseInt(sc.nextLine());

            System.out.print("Status (Học đi/Học lại): ");
            String status = sc.nextLine();

            Course c = new Course(courseId, courseName, credits, status);

            // Nhập điểm hệ 10
            System.out.print("Grade (10): ");
            float grade10 = Float.parseFloat(sc.nextLine());

            // Tạo và thêm bảng điểm
            Transcript t = new Transcript(s, c, grade10);
            transcripts.add(t);
        }

        // In danh sách bảng điểm
        System.out.println("\n===== TRANSCRIPT LIST =====");
        for (Transcript t : transcripts) {
            t.printTranscriptInfo();
        }

        sc.close();
    }
}

}
