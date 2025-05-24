public class Course {
    private String courseID;
    private String courseName;
    private int credits;
    private String status; //"Học đi"(studying) hoặc "Học lại"(retake)

    public Course() {}

    public Course(String courseID, String courseName, int credits, String status) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credits = credits;
        this.status = status;
    }

    // Hàm in thông tin môn học theo từng dòng
    public void printCourseInfo() {
        System.out.println("Course ID   : " + courseID);
        System.out.println("Course Name : " + courseName);
        System.out.println("Credits     : " + credits);
        System.out.println("Status      : " + status);
        System.out.println(); // dòng trống giữa các môn học
    }
}

