import java.time.LocalDateTime;

// Here, we'll make it possible to add or remove data from both the beginning and the end
public class FoodDeque implements FoodStorage {

    // Each node is a slot in the list where each food item is stored, and these nodes 
    // are connected to each other by the previous and next nodes
    private class Node {
        FoodItem data;
        Node next;
        Node prev;

        Node(FoodItem data) {
            this.data = data;
        }
    }

    private Node front;     // first node (the "top")
    private Node rear;      // last node (the opposite side)
    private int size;
    private int capacity;

    public FoodDeque(int capacity) {
        this.capacity = capacity;
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    // Add at the front. Time complexity: O(1)
    public boolean addFront(FoodItem item) {
        if (isFull()) {
            return false;
        }
        item.setTimeStored(LocalDateTime.now());
        Node newNode = new Node(item);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        size++;
        return true;
    }

    // Remove from the front
    public FoodItem removeFront() {
        if (isEmpty()) {
            return null;
        }
        FoodItem removed = front.data;
        front = front.next;
        if (front == null) {
            rear = null;        // the list is now empty
        } else {
            front.prev = null;
        }
        size--;
        return removed;
    }

    // Remove from the rear (opposite side
    public FoodItem removeRear() {
        if (isEmpty()) {
            return null;
        }
        FoodItem removed = rear.data;
        rear = rear.prev;
        if (rear == null) {
            front = null;       // the list is now empty
        } else {
            rear.next = null;
        }
        size--;
        return removed;
    }

    // Look at the top item
    public FoodItem peek() {
        if (isEmpty()) {
            return null;
        }
        return front.data;
    }

    // Show all items from the front to the rear 
    public void display() {
        Node current = front;
        int position = 1;
        while (current != null) {
            System.out.println(position + ". " + current.data);
            current = current.next;
            position++;
        }
    }

    // Search by name using recursion
    public int search(String name) {
        return searchFrom(front, name, 1);
    }

    private int searchFrom(Node current, String name, int position) {
        if (current == null) {
            return -1;                      // not found
        }
        if (current.data.getName().equalsIgnoreCase(name)) {
            return position;                // found
        }
        return searchFrom(current.next, name, position + 1);
    }
}
