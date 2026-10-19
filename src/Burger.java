import java.time.LocalDate;

// Child class of FoodItem 
public class Burger extends FoodItem {

    public Burger(int weightGrams, LocalDate bestBeforeDate) {
        super("Burger", weightGrams, bestBeforeDate);
    }

    public String getType() {
        return "Hot food";
    }
}
