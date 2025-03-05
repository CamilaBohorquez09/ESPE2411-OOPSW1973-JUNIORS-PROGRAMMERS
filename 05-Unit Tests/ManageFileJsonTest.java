/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package espe.edu.ec.utils;

import espe.edu.ec.model.Bill;
import espe.edu.ec.model.Customer;
import espe.edu.ec.model.SaleNote;
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
public class ManageFileJsonTest {
    
    public ManageFileJsonTest() {
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
     * Test of saveBillToJson method, of class ManageFileJson.
     */
    @Test
    public void testSaveBillToJson() {
        System.out.println("saveBillToJson");
        Bill bill = null;
        ManageFileJson instance = new ManageFileJson();
        instance.saveBillToJson(bill);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveSaleNoteToJson method, of class ManageFileJson.
     */
    @Test
    public void testSaveSaleNoteToJson() {
        System.out.println("saveSaleNoteToJson");
        SaleNote saleNote = null;
        ManageFileJson instance = new ManageFileJson();
        instance.saveSaleNoteToJson(saleNote);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveCommentToJson method, of class ManageFileJson.
     */
    @Test
    public void testSaveCommentToJson() {
        System.out.println("saveCommentToJson");
        String comment = "";
        ManageFileJson instance = new ManageFileJson();
        instance.saveCommentToJson(comment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerById method, of class ManageFileJson.
     */
    @Test
    public void testGetCustomerById() {
        System.out.println("getCustomerById");
        String idCard = "";
        ManageFileJson instance = new ManageFileJson();
        Customer expResult = null;
        Customer result = instance.getCustomerById(idCard);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderByCustomer method, of class ManageFileJson.
     */
    @Test
    public void testGetOrderByCustomer() {
        System.out.println("getOrderByCustomer");
        String idCard = "";
        ManageFileJson instance = new ManageFileJson();
        Map<String, Integer> expResult = null;
        Map<String, Integer> result = instance.getOrderByCustomer(idCard);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSalesNoteByCustomer method, of class ManageFileJson.
     */
    @Test
    public void testGetSalesNoteByCustomer() {
        System.out.println("getSalesNoteByCustomer");
        String idCard = "";
        ManageFileJson instance = new ManageFileJson();
        SaleNote expResult = null;
        SaleNote result = instance.getSalesNoteByCustomer(idCard);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveQuantitiesToJson method, of class ManageFileJson.
     */
    @Test
    public void testSaveQuantitiesToJson() {
        System.out.println("saveQuantitiesToJson");
        ManageFileJson instance = new ManageFileJson();
        instance.saveQuantitiesToJson();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadQuantitiesFromJson method, of class ManageFileJson.
     */
    @Test
    public void testLoadQuantitiesFromJson() {
        System.out.println("loadQuantitiesFromJson");
        ManageFileJson instance = new ManageFileJson();
        instance.loadQuantitiesFromJson();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
