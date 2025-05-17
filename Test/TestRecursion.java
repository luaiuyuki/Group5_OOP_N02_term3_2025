public class TestRecursion {
    public static void main(String[] args) {
        Transcript[] transcripts = new Transcript[2];
        Student student = new Student("S001", "Bob", "2001-12-12", "Male");
        Course course1 = new Course("C101", "Math", 3);
        Course course2 = new Course("C102", "Physics", 4);
        transcripts[0] = new Transcript(student, course1, 7.5f);
        transcripts[1] = new Transcript(student, course2, 8.0f);

        float totalGrades = Recursion.calculateTotalGrades(transcripts, transcripts.length - 1);
        System.out.println("Total grades: " + totalGrades);

        int fact5 = Recursion.factorial(5);
        System.out.println("Factorial 5: " + fact5);
    }
}