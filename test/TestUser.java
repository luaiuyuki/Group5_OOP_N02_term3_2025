public class TestUser {
    public static void main(String[] args) {
        User u1 = new User("U001", "alice", "pass123", "admin");
        User u2 = new User("U002", "bob", "123456", "student");

        System.out.println(u1);
        System.out.println(u2);
    }
}
