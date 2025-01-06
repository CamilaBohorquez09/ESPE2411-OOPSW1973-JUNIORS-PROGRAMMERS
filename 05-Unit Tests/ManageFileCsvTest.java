/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package espe.edu.ec.utils;

import espe.edu.ec.model.Order;
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
public class ManageFileCsvTest {
    
    public ManageFileCsvTest() {
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
     * Test of saveOrderToCsv method, of class ManageFileCsv.
     */
    @Test
    public void testSaveOrderToCsv() {
        System.out.println("saveOrderToCsv");
        Order order = null;
        ManageFileCsv instance = new ManageFileCsv();
        instance.saveOrderToCsv(order);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
