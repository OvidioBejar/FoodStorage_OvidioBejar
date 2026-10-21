import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    // here is the capacity of the storage
    public static final int CAPACITY = 8;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        FoodDeque storage = new FoodDeque(CAPACITY);

        try {
            System.out.println("=== Fast-Food Party Storage ===");
            int mode = chooseMode();
            boolean running = true;

            while (running) {
                showMenu(mode);
                int choice = readInt("Choose an option: ");

                switch (choice) {
                    case 1:
                        addItem(storage);
                        break;
                    case 2:
                        removeItem(storage, mode);
                        break;
                    case 3:
                        peekItem(storage);
                        break;
                    case 4:
                        displayItems(storage);
                        break;
                    case 5:
                        searchItem(storage);
                        break;
                    case 0:
                        System.out.println("Application terminated. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("Error: please choose a number from the menu.");
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Input finished. Application terminated.");
        }
    }

    //this is the menu

    private static int chooseMode() {
        System.out.println("How do you want to use the storage?");
        System.out.println("1. Front side only (add and remove at the front)");
        System.out.println("2. Front to add, opposite side to remove");
        while (true) {
            int mode = readInt("Choose 1 or 2: ");
            if (mode == 1 || mode == 2) {
                return mode;
            }
            System.out.println("Error: only 1 or 2 is allowed.");
        }
    }
    
    private static void showMenu(int mode) {
        System.out.println();
        System.out.println("----- MENU -----");
        System.out.println("1. Add food item");
        if (mode == 1) {
            System.out.println("2. Remove food item (from the front)");
        } else {
            System.out.println("2. Remove food item (from the opposite side)");
        }
        System.out.println("3. Show the item at the top");
        System.out.println("4. Display all food items");
        System.out.println("5. Search food item by name");
        System.out.println("0. Exit");
    }

    private static void addItem(FoodDeque storage) {
        if (storage.isFull()) {
            System.out.println("Error: the storage is full (maximum " + storage.getCapacity() + " items).");
            return;
        }

        System.out.println("Food types: 1.Burger  2.Pizza  3.Fries  4.Sandwich  5.Hotdog");
        int type = readInt("Choose the food type (1-5): ");
        if (type < 1 || type > 5) {
            System.out.println("Invalid option. please choose a number from 1 to 5");
            return;
        }

        int weight = readInt("Enter the weight in grams (1-" + Validator.MAX_WEIGHT + "): ");
                if (!Validator.isValidWeight(weight)) {
            System.out.println("The weight must be between 1 and " + Validator.MAX_WEIGHT + " grams");
            return;
        }

        LocalDate today = LocalDate.now();
        System.out.print("Enter the best-before date (yyyy-mm-dd), ");
        String text = scanner.nextLine().trim();
        LocalDate date;
        try {
            date = LocalDate.parse(text);
        } catch (DateTimeParseException e) {
            System.out.println("The date format is not correct. Example: " + today);
            return;
        }

        FoodItem item;
        switch (type) {
            case 1:
                item = new Burger(weight, date);
                break;
            case 2:
                item = new Pizza(weight, date);
                break;
            case 3:
                item = new Fries(weight, date);
                break;
            case 4:
                item = new Sandwich(weight, date);
                break;
            default:
                item = new Hotdog(weight, date);
        }

        storage.addFront(item);
        System.out.println("Added: " + item);
    }

    private static void removeItem(FoodDeque storage, int mode) {
        if (storage.isEmpty()) {
            System.out.println("the storage is empty");
            return;
        }
        FoodItem removed;
        if (mode == 1) {
            removed = storage.removeFront();
        } else {
            removed = storage.removeRear();
        }
        System.out.println("Removed: " + removed);
    }

    private static void peekItem(FoodDeque storage) {
        FoodItem top = storage.peek();
        if (top == null) {
            System.out.println("the storage is empty");
        } else {
            System.out.println("Item at the top: " + top.getName());
        }
    }

    private static void displayItems(FoodDeque storage) {
        if (storage.isEmpty()) {
            System.out.println("the storage is empty");
            return;
        }
        System.out.println();
        storage.display();
    }

    private static void searchItem(FoodDeque storage) {
        if (storage.isEmpty()) {
            System.out.println("The storage is empty");
            return;
        }
        System.out.print("Enter the food name to search: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("The name cannot be empty");
            return;
        }
        int position = storage.search(name);
        if (position == -1) {
            System.out.println(name + " was not found in the storage");
        } else {
            System.out.println();
        }
    }

    // Reads a whole number, and if the user types letters, it shows an error and asks again
    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            String text = scanner.nextLine().trim();
            try {
                return Integer.parseInt(text);
            } catch (NumberFormatException e) {
                System.out.println("please enter just a whole number");
            }
        }
    }
}
