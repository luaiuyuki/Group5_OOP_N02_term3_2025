public class Student {
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

    // Hàm in thông tin sinh viên theo từng dòng
    public void printStudentInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Date of birth: " + dateOfBirth);
        System.out.println("Major: " + major);
        System.out.println();  // dòng trống giữa các sinh viên
    }
}
