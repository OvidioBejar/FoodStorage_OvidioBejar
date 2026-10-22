import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// Small helper class to check the user inputs.
public class Validator {

    public static final int MAX_WEIGHT = 5000;      // grams
    public static final int MAX_DAYS = 14;          // best-before: maximum two weeks

    public static boolean isValidWeight(int weight) {
        return weight > 0 && weight <= MAX_WEIGHT;
    }

    public static boolean isValidBestBefore(LocalDate date, LocalDate today) {
        if (date.isBefore(today)) {
            return false;                           // already expired
        }
        long days = ChronoUnit.DAYS.between(today, date);
        return days <= MAX_DAYS;                    // not more than two weeks
    }
}
