// Interface: it lists the operations that any food storage must have.
public interface FoodStorage {

    boolean addFront(FoodItem item);   // add at the front
    FoodItem removeFront();            // remove from the front
    FoodItem removeRear();             // remove from the opposite side (rear)
    FoodItem peek();                   // look at the item at the top (front) without removing it
    void display();                    // show all items
    int search(String name);           // position of the first item with that name, or -1
    boolean isEmpty();
    boolean isFull();
    int size();
}
