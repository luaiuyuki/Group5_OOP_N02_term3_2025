import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Time {

    // Calculate age based on date of birth (format: "yyyy-MM-dd")
    public static int calculateAge(String dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(dateOfBirth, formatter);
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }

    // Calculate number of days between two dates
    public static int calculateDaysBetween(String start, String end) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(start, formatter);
        LocalDate endDate = LocalDate.parse(end, formatter);
        return Period.between(startDate, endDate).getDays();
    }
}