import java.util.ArrayList;
import java.util.Scanner;

// Lớp StudentTest để kiểm tra lớp Student bằng cách nhập dữ liệu từ bàn phím
public class StudentTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();

        // Nhập số lượng sinh viên
        System.out.print("Enter the number of students: ");
        int n = Integer.parseInt(sc.nextLine());

        // Nhập thông tin cho từng sinh viên
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter information for student " + (i + 1) + ":");

            System.out.print("Student ID: ");
            String id = sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Gender: ");
            String gender = sc.nextLine();

            System.out.print("Date of birth: ");
            String dob = sc.nextLine();

            System.out.print("Major: ");
            String major = sc.nextLine();

            // Tạo đối tượng Student và thêm vào danh sách
            Student s = new Student(id, name, gender, dob, major);
            studentList.add(s);
        }

        // Hiển thị danh sách sinh viên sau khi nhập
        System.out.println("\n===== STUDENT LIST =====");
        for (Student s : studentList) {
            System.out.println(s);
        }

        sc.close();
    }
}
