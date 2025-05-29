import java.util.Scanner;

public class Transcript implements Entity {
    private Student student;
    private Course course;
    private float grade10; // Điểm hệ 10

    public Transcript() {}

    public Transcript(Student student, Course course, float grade10) {
        this.student = student;
        this.course = course;
        this.grade10 = grade10;
    }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public float getGrade10() { return grade10; }
    public void setGrade10(float grade10) { this.grade10 = grade10; }

    public float getGrade4() {
        if (grade10 >= 8.5f) return 4.0f;
        else if (grade10 >= 7.0f) return 3.0f;
        else if (grade10 >= 5.5f) return 2.0f;
        else if (grade10 >= 4.0f) return 1.0f;
        else return 0.0f;
    }

    public String getLetterGrade() {
        if (grade10 >= 8.5f) return "A";
        else if (grade10 >= 7.0f) return "B";
        else if (grade10 >= 5.5f) return "C";
        else if (grade10 >= 4.0f) return "D";
        else return "F";
    }

    public String getPassFail() {
        return grade10 >= 4.0f ? "Pass" : "Fail";
    }

    @Override
    public String getId() {
        return student.getStudentId() + "-" + course.getCourseID();
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);

        // Thực tế: nên lấy từ danh sách Student/Course
        student = new Student();
        System.out.println("Nhập thông tin sinh viên:");
        student.input();

        course = new Course();
        System.out.println("Nhập thông tin môn học:");
        course.input();

        System.out.print("Nhập điểm hệ 10: ");
        grade10 = Float.parseFloat(sc.nextLine());
    }

    @Override
    public void display() {
        System.out.println("Student Name : " + student.getName());
        System.out.println("Course Name  : " + course.getCourseName());
        System.out.println("Grade (10)   : " + grade10);
        System.out.println("Grade (4)    : " + getGrade4());
        System.out.println("Letter Grade : " + getLetterGrade());
        System.out.println("Result       : " + getPassFail());
        System.out.println();
    }

    @Override
    public String toString() {
        return student.getName() + " | " + course.getCourseName() +
               " | Grade10: " + grade10 +
               " | Grade4: " + getGrade4() +
               " | Letter: " + getLetterGrade() +
               " | Result: " + getPassFail();
    }
}
