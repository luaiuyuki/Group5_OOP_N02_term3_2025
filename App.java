public class App {
    public static void main(String[] args) {
        // Khởi tạo đối tượng Student
        Student sv1 = new Student("SV001", "Nguyễn Văn A", "01/01/2000", "Nam");

        // In thông tin sinh viên
        System.out.println(
            "ID: " + sv1.id + 
            " | Name: " + sv1.name + 
            " | Ngay Sinh: " + sv1.dob + 
            " | Gioi tinh: " + sv1.gender
        );
    }
}

