/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package espe.edu.ec.utils;

import java.util.Scanner;
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
public class AdminPermissionsTest {
    
    public AdminPermissionsTest() {
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
     * Test of validatePassword method, of class AdminPermissions.
     */
    @Test
    public void testValidatePassword() {
        System.out.println("validatePassword");
        String inputPassword = "";
        AdminPermissions instance = new AdminPermissions();
        boolean expResult = false;
        boolean result = instance.validatePassword(inputPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adminPermissions method, of class AdminPermissions.
     */
    @Test
    public void testAdminPermissions() {
        System.out.println("adminPermissions");
        Scanner scanner = null;
        ManageFileJson manageFileJson = null;
        AdminPermissions instance = new AdminPermissions();
        instance.adminPermissions(scanner, manageFileJson);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
