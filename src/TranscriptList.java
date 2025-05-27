import java.util.ArrayList;

public class TranscriptList {
    private ArrayList<Transcript> list = new ArrayList<>();

    /**
     * Thêm bản ghi điểm mới
     */
    public void add(Transcript t) {
        if (t != null) {
            list.add(t);
        }
    }

    /**
     * Tìm bản ghi điểm theo studentId và courseId
     * Trả về null nếu không tìm thấy hoặc dữ liệu không hợp lệ
     */
    public Transcript findByStudentAndCourse(String studentId, String courseId) {
        if (studentId == null || courseId == null) {
            return null;  // tránh lỗi khi đầu vào null
        }
        for (Transcript t : list) {
            if (t != null
                && t.getStudent() != null && t.getStudent().getStudentId() != null
                && t.getCourse() != null && t.getCourse().getCourseID() != null
                && t.getStudent().getStudentId().equalsIgnoreCase(studentId)
                && t.getCourse().getCourseID().equalsIgnoreCase(courseId)) {
                return t;
            }
        }
        return null;
    }

    /**
     * Cập nhật điểm cho studentId và courseId cụ thể
     * Trả về true nếu cập nhật thành công, false nếu không tìm thấy
     */
    public boolean updateGrade(String studentId, String courseId, float newGrade) {
        Transcript t = findByStudentAndCourse(studentId, courseId);
        if (t != null) {
            t.setGrade10(newGrade);
            return true;
        }
        return false;
    }

    /**
     * Xóa bản ghi điểm theo studentId và courseId
     * Trả về true nếu xóa thành công, false nếu không tìm thấy
     */
    public boolean delete(String studentId, String courseId) {
        Transcript t = findByStudentAndCourse(studentId, courseId);
        if (t != null) {
            list.remove(t);
            return true;
        }
        return false;
    }

    /**
     * Hiển thị tất cả các bản ghi điểm
     */
    public void showAll() {
        if (list.isEmpty()) {
            System.out.println("No transcripts found.");
            return;
        }
        for (Transcript t : list) {
            if (t != null) {
                System.out.println(t);
            }
        }
    }
}

