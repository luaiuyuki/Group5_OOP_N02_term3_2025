import java.util.ArrayList;
import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();

        System.out.print("Enter the number of students: ");
        int n = Integer.parseInt(sc.nextLine());

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

            Student s = new Student(id, name, gender, dob, major);
            studentList.add(s);
        }

        System.out.println("\n===== STUDENT LIST =====");

        for (Student s : studentList) {
            s.printStudentInfo();  // in thông tin chi tiết từng sinh viên
        }

        sc.close();
    }
}

