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
public class SneakyPrioritisingPassengerQueue implements PriorityQueue<Passenger> {
    Map<Category, List<Passenger>> passengers;
    private int size = 0;
    private int capacity = 0;
    

    public SneakyPrioritisingPassengerQueue(int capacity) {
      this.capacity = capacity;
      passengers = new HashMap<Category, List<Passenger>>() {{
        put(Category.LateToFlight, new ArrayList<>());
        put(Category.BusinessClass, new ArrayList<>());
        put(Category.Disabled, new ArrayList<>());
        put(Category.Family, new ArrayList<>());
        put(Category.Monkey, new ArrayList<>());
      }};
    }

    @Override
    public void enqueue(Passenger passenger) {
      if (size == capacity)
          throw new IllegalStateException("Cannot add to full queue");
      passengers.get(passenger.getCategory()).add(passenger);
      size++;
    }

    @Override
    public Passenger dequeue() {
      if (size == 0)
          throw new NoSuchElementException("Cannot remove from empty queue");
      Passenger passenger = getNextPassenger();
      size--;
      return passenger;
    }

    @Override
    public Passenger peek() {
      if (size == 0)
          throw new NoSuchElementException("Cannot peek into empty queue");
      Passenger passenger = peekNextPassenger();
      return passenger;
      }

    @Override
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
            if (passengers.get(categories[i]).size() > 0)
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