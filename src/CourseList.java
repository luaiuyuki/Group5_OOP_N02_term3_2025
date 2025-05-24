import java.util.ArrayList;

public class CourseList {
    private ArrayList<Course> list = new ArrayList<>();

    public void add(Course c) {
        list.add(c);
    }

    public Course findById(String id) {
        for (Course c : list) {
            if (c.getCourseID().equalsIgnoreCase(id)) {  // sửa ở đây
                return c;
            }
        }
        return null;
    }

    public boolean update(String id, int newCredits, String newStatus) {
        Course c = findById(id);
        if (c != null) {
            c.setCredits(newCredits);
            c.setStatus(newStatus);
            return true;
        }
        return false;
    }

    public boolean delete(String id) {
        Course c = findById(id);
        if (c != null) {
            list.remove(c);
            return true;
        }
        return false;
    }

    public void showAll() {
        for (Course c : list) {
            System.out.println(c);
        }
    }
}
