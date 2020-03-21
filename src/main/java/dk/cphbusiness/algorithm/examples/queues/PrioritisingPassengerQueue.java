package dk.cphbusiness.algorithm.examples.queues;

import dk.cphbusiness.airport.template.Category;
import dk.cphbusiness.airport.template.Passenger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * An implementation of a queue using a fixed, non-expandable array whose
 * capacity is set in its constructor.
 * @author mbeg
  
 */
public class PrioritisingPassengerQueue implements PriorityQueue<Passenger> {
    private final Passenger[] items = null;
    Map<Category, List<Passenger>> passengers;
    private int size = 0;
    private int head = 0; // index of the current front item, if one exists
    private int tail = 0; // index of next item to be added
    private int capacity = 0;
    

    public PrioritisingPassengerQueue(int capacity) {
      this.capacity = capacity;
      passengers = new HashMap<>();
      passengers.put(Category.LateToFlight, new ArrayList<Passenger>());
      passengers.put(Category.BusinessClass, new ArrayList<Passenger>());
      passengers.put(Category.Disabled, new ArrayList<Passenger>());
      passengers.put(Category.Family, new ArrayList<Passenger>());
      passengers.put(Category.Monkey, new ArrayList<Passenger>());
    }

    public void enqueue(Passenger passenger) {
      if (size == capacity)
          throw new IllegalStateException("Cannot add to full queue");
      passengers.get(passenger.getCategory()).add(passenger);
      size++;
      }

    public Passenger dequeue() {
      if (size == 0)
          throw new NoSuchElementException("Cannot remove from empty queue");
      Passenger passenger = getNextPassenger();
      size--;
      return passenger;
      }

    public Passenger peek() {
      if (size == 0)
          throw new NoSuchElementException("Cannot peek into empty queue");
      Passenger passenger = peekNextPassenger();
      return passenger;
      }

    public int size() {
      return size;
      }
    
    private Passenger getNextPassenger() {
        Category[] categories = {Category.LateToFlight,
                                Category.BusinessClass,
                                Category.Disabled,
                                Category.Family,
                                Category.Monkey
        };
        Passenger next = null;
        for (int i = 0; i < categories.length && next == null; i++) {
            next = passengers.get(categories[i]).remove(0);
        }
        return next;
    }
    
    private Passenger peekNextPassenger() {
        Category[] categories = {Category.LateToFlight,
                                Category.BusinessClass,
                                Category.Disabled,
                                Category.Family,
                                Category.Monkey
        };
        Passenger next = null;
        for (int i = 0; i < categories.length && next == null; i++) {
            if (passengers.get(categories[i]).size() > 0)
                next = passengers.get(categories[i]).get(0);
        }
        return next;
    }
    
    }