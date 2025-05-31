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

    // Chuyển đổi điểm hệ 10 sang hệ 4
    public float getGrade4() {
        if (grade10 >= 8.5f) return 4.0f;
        else if (grade10 >= 7.0f) return 3.0f;
        else if (grade10 >= 5.5f) return 2.0f;
        else if (grade10 >= 4.0f) return 1.0f;
        else return 0.0f;
    }

    // Lấy điểm chữ từ điểm 10
    public String getLetterGrade() {
        if (grade10 >= 8.5f) return "A";
        else if (grade10 >= 7.0f) return "B";
        else if (grade10 >= 5.5f) return "C";
        else if (grade10 >= 4.0f) return "D";
        else return "F";
    }

    // Xác định Pass hoặc Fail
    public String getPassFail() {
        return grade10 >= 4.0f ? "Pass" : "Fail";
    }

    // ---  Lấy trạng thái khóa học của sinh viên ---
    public String getStatus() {
        // Kiểm tra có điểm hay chưa
        boolean hasGrade = grade10 > 0 && !"N/A".equalsIgnoreCase(getLetterGrade());

        if (!hasGrade) {
            return "Studying";     // Đang học, chưa có điểm
        } else if (grade10 < 5.0f || "Fail".equalsIgnoreCase(getPassFail())) {
            return "Retaking";    // Học lại
        } else {
            return "Completed";   // Hoàn thành
        }
    }

    @Override
    public String getId() {
        // ID duy nhất: studentId-courseId-semester
        return student.getStudentId() + "-" + course.getCourseID() + "-" + semester;
    }

    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);

        // Nhập thông tin sinh viên
        student = new Student();
        System.out.println("Enter student information:");
        student.input();

        // Nhập thông tin môn học
        course = new Course();
        System.out.println("Enter course information:");
        course.input();

        // Nhập điểm hệ 10
        System.out.print("Enter grade on scale 10: ");
        grade10 = Float.parseFloat(scanner.nextLine());

        // Nhập học kỳ
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
        System.out.println("Status       : " + getStatus());
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
               " | Status: " + getStatus();
    }
}
