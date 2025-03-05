/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package espe.edu.ec.model;

import java.util.List;
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
public class MenuItemTest {
    
    public MenuItemTest() {
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
     * Test of initializeMenu method, of class MenuItem.
     */
    @Test
    public void testInitializeMenu() {
        System.out.println("initializeMenu");
        MenuItem.initializeMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayMenu method, of class MenuItem.
     */
    @Test
    public void testDisplayMenu() {
        System.out.println("displayMenu");
        MenuItem.displayMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMenuItemById method, of class MenuItem.
     */
    @Test
    public void testGetMenuItemById() {
        System.out.println("getMenuItemById");
        int id = 0;
        MenuItem expResult = null;
        MenuItem result = MenuItem.getMenuItemById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reduceInventory method, of class MenuItem.
     */
    @Test
    public void testReduceInventory() {
        System.out.println("reduceInventory");
        int quantity = 0;
        MenuItem instance = null;
        instance.reduceInventory(quantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class MenuItem.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        MenuItem instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class MenuItem.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        MenuItem instance = null;
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class MenuItem.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        MenuItem instance = null;
        float expResult = 0.0F;
        float result = instance.getPrice();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInventory method, of class MenuItem.
     */
    @Test
    public void testGetInventory() {
        System.out.println("getInventory");
        MenuItem instance = null;
        int expResult = 0;
        int result = instance.getInventory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMenuItems method, of class MenuItem.
     */
    @Test
    public void testGetMenuItems() {
        System.out.println("getMenuItems");
        List<MenuItem> expResult = null;
        List<MenuItem> result = MenuItem.getMenuItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class MenuItem.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        MenuItem instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
