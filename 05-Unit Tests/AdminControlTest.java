/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package espe.edu.ec.model;

import espe.edu.ec.utils.ManageFileJson;
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
public class AdminControlTest {
    
    public AdminControlTest() {
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
     * Test of refillMenuInventory method, of class AdminControl.
     */
    @Test
    public void testRefillMenuInventory() {
        System.out.println("refillMenuInventory");
        Scanner scanner = null;
        ManageFileJson manageFileJson = null;
        AdminControl instance = new AdminControl();
        instance.refillMenuInventory(scanner, manageFileJson);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adminPermissions method, of class AdminControl.
     */
    @Test
    public void testAdminPermissions() {
        System.out.println("adminPermissions");
        Scanner scanner = null;
        ManageFileJson manageFileJson = null;
        AdminControl instance = new AdminControl();
        instance.adminPermissions(scanner, manageFileJson);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
