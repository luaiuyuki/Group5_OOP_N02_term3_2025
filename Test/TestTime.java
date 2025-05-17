public class TestTime {
    public static void main(String[] args) {
        String dob = "2000-05-17";
        int age = Time.calculateAge(dob);
        System.out.println("Age: " + age);

        String start = "2025-01-01";
        String end = "2025-05-17";
        System.out.println("Days between: " + Time.calculateDaysBetween(start, end));
    }
}