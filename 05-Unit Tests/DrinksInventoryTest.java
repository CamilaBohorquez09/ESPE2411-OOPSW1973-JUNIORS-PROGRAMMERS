/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package espe.edu.ec.model;

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
public class DrinksInventoryTest {
    
    public DrinksInventoryTest() {
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
     * Test of toString method, of class DrinksInventory.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        DrinksInventory instance = new DrinksInventory();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdInventory method, of class DrinksInventory.
     */
    @Test
    public void testGetIdInventory() {
        System.out.println("getIdInventory");
        DrinksInventory instance = new DrinksInventory();
        int expResult = 0;
        int result = instance.getIdInventory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdInventory method, of class DrinksInventory.
     */
    @Test
    public void testSetIdInventory() {
        System.out.println("setIdInventory");
        int idInventory = 0;
        DrinksInventory instance = new DrinksInventory();
        instance.setIdInventory(idInventory);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNameDrinks method, of class DrinksInventory.
     */
    @Test
    public void testGetNameDrinks() {
        System.out.println("getNameDrinks");
        DrinksInventory instance = new DrinksInventory();
        String expResult = "";
        String result = instance.getNameDrinks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNameDrinks method, of class DrinksInventory.
     */
    @Test
    public void testSetNameDrinks() {
        System.out.println("setNameDrinks");
        String nameDrinks = "";
        DrinksInventory instance = new DrinksInventory();
        instance.setNameDrinks(nameDrinks);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddressOfDescription method, of class DrinksInventory.
     */
    @Test
    public void testGetAddressOfDescription() {
        System.out.println("getAddressOfDescription");
        DrinksInventory instance = new DrinksInventory();
        String expResult = "";
        String result = instance.getAddressOfDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddressOfDescription method, of class DrinksInventory.
     */
    @Test
    public void testSetAddressOfDescription() {
        System.out.println("setAddressOfDescription");
        String addressOfDescription = "";
        DrinksInventory instance = new DrinksInventory();
        instance.setAddressOfDescription(addressOfDescription);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class DrinksInventory.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        DrinksInventory instance = new DrinksInventory();
        float expResult = 0.0F;
        float result = instance.getPrice();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrice method, of class DrinksInventory.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        float price = 0.0F;
        DrinksInventory instance = new DrinksInventory();
        instance.setPrice(price);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAvailable method, of class DrinksInventory.
     */
    @Test
    public void testIsAvailable() {
        System.out.println("isAvailable");
        DrinksInventory instance = new DrinksInventory();
        boolean expResult = false;
        boolean result = instance.isAvailable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAvailable method, of class DrinksInventory.
     */
    @Test
    public void testSetAvailable() {
        System.out.println("setAvailable");
        boolean isAvailable = false;
        DrinksInventory instance = new DrinksInventory();
        instance.setAvailable(isAvailable);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reduceInventory method, of class DrinksInventory.
     */
    @Test
    public void testReduceInventory() {
        System.out.println("reduceInventory");
        int quantity = 0;
        DrinksInventory instance = new DrinksInventory();
        instance.reduceInventory(quantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
