public class Recursion {

    // Recursive function to calculate the total grades
    public static float calculateTotalGrades(Transcript[] transcripts, int index) {
        if (index < 0) return 0;
        return transcripts[index].getGrade() + calculateTotalGrades(transcripts, index - 1);
    }

    // Recursive factorial (example of classic recursion)
    public static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}
