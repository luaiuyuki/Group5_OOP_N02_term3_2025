public class App {
    public static void main(String[] args) {
        System.out.println("Running User tests:");
        TestUser.main(null); // Gọi lớp TestUser chạy

        System.out.println("\nRunning Time tests:");
        TestTime.main(null); // Gọi lớp TestTime chạy

        System.out.println("\nRunning Recursion tests:");
        TestRecursion.main(null); // Gọi lớp TestRecursion chạy
    }
}
