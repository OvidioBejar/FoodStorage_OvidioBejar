import java.time.LocalDate;

// Child class of FoodItem (inheritance)
public class Hotdog extends FoodItem {

    public Hotdog(int weightGrams, LocalDate bestBeforeDate) {
        super("Hotdog", weightGrams, bestBeforeDate);
    }

    public String getType() {
        return "Hot food";
    }
}
