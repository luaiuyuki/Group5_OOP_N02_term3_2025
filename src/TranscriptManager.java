import java.util.ArrayList;
import java.util.List;

public class TranscriptManager {
    private List<Transcript> transcriptList;

    public TranscriptManager() {
        transcriptList = new ArrayList<>();
    }

    // Thêm bản điểm mới
    public void addTranscript(Transcript t) {
        transcriptList.add(t);
    }

    // 1. Hiển thị danh sách sinh viên trong học kỳ cụ thể
    public void displayStudentsBySemester(String semester) {
        System.out.println("Students in semester: " + semester);
        // Dùng để tránh lặp tên sinh viên nếu học nhiều môn cùng kỳ
        List<String> printedStudentIds = new ArrayList<>();
        for (Transcript t : transcriptList) {
            if (t.getSemester().equals(semester) && !printedStudentIds.contains(t.getStudent().getStudentId())) {
                System.out.println(t.getStudent().getName() + " (ID: " + t.getStudent().getStudentId() + ")");
                printedStudentIds.add(t.getStudent().getStudentId());
            }
        }
        System.out.println();
    }

    // 2. Tìm danh sách môn học theo mã sinh viên
    public void findCoursesByStudentId(String studentId) {
        System.out.println("Courses for student ID: " + studentId);
        for (Transcript t : transcriptList) {
            if (t.getStudent().getStudentId().equals(studentId)) {
                System.out.println(t.getCourse().getCourseName() + " (Course ID: " + t.getCourse().getCourseID() + ")");
            }
        }
        System.out.println();
    }

    // 3. Hiển thị bảng điểm chi tiết theo học kỳ và mã sinh viên (studentId có thể null để lấy tất cả)
    public void displayTranscriptTable(String semester, String studentId) {
        System.out.println("Transcript table for semester: " + semester + (studentId == null ? "" : ", student ID: " + studentId));
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-10s | %-15s | %-7s | %-7s | %-10s | %-12s |\n", 
                          "Student Name", "Student ID", "Course Name", "Grade10", "Grade4", "Letter", "Course Status");
        System.out.println("---------------------------------------------------------------------------------------------");
        for (Transcript t : transcriptList) {
            if (t.getSemester().equals(semester) && (studentId == null || t.getStudent().getStudentId().equals(studentId))) {
                System.out.printf("| %-15s | %-10s | %-15s | %-7.2f | %-7.2f | %-10s | %-12s |\n",
                        t.getStudent().getName(),
                        t.getStudent().getStudentId(),
                        t.getCourse().getCourseName(),
                        t.getGrade10(),
                        t.getGrade4(),
                        t.getLetterGrade(),
                        t.getCourse().getStatus());
            }
        }
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println();
    }
    
    // Có thể thêm các method CRUD khác (update, delete) nếu cần
}
