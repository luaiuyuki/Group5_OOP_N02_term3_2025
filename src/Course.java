import java.util.Scanner;

public class Course implements Entity {
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

    // Getter
    public String getCourseID() { return courseID; }
    public String getCourseName() { return courseName; }
    public int getCredits() { return credits; }
    public String getStatus() { return status; }

    // Setter
    public void setCourseID(String courseID) { this.courseID = courseID; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void setCredits(int credits) { this.credits = credits; }
    public void setStatus(String status) { this.status = status; }

    // Triển khai từ Entity
    @Override
    public String getId() {
        return courseID;
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter course ID: ");
        courseID = sc.nextLine();
        System.out.print("Enter course name: ");
        courseName = sc.nextLine();
        System.out.print("Enter credits: ");
        credits = Integer.parseInt(sc.nextLine());
        System.out.print("Enter status (Học đi / Học lại): ");
        status = sc.nextLine();
    }

    @Override
    public void display() {
        System.out.println("Course ID   : " + courseID);
        System.out.println("Course Name : " + courseName);
        System.out.println("Credits     : " + credits);
        System.out.println("Status      : " + status);
        System.out.println();
    }

    @Override
    public String toString() {
        return "CourseID: " + courseID + ", Name: " + courseName + 
               ", Credits: " + credits + ", Status: " + status;
    }
}

