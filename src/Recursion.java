import java.util.List;

public class Recursion {

    public static float sumGrades(List<Transcript> transcripts, int index) {
        if (index == transcripts.size()) {
            return 0;
        }
        return transcripts.get(index).getGrade10() + sumGrades(transcripts, index + 1);
    }

    public static float averageGrade(List<Transcript> transcripts) {
        if (transcripts == null || transcripts.isEmpty()) {
            return 0;
        }
        return sumGrades(transcripts, 0) / transcripts.size();
    }

    public int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    public int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
