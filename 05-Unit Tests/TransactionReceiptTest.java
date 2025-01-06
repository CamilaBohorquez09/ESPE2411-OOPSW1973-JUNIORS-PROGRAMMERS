/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package espe.edu.ec.model;

import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Camila Bohorquez
 */
public class TransactionReceiptTest {
    
    public TransactionReceiptTest() {
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
     * Test of getCustomer method, of class TransactionReceipt.
     */
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        TransactionReceipt instance = null;
        Customer expResult = null;
        Customer result = instance.getCustomer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrder method, of class TransactionReceipt.
     */
    @Test
    public void testGetOrder() {
        System.out.println("getOrder");
        TransactionReceipt instance = null;
        Map<String, Integer> expResult = null;
        Map<String, Integer> result = instance.getOrder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotal method, of class TransactionReceipt.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        TransactionReceipt instance = null;
        float expResult = 0.0F;
        float result = instance.getTotal();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class TransactionReceipt.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        TransactionReceipt instance = null;
        String expResult = "";
        String result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderDetails method, of class TransactionReceipt.
     */
    @Test
    public void testGetOrderDetails() {
        System.out.println("getOrderDetails");
        TransactionReceipt instance = null;
        String expResult = "";
        String result = instance.getOrderDetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class TransactionReceipt.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        TransactionReceipt instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class TransactionReceiptImpl extends TransactionReceipt {

        public TransactionReceiptImpl() {
            super(null, null, 0.0F);
        }

        public String toString() {
            return "";
        }
    }
    
}
