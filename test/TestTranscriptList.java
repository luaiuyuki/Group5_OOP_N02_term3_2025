import java.util.Scanner;

public class TestTranscriptList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TranscriptList transcriptList = new TranscriptList();

        System.out.print("Enter number of transcripts to add: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Transcript " + (i + 1) + ":");

            // Nhập thông tin sinh viên
            System.out.print("  Enter student ID: ");
            String studentId = scanner.nextLine();
            System.out.print("  Enter student name: ");
            String studentName = scanner.nextLine();
            System.out.print("  Enter student gender: ");
            String gender = scanner.nextLine();
            System.out.print("  Enter student date of birth: ");
            String dob = scanner.nextLine();
            System.out.print("  Enter student major: ");
            String major = scanner.nextLine();

            // Tạo đối tượng Student
            Student student = new Student(studentId, studentName, gender, dob, major);

            // Nhập thông tin môn học
            System.out.print("  Enter course ID: ");
            String courseId = scanner.nextLine();
            System.out.print("  Enter course name: ");
            String courseName = scanner.nextLine();
            System.out.print("  Enter credits: ");
            int credits = Integer.parseInt(scanner.nextLine());
            System.out.print("  Enter course status (e.g. Studying or Retake): ");
            String status = scanner.nextLine();

            // Tạo đối tượng Course
            Course course = new Course(courseId, courseName, credits, status);

            // Nhập điểm
            System.out.print("  Enter grade (10-point scale): ");
            float grade = Float.parseFloat(scanner.nextLine());

            // Tạo và thêm Transcript
            Transcript transcript = new Transcript(student, course, grade);
            transcriptList.add(transcript);

            System.out.println();
        }

        // Hiển thị tất cả bản ghi
        System.out.println("All transcripts:");
        transcriptList.showAll();

        // Thử cập nhật điểm
        System.out.println("\nUpdate a transcript's grade");
        System.out.print("Enter student ID to update: ");
        String updateStudentId = scanner.nextLine();
        System.out.print("Enter course ID to update: ");
        String updateCourseId = scanner.nextLine();
        System.out.print("Enter new grade: ");
        float newGrade = Float.parseFloat(scanner.nextLine());

        if (transcriptList.updateGrade(updateStudentId, updateCourseId, newGrade)) {
            System.out.println("Update successful!");
        } else {
            System.out.println("Transcript not found.");
        }

        // Hiển thị lại tất cả sau khi cập nhật
        System.out.println("\nAll transcripts after update:");
        transcriptList.showAll();

        // Thử xóa một bản ghi
        System.out.println("\nDelete a transcript");
        System.out.print("Enter student ID to delete: ");
        String delStudentId = scanner.nextLine();
        System.out.print("Enter course ID to delete: ");
        String delCourseId = scanner.nextLine();

        if (transcriptList.delete(delStudentId, delCourseId)) {
            System.out.println("Delete successful!");
        } else {
            System.out.println("Transcript not found.");
        }

        // Hiển thị lại danh sách sau khi xóa
        System.out.println("\nAll transcripts after deletion:");
        transcriptList.showAll();

        scanner.close();
    }
}
