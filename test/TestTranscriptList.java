import java.util.Scanner;

public class TestTranscriptList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TranscriptList transcriptList = new TranscriptList();

        int choice;
        do {
            System.out.println("\n--- Transcript Management ---");
            System.out.println("1. Add transcript");
            System.out.println("2. Update grade");
            System.out.println("3. Delete transcript");
            System.out.println("4. Show all transcripts");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Enter transcript info:");

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
                    Course course = new Course(courseId, courseName, credits, status);

                    // Nhập điểm
                    System.out.print("  Enter grade (10-point scale): ");
                    float grade = Float.parseFloat(scanner.nextLine());

                    Transcript transcript = new Transcript(student, course, grade);
                    transcriptList.add(transcript);
                    System.out.println("Transcript added successfully!");
                    break;

                case 2:
                    System.out.println("Update a transcript's grade");
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
                    break;

                case 3:
                    System.out.println("Delete a transcript");
                    System.out.print("Enter student ID to delete: ");
                    String delStudentId = scanner.nextLine();
                    System.out.print("Enter course ID to delete: ");
                    String delCourseId = scanner.nextLine();

                    if (transcriptList.delete(delStudentId, delCourseId)) {
                        System.out.println("Delete successful!");
                    } else {
                        System.out.println("Transcript not found.");
                    }
                    break;

                case 4:
                    System.out.println("All transcripts:");
                    transcriptList.showAll();
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
