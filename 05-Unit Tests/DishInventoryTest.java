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
public class DishInventoryTest {
    
    public DishInventoryTest() {
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
     * Test of toString method, of class DishInventory.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        DishInventory instance = new DishInventory();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdDishInventory method, of class DishInventory.
     */
    @Test
    public void testGetIdDishInventory() {
        System.out.println("getIdDishInventory");
        DishInventory instance = new DishInventory();
        int expResult = 0;
        int result = instance.getIdDishInventory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdDishInventory method, of class DishInventory.
     */
    @Test
    public void testSetIdDishInventory() {
        System.out.println("setIdDishInventory");
        int idInventory = 0;
        DishInventory instance = new DishInventory();
        instance.setIdDishInventory(idInventory);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNameDrinks method, of class DishInventory.
     */
    @Test
    public void testGetNameDrinks() {
        System.out.println("getNameDrinks");
        DishInventory instance = new DishInventory();
        String expResult = "";
        String result = instance.getNameDrinks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNameDrinks method, of class DishInventory.
     */
    @Test
    public void testSetNameDrinks() {
        System.out.println("setNameDrinks");
        String nameDrinks = "";
        DishInventory instance = new DishInventory();
        instance.setNameDrinks(nameDrinks);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddressOfDescription method, of class DishInventory.
     */
    @Test
    public void testGetAddressOfDescription() {
        System.out.println("getAddressOfDescription");
        DishInventory instance = new DishInventory();
        String expResult = "";
        String result = instance.getAddressOfDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddressOfDescription method, of class DishInventory.
     */
    @Test
    public void testSetAddressOfDescription() {
        System.out.println("setAddressOfDescription");
        String addressOfDescription = "";
        DishInventory instance = new DishInventory();
        instance.setAddressOfDescription(addressOfDescription);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class DishInventory.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        DishInventory instance = new DishInventory();
        float expResult = 0.0F;
        float result = instance.getPrice();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrice method, of class DishInventory.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        float price = 0.0F;
        DishInventory instance = new DishInventory();
        instance.setPrice(price);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAvailable method, of class DishInventory.
     */
    @Test
    public void testIsAvailable() {
        System.out.println("isAvailable");
        DishInventory instance = new DishInventory();
        boolean expResult = false;
        boolean result = instance.isAvailable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAvailable method, of class DishInventory.
     */
    @Test
    public void testSetAvailable() {
        System.out.println("setAvailable");
        boolean isAvailable = false;
        DishInventory instance = new DishInventory();
        instance.setAvailable(isAvailable);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reduceInventory method, of class DishInventory.
     */
    @Test
    public void testReduceInventory() {
        System.out.println("reduceInventory");
        int quantity = 0;
        DishInventory instance = new DishInventory();
        instance.reduceInventory(quantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
