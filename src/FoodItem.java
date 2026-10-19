import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Parent class: every food item has a name, a weight, a best-before date
// and the time it was placed into the storage.
public class FoodItem {

    private String name;
    private int weightGrams;
    private LocalDate bestBeforeDate;
    private LocalDateTime timeStored;   // filled in when the item is added to the storage

    public FoodItem(String name, int weightGrams, LocalDate bestBeforeDate) {
        this.name = name;
        this.weightGrams = weightGrams;
        this.bestBeforeDate = bestBeforeDate;
    }

    public String getName() {
        return name;
    }

    public int getWeightGrams() {
        return weightGrams;
    }

    public LocalDate getBestBeforeDate() {
        return bestBeforeDate;
    }

    public LocalDateTime getTimeStored() {
        return timeStored;
    }

    public void setTimeStored(LocalDateTime timeStored) {
        this.timeStored = timeStored;
    }

    // Child classes change this method (this is called overriding)
    public String getType() {
        return "Food";
    }

    public String toString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String stored = "not stored yet";
        if (timeStored != null) {
            stored = timeStored.format(format);
        }
        return name + " (" + getType() + ") | Weight: " + weightGrams + " g"
                + " | Best before: " + bestBeforeDate
                + " | Stored at: " + stored;
    }
}
