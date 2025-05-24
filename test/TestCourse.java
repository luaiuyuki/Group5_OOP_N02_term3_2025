import java.util.ArrayList;
import java.util.Scanner;

public class TestCourse {
    public static void main(String[] args) {
        ArrayList<Course> courses = new ArrayList<>();

        // Create
        Course c1 = new Course("C001", "Java Programming", 3, "Học đi");
        Course c2 = new Course("C002", "Database", 2, "Học lại");
        courses.add(c1);
        courses.add(c2);

        Scanner sc = new Scanner(System.in);

        // Read
        System.out.println("Danh sách môn học ban đầu:");
        for (Course c : courses) {
            printCourseInfo(c);
            System.out.println();
        }

        // Update
        c2.setStatus("Học đi");
        c2.setCredits(3);
        System.out.println("Sau khi cập nhật c2:");
        printCourseInfo(c2);
        System.out.println();

        // Delete by user input
        System.out.print("Nhập mã môn học muốn xóa: ");
        String idToDelete = sc.nextLine();

        boolean removed = false;
        for (Course c : courses) {
            if (c.getCourseId().equalsIgnoreCase(idToDelete)) {
                courses.remove(c);
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("Đã xóa môn học có mã: " + idToDelete);
        } else {
            System.out.println("Không tìm thấy môn học có mã: " + idToDelete);
        }

        // Show after delete
        System.out.println("\nDanh sách môn học sau khi xóa:");
        for (Course c : courses) {
            printCourseInfo(c);
            System.out.println();
        }

        sc.close();
    }

    public static void printCourseInfo(Course c) {
        System.out.println("Mã MH     : " + c.getCourseId());
        System.out.println("Tên MH    : " + c.getName());
        System.out.println("Số tín chỉ: " + c.getCredits());
        System.out.println("Trạng thái: " + c.getStatus());
    }
}
