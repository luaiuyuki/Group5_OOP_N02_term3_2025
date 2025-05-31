import java.util.*;

public class GenericCRUD<T extends Entity> {
    private ArrayList<T> list = new ArrayList<>();

    // Thêm một phần tử mới
    public void add(T item) {
        list.add(item);
    }

    // Tìm phần tử theo ID
    public T findById(String id) {
        for (T item : list) {
            if (item.getId().equalsIgnoreCase(id)) {
                return item;
            }
        }
        return null;
    }

    // Thêm alias cho findById để hỗ trợ search()
    public T search(String id) {
        return findById(id);
    }

    // Cập nhật thông tin phần tử theo ID
    public boolean update(String id) {
        T item = findById(id);
        if (item != null) {
            System.out.println("Re-enter info:");
            item.input();
            return true;
        }
        return false;
    }

    // Xóa phần tử theo ID
    public boolean delete(String id) {
        T item = findById(id);
        if (item != null) {
            list.remove(item);
            return true;
        }
        return false;
    }

    // Hiển thị tất cả phần tử
    public void showAll() {
        for (T item : list) {
            item.display();
        }
    }

    // Trả về danh sách
    public List<T> getList() {
        return list;
    }
}
