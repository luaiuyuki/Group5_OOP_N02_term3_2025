import java.util.Scanner;

public class Student implements Entity {
    private String studentId;
    private String name;
    private String gender;
    private String dateOfBirth;
    private String major;

    public Student() {}

    public Student(String studentId, String name, String gender, String dateOfBirth, String major) {
        this.studentId = studentId;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.major = major;
    }

    // Getter
    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public String getDateOfBirth() { return dateOfBirth; }
    public String getMajor() { return major; }

    // Setter
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public void setName(String name) { this.name = name; }
    public void setGender(String gender) { this.gender = gender; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public void setMajor(String major) { this.major = major; }

    // Triển khai từ interface Entity
    @Override
    public String getId() {
        return studentId;
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        studentId = sc.nextLine();
        System.out.print("Enter name: ");
        name = sc.nextLine();
        System.out.print("Enter gender: ");
        gender = sc.nextLine();
        System.out.print("Enter date of birth: ");
        dateOfBirth = sc.nextLine();
        System.out.print("Enter major: ");
        major = sc.nextLine();
    }

    @Override
    public void display() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Date of birth: " + dateOfBirth);
        System.out.println("Major: " + major);
        System.out.println();
    }

    // Dùng để hiển thị dạng dòng gọn hơn nếu cần
    @Override
    public String toString() {
        return "StudentID: " + studentId + ", Name: " + name + 
               ", Gender: " + gender + ", DOB: " + dateOfBirth + 
               ", Major: " + major;
    }
}
