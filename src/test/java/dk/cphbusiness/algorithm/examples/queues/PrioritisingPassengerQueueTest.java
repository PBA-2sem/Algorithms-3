/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.algorithm.examples.queues;

import dk.cphbusiness.airport.template.Passenger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Orchi
 */
public class PrioritisingPassengerQueueTest {
    
    public PrioritisingPassengerQueueTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of enqueue method, of class PrioritisingPassengerQueue.
     */
    @Test
    public void testEnqueue() {
        System.out.println("enqueue");
        Passenger passenger = null;
        PrioritisingPassengerQueue instance = null;
        instance.enqueue(passenger);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dequeue method, of class PrioritisingPassengerQueue.
     */
    @Test
    public void testDequeue() {
        System.out.println("dequeue");
        PrioritisingPassengerQueue instance = null;
        Passenger expResult = null;
        Passenger result = instance.dequeue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of peek method, of class PrioritisingPassengerQueue.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        PrioritisingPassengerQueue instance = null;
        Passenger expResult = null;
        Passenger result = instance.peek();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class PrioritisingPassengerQueue.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        PrioritisingPassengerQueue instance = null;
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
