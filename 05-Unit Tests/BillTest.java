/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package espe.edu.ec.model;

import espe.edu.ec.utils.ManageFileJson;
import java.util.Map;
import java.util.Scanner;
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
public class BillTest {
    
    public BillTest() {
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
     * Test of getDate method, of class Bill.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Bill instance = null;
        String expResult = "";
        String result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printBill method, of class Bill.
     */
    @Test
    public void testPrintBill() {
        System.out.println("printBill");
        Scanner scanner = null;
        ManageFileJson manageFileJson = null;
        Bill instance = null;
        instance.printBill(scanner, manageFileJson);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomer method, of class Bill.
     */
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        Bill instance = null;
        Customer expResult = null;
        Customer result = instance.getCustomer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrder method, of class Bill.
     */
    @Test
    public void testGetOrder() {
        System.out.println("getOrder");
        Bill instance = null;
        Map<String, Integer> expResult = null;
        Map<String, Integer> result = instance.getOrder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotal method, of class Bill.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        Bill instance = null;
        float expResult = 0.0F;
        float result = instance.getTotal();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderDetails method, of class Bill.
     */
    @Test
    public void testGetOrderDetails() {
        System.out.println("getOrderDetails");
        Bill instance = null;
        String expResult = "";
        String result = instance.getOrderDetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerDetails method, of class Bill.
     */
    @Test
    public void testGetCustomerDetails() {
        System.out.println("getCustomerDetails");
        Bill instance = null;
        String expResult = "";
        String result = instance.getCustomerDetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Bill.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Bill instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
