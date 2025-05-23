public class TestTime {
    public static void main(String[] args) {
        Time t = new Time(13, 45, 30);
        System.out.println("Time: " + t);
        System.out.println("Add 5000 seconds: " + t.addSeconds(5000));
        System.out.println("Next second: " + t.nextSecond());
        System.out.println("Previous second: " + t.previousSecond());

        Time t2 = new Time(14, 0, 0);
        System.out.println("Compare to t2: " + t.compare(t2));
        System.out.println("Subtract t2: " + t.subtract(t2));
    }
}
