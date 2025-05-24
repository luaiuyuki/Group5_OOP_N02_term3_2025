import java.util.ArrayList;

public class TranscriptList {
    private ArrayList<Transcript> list = new ArrayList<>();

    public void add(Transcript t) {
        list.add(t);
    }

    public Transcript findByStudentAndCourse(String studentId, String courseId) {
        for (Transcript t : list) {
            if (t.getStudent().getStudentId().equalsIgnoreCase(studentId)  // sửa ở đây
                    && t.getCourse().getCourseID().equalsIgnoreCase(courseId)) {  // và ở đây
                return t;
            }
        }
        return null;
    }

    public boolean updateGrade(String studentId, String courseId, float newGrade) {
        Transcript t = findByStudentAndCourse(studentId, courseId);
        if (t != null) {
            t.setGrade10(newGrade);
            return true;
        }
        return false;
    }

    public boolean delete(String studentId, String courseId) {
        Transcript t = findByStudentAndCourse(studentId, courseId);
        if (t != null) {
            list.remove(t);
            return true;
        }
        return false;
    }

    public void showAll() {
        for (Transcript t : list) {
            System.out.println(t);
        }
    }
}
