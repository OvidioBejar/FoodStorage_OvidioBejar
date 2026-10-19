import java.time.LocalDate;

// Child class of FoodItem (inheritance)
public class Fries extends FoodItem {

    public Fries(int weightGrams, LocalDate bestBeforeDate) {
        super("Fries", weightGrams, bestBeforeDate);
    }

    public String getType() {
        return "Side dish";
    }
}
