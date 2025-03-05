/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package espe.edu.ec.model;

import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Camila Bohorquez
 */
public class CashierTest {
    
    public CashierTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of calculateTotal method, of class Cashier.
     */
    @Test
    public void testCalculateTotal() {
        System.out.println("calculateTotal");
        Map<String, Integer> order = null;
        Map<String, Float> menuItems = null;
        Cashier instance = null;
        instance.calculateTotal(order, menuItems);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateInventory method, of class Cashier.
     */
    @Test
    public void testUpdateInventory() {
        System.out.println("updateInventory");
        Map<String, Integer> order = null;
        Map<String, Integer> inventory = null;
        Cashier instance = null;
        instance.updateInventory(order, inventory);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalToPay method, of class Cashier.
     */
    @Test
    public void testGetTotalToPay() {
        System.out.println("getTotalToPay");
        Cashier instance = null;
        float expResult = 0.0F;
        float result = instance.getTotalToPay();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomer method, of class Cashier.
     */
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        Cashier instance = null;
        Customer expResult = null;
        Customer result = instance.getCustomer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
