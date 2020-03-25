package dk.cphbusiness.algorithm.examples.queues;

import dk.cphbusiness.airport.template.Passenger;
import java.util.NoSuchElementException;

public class PriorityQueueImplementation implements PriorityQueue<Passenger> {

    private final Passenger[] items;
    private int size = 0;
    private int head = 0; // index of the current front item, if one exists
    private int tail = 0; // index of next item to be added
    private int capacity;

    public PriorityQueueImplementation(int capacity) {
        items = new Passenger[capacity];
        this.capacity = capacity;
    }

    @Override
    public void enqueue(Passenger item) {
        if (size == items.length)
          throw new IllegalStateException("Cannot add to full queue");
        items[tail] = item;
        tail = (tail + 1) % items.length;
        size++;
        sort();
    }

    @Override
    public Passenger dequeue() {
        if (size == 0)
          throw new NoSuchElementException("Cannot remove from empty queue");
        Passenger item = items[head];
        items[head] = null;
        head = (head + 1) % items.length;
        size--;
        return item;
    }

    public void sort() {

        int n = tail;

        for (int i = n / 2 - 1; i >= head; i--) {
            heapify(this.items, n, i);
        }

        for (int i = n - 1; i >= head; i--) {
            // Move current root to end 
            Passenger tempTail = this.items[i];
            Passenger tempHead = this.items[head];
            this.items[i] = tempHead;
            this.items[head] = tempTail;

            heapify(this.items, i, head);
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (Passenger item : items) {
            s += item.toString() + "\n";
        }
        return s;
    }

    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
    private void heapify(Passenger[] arr, int n, int i) {
        int largest = i; // Initialize largest as root 
        int l = 2 * i + 1; // left = 2*i + 1 
        int r = 2 * i + 2; // right = 2*i + 2 

        // If left child is larger than root 
        if (l < n && arr[l].compareTo(arr[largest]) > 0) {
            largest = l;
        }
        // If right child is larger than largest so far 
        if (r < n && arr[r].compareTo(arr[largest]) > 0) {
            largest = r;
        }
        // If largest is not root 
        if (largest != i) {
            Passenger swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest);
        }
    }

    public Passenger[] getItems() {
        return items;
    }

    @Override
    public Passenger peek() {
        return items[0];
    }

    @Override
    public int size() {
        return size;
    }
}
