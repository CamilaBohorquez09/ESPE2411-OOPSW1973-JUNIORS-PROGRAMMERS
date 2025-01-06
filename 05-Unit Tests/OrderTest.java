/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package espe.edu.ec.model;

import espe.edu.ec.utils.ManageFileJson;
import espe.edu.ec.utils.Validations;
import java.util.Date;
import java.util.List;
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
public class OrderTest {
    
    public OrderTest() {
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
     * Test of placeOrder method, of class Order.
     */
    @Test
    public void testPlaceOrder() {
        System.out.println("placeOrder");
        Scanner scanner = null;
        Validations validations = null;
        ManageFileJson manageFileJson = null;
        Order instance = new Order();
        instance.placeOrder(scanner, validations, manageFileJson);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItems method, of class Order.
     */
    @Test
    public void testGetItems() {
        System.out.println("getItems");
        Order instance = new Order();
        Map<String, Integer> expResult = null;
        Map<String, Integer> result = instance.getItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderId method, of class Order.
     */
    @Test
    public void testGetOrderId() {
        System.out.println("getOrderId");
        Order instance = new Order();
        int expResult = 0;
        int result = instance.getOrderId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrderId method, of class Order.
     */
    @Test
    public void testSetOrderId() {
        System.out.println("setOrderId");
        int orderId = 0;
        Order instance = new Order();
        instance.setOrderId(orderId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerId method, of class Order.
     */
    @Test
    public void testGetCustomerId() {
        System.out.println("getCustomerId");
        Order instance = new Order();
        int expResult = 0;
        int result = instance.getCustomerId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomerId method, of class Order.
     */
    @Test
    public void testSetCustomerId() {
        System.out.println("setCustomerId");
        int customerId = 0;
        Order instance = new Order();
        instance.setCustomerId(customerId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerName method, of class Order.
     */
    @Test
    public void testGetCustomerName() {
        System.out.println("getCustomerName");
        Order instance = new Order();
        String expResult = "";
        String result = instance.getCustomerName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomerName method, of class Order.
     */
    @Test
    public void testSetCustomerName() {
        System.out.println("setCustomerName");
        String customerName = "";
        Order instance = new Order();
        instance.setCustomerName(customerName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderedItems method, of class Order.
     */
    @Test
    public void testGetOrderedItems() {
        System.out.println("getOrderedItems");
        Order instance = new Order();
        List<MenuItem> expResult = null;
        List<MenuItem> result = instance.getOrderedItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrderedItems method, of class Order.
     */
    @Test
    public void testSetOrderedItems() {
        System.out.println("setOrderedItems");
        List<MenuItem> orderedItems = null;
        Order instance = new Order();
        instance.setOrderedItems(orderedItems);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTableNumber method, of class Order.
     */
    @Test
    public void testGetTableNumber() {
        System.out.println("getTableNumber");
        Order instance = new Order();
        String expResult = "";
        String result = instance.getTableNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTableNumber method, of class Order.
     */
    @Test
    public void testSetTableNumber() {
        System.out.println("setTableNumber");
        String tableNumber = "";
        Order instance = new Order();
        instance.setTableNumber(tableNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderDate method, of class Order.
     */
    @Test
    public void testGetOrderDate() {
        System.out.println("getOrderDate");
        Order instance = new Order();
        Date expResult = null;
        Date result = instance.getOrderDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrderDate method, of class Order.
     */
    @Test
    public void testSetOrderDate() {
        System.out.println("setOrderDate");
        Date orderDate = null;
        Order instance = new Order();
        instance.setOrderDate(orderDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSaleNote method, of class Order.
     */
    @Test
    public void testGetSaleNote() {
        System.out.println("getSaleNote");
        Order instance = new Order();
        SaleNote expResult = null;
        SaleNote result = instance.getSaleNote();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSaleNote method, of class Order.
     */
    @Test
    public void testSetSaleNote() {
        System.out.println("setSaleNote");
        SaleNote saleNote = null;
        Order instance = new Order();
        instance.setSaleNote(saleNote);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Order.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Order instance = new Order();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
