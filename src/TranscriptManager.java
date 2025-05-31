import java.util.ArrayList;
import java.util.List;

public class TranscriptManager {
    private List<Transcript> transcripts;

    public TranscriptManager() {
        transcripts = new ArrayList<>();
    }

    public TranscriptManager(List<Transcript> transcripts) {
        this.transcripts = transcripts;
    }

    // Add a new transcript to the list
    public void addTranscript(Transcript transcript) {
        transcripts.add(transcript);
    }

    // 1. Display list of students enrolled in a specific semester
    public void displayStudentsBySemester(String semester) {
        System.out.println("List of students in semester: " + semester);
        List<String> studentIds = new ArrayList<>();
        for (Transcript t : transcripts) {
            if (t.getSemester().equalsIgnoreCase(semester)) {
                String id = t.getStudent().getStudentId();
                if (!studentIds.contains(id)) {
                    studentIds.add(id);
                    System.out.println(" - " + t.getStudent().getName() + " (ID: " + id + ")");
                }
            }
        }
        if (studentIds.isEmpty()) {
            System.out.println("No students found for this semester.");
        }
    }

    // 2. Find list of courses by student ID
    public void findCoursesByStudentId(String studentId) {
        System.out.println("List of courses for student ID: " + studentId);
        boolean found = false;
        for (Transcript t : transcripts) {
            if (t.getStudent().getStudentId().equalsIgnoreCase(studentId)) {
                System.out.println(" - " + t.getCourse().getCourseName() + " (" + t.getCourse().getCourseID() + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No courses found for this student.");
        }
    }

    // 3. Display detailed transcript for a specific semester
    public void displayTranscriptBySemester(String semester) {
        System.out.println("Transcript for semester: " + semester);
        System.out.printf("%-15s %-10s %-20s %-8s %-8s %-8s %-10s %-10s\n", 
            "Student Name", "Semester", "Course Name", "Grade10", "Grade4", "Letter", "Status", "Result");
        boolean found = false;
        for (Transcript t : transcripts) {
            if (t.getSemester().equalsIgnoreCase(semester)) {
                found = true;
                System.out.printf("%-15s %-10s %-20s %-8.2f %-8.2f %-8s %-10s %-10s\n",
                    t.getStudent().getName(),
                    t.getSemester(),
                    t.getCourse().getCourseName(),
                    t.getGrade10(),
                    t.getGrade4(),
                    t.getLetterGrade(),
                    t.getCourse().getStatus(),  // Make sure Course class has getStatus()
                    t.getPassFail());
            }
        }
        if (!found) {
            System.out.println("No transcripts found for this semester.");
        }
    }

    // Getter for transcript list (if needed)
    public List<Transcript> getTranscripts() {
        return transcripts;
    }
}
