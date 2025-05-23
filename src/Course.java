public class Course {
    private String courseID;
    private String courseName;
    private int credits;
    private String status; // "Học đi" hoặc "Học lại"

    public Course() {}

    public Course(String courseID, String courseName, int credits, String status) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credits = credits;
        this.status = status;
    }

    public String getCourseID() { return courseID; }
    public void setCourseID(String courseID) { this.courseID = courseID; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return courseID + " - " + courseName + " (" + credits + " credits), Status: " + status;
    }
}
