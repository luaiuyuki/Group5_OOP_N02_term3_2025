import java.util.Scanner;

public class Transcript implements Entity {
    private Student student;      // Sinh viên
    private Course course;        // Môn học
    private float grade10;        // Điểm hệ 10
    private String semester;      // Học kỳ

    public Transcript() {}

    public Transcript(Student student, Course course, float grade10, String semester) {
        this.student = student;
        this.course = course;
        this.grade10 = grade10;
        this.semester = semester;
    }

    // Getters and Setters
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public float getGrade10() { return grade10; }
    public void setGrade10(float grade10) { this.grade10 = grade10; }

    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }

    // Convert grade10 to grade4 scale
    public float getGrade4() {
        if (grade10 >= 8.5f) return 4.0f;
        else if (grade10 >= 7.0f) return 3.0f;
        else if (grade10 >= 5.5f) return 2.0f;
        else if (grade10 >= 4.0f) return 1.0f;
        else return 0.0f;
    }

    // Get letter grade from grade10
    public String getLetterGrade() {
        if (grade10 >= 8.5f) return "A";
        else if (grade10 >= 7.0f) return "B";
        else if (grade10 >= 5.5f) return "C";
        else if (grade10 >= 4.0f) return "D";
        else return "F";
    }

    // Determine pass or fail status
    public String getPassFail() {
        return grade10 >= 4.0f ? "Pass" : "Fail";
    }

    @Override
    public String getId() {
        // Unique ID: studentId-courseId-semester
        return student.getStudentId() + "-" + course.getCourseID() + "-" + semester;
    }

    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);

        // Input student info
        student = new Student();
        System.out.println("Enter student information:");
        student.input();

        // Input course info
        course = new Course();
        System.out.println("Enter course information:");
        course.input();

        // Input grade10
        System.out.print("Enter grade on scale 10: ");
        grade10 = Float.parseFloat(scanner.nextLine());

        // Input semester
        System.out.print("Enter semester (e.g. HK1-2024): ");
        semester = scanner.nextLine();
    }

    @Override
    public void display() {
        System.out.println("Student Name : " + student.getName());
        System.out.println("Course Name  : " + course.getCourseName());
        System.out.println("Grade (10)   : " + grade10);
        System.out.println("Grade (4)    : " + getGrade4());
        System.out.println("Letter Grade : " + getLetterGrade());
        System.out.println("Result       : " + getPassFail());
        System.out.println("Semester     : " + semester);
        System.out.println("Course Status: " + course.getStatus());
        System.out.println();
    }

    @Override
    public String toString() {
        return student.getName() + " | " + course.getCourseName() +
               " | Grade10: " + grade10 +
               " | Grade4: " + getGrade4() +
               " | Letter: " + getLetterGrade() +
               " | Result: " + getPassFail() +
               " | Semester: " + semester +
               " | Status: " + course.getStatus();
    }
}
