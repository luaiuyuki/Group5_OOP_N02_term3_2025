// TestUser.java
public class TestUser {
    public static void main(String[] args) {
        User user = new User("alice", "pass123", "admin");
        System.out.println(user);
        user.setPassword("newpass");
        System.out.println("Updated password: " + user.getPassword());
    }
}