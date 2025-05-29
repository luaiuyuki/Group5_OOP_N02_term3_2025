import java.util.ArrayList;

public class CourseList {
    private ArrayList<Course> list = new ArrayList<>();

    // Thêm môn học
    public void add(Course c) {
        list.add(c);
    }

    // Tìm môn học theo courseID (không phân biệt hoa thường)
    public Course findById(String id) {
        for (Course c : list) {
            if (c.getCourseID().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }

    // Cập nhật credits và status của môn học theo courseID
    public boolean update(String id, int newCredits, String newStatus) {
        Course c = findById(id);
        if (c != null) {
            c.setCredits(newCredits);
            c.setStatus(newStatus);
            return true;
        }
        return false;
    }

    // Xóa môn học theo courseID
    public boolean delete(String id) {
        Course c = findById(id);
        if (c != null) {
            list.remove(c);
            return true;
        }
        return false;
    }

    // Hiển thị tất cả môn học với thông tin chi tiết
    public void showAll() {
        if (list.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        for (Course c : list) {
            c.display();  // Gọi hàm display() để in thông tin chi tiết môn học
        }
    }
}

