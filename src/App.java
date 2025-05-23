public class App {
    public static void main(String[] args) {
        Student s = new Student("S001", "Anna", "Female", "2001-05-10", "Software Engineering");
        Course c = new Course("CS101", "Programming Fundamentals", 3, "Take course");
        Transcript t = new Transcript(s, c, 9.0f);

        System.out.println("=== Student Information ===");
        System.out.println(s);
        System.out.println("\n=== Course Information ===");
        System.out.println(c);
        System.out.println("\n=== Transcript ===");
        System.out.println(t);
    }
}
