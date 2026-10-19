import java.time.LocalDate;

// Child class of FoodItem (inheritance)
public class Pizza extends FoodItem {

    public Pizza(int weightGrams, LocalDate bestBeforeDate) {
        super("Pizza", weightGrams, bestBeforeDate);
    }

    public String getType() {
        return "Hot food";
    }
}
