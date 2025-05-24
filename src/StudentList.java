import java.util.ArrayList;

public class StudentList {
    private ArrayList<Student> list = new ArrayList<>();

    public void add(Student s) {
        list.add(s);
    }

    public Student findById(String id) {
        for (Student s : list) {
            if (s.getStudentId().equalsIgnoreCase(id)) {  // sửa ở đây
                return s;
            }
        }
        return null;
    }

    public boolean update(String id, String newName, String newMajor) {
        Student s = findById(id);
        if (s != null) {
            s.setName(newName);
            s.setMajor(newMajor);
            return true;
        }
        return false;
    }

    public boolean delete(String id) {
        Student s = findById(id);
        if (s != null) {
            list.remove(s);
            return true;
        }
        return false;
    }

    public void showAll() {
        for (Student s : list) {
            System.out.println(s);
        }
    }
}
