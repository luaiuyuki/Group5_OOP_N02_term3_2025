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

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    @Override
    public String toString() {
        return studentId + " - " + name + " (" + gender + "), DOB: " + dateOfBirth + ", Major: " + major;
    }
}
