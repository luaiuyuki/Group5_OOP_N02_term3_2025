import java.util.Scanner;

public class TestTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter course start time:");
        Time startTime = new Time();
        startTime.inputTime();

        System.out.println("Enter course end time:");
        Time endTime = new Time();
        endTime.inputTime();

        System.out.println("Course start time: " + startTime);
        System.out.println("Course end time: " + endTime);

        int diffSeconds = endTime.subtract(startTime); // Tính hiệu thời gian (giây)

        // Nếu thời gian kết thúc nhỏ hơn thời gian bắt đầu, giả sử là qua ngày hôm sau
        if (diffSeconds < 0) {
            diffSeconds += 24 * 3600; // Cộng thêm 24 giờ (86400 giây)
        }

        System.out.println("Duration of the course: " + Time.secondsToTimeFormat(diffSeconds));//Thời gian khóa học kéo dài

        sc.close();
    }
}