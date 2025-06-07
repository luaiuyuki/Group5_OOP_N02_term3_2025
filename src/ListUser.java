import java.util.ArrayList;
import java.util.List;

public class ListUser {

    private ArrayList<User> userList = new ArrayList<>();

    // Thêm người dùng mới
    public void addUser(User u) {
        userList.add(u);
    }

    // Hiển thị toàn bộ danh sách
    public void displayList() {
        for (User u : userList) {
            System.out.println("ID: " + u.getUserId());
            System.out.println("Username: " + u.getUsername());
            System.out.println("Role: " + u.getRole());
            System.out.println("----------------------");
        }
    }

    // Tìm người dùng theo username (dùng lambda)
    public List<User> searchUserName(String keyword) {
        return userList.stream()
                .filter(u -> u.getUsername().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }

    // Tìm người dùng theo username (cách truyền thống)
    public List<User> searchUserNameTradition(String keyword) {
        ArrayList<User> result = new ArrayList<>();
        for (User u : userList) {
            if (u.getUsername().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(u);
            }
        }
        return result;
    }

    // Getter danh sách nếu cần dùng ở ngoài
    public ArrayList<User> getUserList() {
        return userList;
    }
}
