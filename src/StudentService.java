import java.util.List;
import java.util.stream.Collectors;

public class StudentService {

    // Hiển thị danh sách sinh viên theo học kỳ dựa vào bảng điểm (transcript)
    public static void displayStudentsInSemester(List<Transcript> transcripts, List<Student> students, String semester) {
        System.out.println("Students in semester " + semester + ":");

        // Lọc các transcript hợp lệ (có học kỳ đúng, student không null)
        List<String> studentIdsInSemester = transcripts.stream()
                .filter(t -> t != null && semester.equalsIgnoreCase(t.getSemester()))
                .filter(t -> t.getStudent() != null)
                .map(t -> t.getStudent().getStudentId())
                .distinct()
                .collect(Collectors.toList());

        // Lọc sinh viên theo danh sách ID đã lọc
        List<Student> filteredStudents = students.stream()
                .filter(s -> studentIdsInSemester.contains(s.getStudentId()))
                .collect(Collectors.toList());

        if (filteredStudents.isEmpty()) {
            System.out.println("No students found for this semester.");
        } else {
            filteredStudents.forEach(s -> System.out.println(s));
        }
    }

    // Hiển thị danh sách khóa học mà một sinh viên đã học
    public static void displayCoursesByStudentId(List<Transcript> transcripts, List<Course> courses, String studentId) {
        System.out.println("Courses taken by student " + studentId + ":");

        // Lọc các transcript của sinh viên (tránh null student/course)
        List<String> courseIds = transcripts.stream()
                .filter(t -> t.getStudent() != null && studentId.equalsIgnoreCase(t.getStudent().getStudentId()))
                .filter(t -> t.getCourse() != null)
                .map(t -> t.getCourse().getCourseID())
                .distinct()
                .collect(Collectors.toList());

        if (courseIds.isEmpty()) {
            System.out.println("No courses found for this student.");
            return;
        }

        // Lọc các course trong danh sách đã lấy được
        List<Course> filteredCourses = courses.stream()
                .filter(c -> courseIds.contains(c.getCourseID()))
                .collect(Collectors.toList());

        filteredCourses.forEach(System.out::println);
    }

    // Hiển thị báo cáo điểm của tất cả sinh viên trong một học kỳ với logic ẩn điểm khi đang học
    public static void displayGradeReport(List<Transcript> transcripts, List<Student> students, List<Course> courses, String semester) {
        System.out.println("Grade report for semester " + semester + ":");

        // Lọc các transcript theo học kỳ
        List<Transcript> transcriptsInSemester = transcripts.stream()
                .filter(t -> t != null && semester.equalsIgnoreCase(t.getSemester()))
                .collect(Collectors.toList());

        if (transcriptsInSemester.isEmpty()) {
            System.out.println("No transcripts found for this semester.");
            return;
        }

        // In tiêu đề báo cáo
        System.out.printf("%-10s %-20s %-10s %-20s %-7s %-7s %-7s %-10s\n",
                "StudentID", "StudentName", "CourseID", "CourseName", "Grade10", "Grade4", "Letter", "Status");

        for (Transcript t : transcriptsInSemester) {
            Student s = t.getStudent();
            Course c = courses.stream()
                    .filter(course -> course.getCourseID().equalsIgnoreCase(t.getCourse().getCourseID()))
                    .findFirst().orElse(null);

            String studentName = (s != null) ? s.getName() : "Unknown";
            String courseName = (c != null) ? c.getCourseName() : "Unknown";

            // Xác định trạng thái
            String status;
            boolean hasGrade = t.getGrade10() > 0 && !"N/A".equalsIgnoreCase(t.getLetterGrade());

            if (!hasGrade) {
                status = "Studying"; // Đang học thì chưa có điểm
            } else if (t.getGrade10() < 5.0 || "Fail".equalsIgnoreCase(t.getPassFail())) {
                status = "Retaking"; // Học lại
            } else {
                status = "Completed"; // Đã học xong
            }

            if ("Studying".equals(status)) {
                // Đang học => ẩn điểm
                System.out.printf("%-10s %-20s %-10s %-20s %-7s %-7s %-7s %-10s\n",
                        (s != null ? s.getStudentId() : "Unknown"), studentName,
                        (t.getCourse() != null ? t.getCourse().getCourseID() : "Unknown"), courseName,
                        "--", "--", "--", status);
            } else {
                // Học lại hoặc hoàn thành thì hiện điểm
                System.out.printf("%-10s %-20s %-10s %-20s %-7.2f %-7.2f %-7s %-10s\n",
                        (s != null ? s.getStudentId() : "Unknown"), studentName,
                        (t.getCourse() != null ? t.getCourse().getCourseID() : "Unknown"), courseName,
                        t.getGrade10(), t.getGrade4(), t.getLetterGrade(), status);
            }
        }
    }
}

