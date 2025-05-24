// Lớp Student dùng để lưu thông tin của sinh viên
public class Student {
    private String studentId;
    private String name;
    private String gender;
    private String dateOfBirth;
    private String major;

    // Hàm tạo không tham số
    public Student() {}

    // Hàm tạo đầy đủ tham số
    public Student(String studentId, String name, String gender, String dateOfBirth, String major) {
        this.studentId = studentId;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.major = major;
    }

    // Getter và Setter cho studentId
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    // Getter và Setter cho name
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // Getter và Setter cho gender
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    // Getter và Setter cho dateOfBirth
    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    // Getter và Setter cho major
    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    // Hiển thị thông tin sinh viên
    @Override
    public String toString() {
        return studentId + " - " + name + " (" + gender + "), DOB: " + dateOfBirth + ", Major: " + major;
    }
}
