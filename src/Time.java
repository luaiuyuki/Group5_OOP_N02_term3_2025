import java.util.Scanner;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() { return hour; }
    public void setHour(int hour) { this.hour = hour; }

    public int getMinute() { return minute; }
    public void setMinute(int minute) { this.minute = minute; }

    public int getSecond() { return second; }
    public void setSecond(int second) { this.second = second; }

    public boolean isValid() {
        return (hour >= 0 && hour < 24) &&
               (minute >= 0 && minute < 60) &&
               (second >= 0 && second < 60);
    }

    public void inputTime() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter hour (0-23): ");
            hour = sc.nextInt();
            System.out.print("Enter minute (0-59): ");
            minute = sc.nextInt();
            System.out.print("Enter second (0-59): ");
            second = sc.nextInt();
            if (!isValid()) {
                System.out.println("Invalid time, please enter again.");
            }
        } while (!isValid());
    }

    public void displayTime() {
        System.out.printf("%02d:%02d:%02d\n", hour, minute, second);
    }

    public int toSeconds() {
        return hour * 3600 + minute * 60 + second;
    }

    public Time addSeconds(int s) {
        int totalSeconds = toSeconds() + s;
        totalSeconds = ((totalSeconds % 86400) + 86400) % 86400;
        int h = totalSeconds / 3600;
        int m = (totalSeconds % 3600) / 60;
        int sec = totalSeconds % 60;
        return new Time(h, m, sec);
    }

    public void addHours(int h) {
        this.hour = (this.hour + h) % 24;
    }

    public int compare(Time other) {
        return Integer.compare(this.toSeconds(), other.toSeconds());
    }

    public int subtract(Time other) {
        return this.toSeconds() - other.toSeconds();
    }

    public Time nextSecond() {
        return addSeconds(1);
    }

    public Time previousSecond() {
        return addSeconds(-1);
    }

    // Phương thức tĩnh bổ sung để chuyển giây sang định dạng hh:mm:ss
    public static String secondsToTimeFormat(int totalSeconds) {
        totalSeconds = ((totalSeconds % 86400) + 86400) % 86400;  // đảm bảo trong ngày
        int h = totalSeconds / 3600;
        int m = (totalSeconds % 3600) / 60;
        int s = totalSeconds % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}
