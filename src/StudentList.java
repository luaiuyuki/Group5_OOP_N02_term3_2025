import java.util.ArrayList;

public class StudentList {
    private ArrayList<Student> list = new ArrayList<>();

    // Thêm sinh viên
    public void add(Student s) {
        list.add(s);
    }

    // Tìm sinh viên theo ID
    public Student findById(String id) {
        for (Student s : list) {
            if (s.getStudentId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    // Cập nhật tên và ngành học theo ID sinh viên
    public boolean update(String id, String newName, String newMajor) {
        Student s = findById(id);
        if (s != null) {
            s.setName(newName);
            s.setMajor(newMajor);
            return true;
        }
        return false;
    }

    // Xóa sinh viên theo ID
    public boolean delete(String id) {
        Student s = findById(id);
        if (s != null) {
            list.remove(s);
            return true;
        }
        return false;
    }

    // Hiển thị tất cả sinh viên
    public void showAll() {
        for (Student s : list) {
            s.display();  // gọi hàm display() để in thông tin chi tiết sinh viên
        }
    }
}

