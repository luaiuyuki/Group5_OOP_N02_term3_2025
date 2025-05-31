import java.util.*;

public class GenericCRUD<T extends Entity> {
    private ArrayList<T> list = new ArrayList<>();

    public void add(T item) {
        list.add(item);
    }

    public T findById(String id) {
        for (T item : list) {
            if (item.getId().equalsIgnoreCase(id)) {
                return item;
            }
        }
        return null;
    }

    public boolean update(String id) {
        T item = findById(id);
        if (item != null) {
            System.out.println("Re-enter info:");
            item.input();
            return true;
        }
        return false;
    }

    public boolean delete(String id) {
        T item = findById(id);
        if (item != null) {
            list.remove(item);
            return true;
        }
        return false;
    }

    public void showAll() {
        for (T item : list) {
            item.display();
        }
    }

    //  Thêm phương thức getList để các class khác có thể dùng
    public List<T> getList() {
        return list;
    }
}
