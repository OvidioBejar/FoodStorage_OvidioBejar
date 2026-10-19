import java.time.LocalDate;

// Child class of FoodItem (inheritance)
public class Sandwich extends FoodItem {

    public Sandwich(int weightGrams, LocalDate bestBeforeDate) {
        super("Sandwich", weightGrams, bestBeforeDate);
    }

    public String getType() {
        return "Cold food";
    }
}
