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
public class ValidationsTest {
    
    public ValidationsTest() {
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
     * Test of validateOnlyLetters method, of class Validations.
     */
    @Test
    public void testValidateOnlyLetters() {
        System.out.println("validateOnlyLetters");
        String input = "";
        boolean expResult = false;
        boolean result = Validations.validateOnlyLetters(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateIDCard method, of class Validations.
     */
    @Test
    public void testValidateIDCard() {
        System.out.println("validateIDCard");
        String idCard = "";
        boolean expResult = false;
        boolean result = Validations.validateIDCard(idCard);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateEmail method, of class Validations.
     */
    @Test
    public void testValidateEmail() {
        System.out.println("validateEmail");
        String correo = "";
        boolean expResult = false;
        boolean result = Validations.validateEmail(correo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateOption method, of class Validations.
     */
    @Test
    public void testValidateOption_3args() {
        System.out.println("validateOption");
        int min = 0;
        int max = 0;
        Scanner scanner = null;
        int expResult = 0;
        int result = Validations.validateOption(min, max, scanner);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validatePhone method, of class Validations.
     */
    @Test
    public void testValidatePhone_String() {
        System.out.println("validatePhone");
        String telefono = "";
        boolean expResult = false;
        boolean result = Validations.validatePhone(telefono);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateOption method, of class Validations.
     */
    @Test
    public void testValidateOption_int() {
        System.out.println("validateOption");
        int choice = 0;
        Validations instance = new Validations();
        instance.validateOption(choice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateMenuOption method, of class Validations.
     */
    @Test
    public void testValidateMenuOption() {
        System.out.println("validateMenuOption");
        int choice = 0;
        Validations instance = new Validations();
        instance.validateMenuOption(choice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateInt method, of class Validations.
     */
    @Test
    public void testValidateInt() {
        System.out.println("validateInt");
        Validations instance = new Validations();
        int expResult = 0;
        int result = instance.validateInt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateNonNullString method, of class Validations.
     */
    @Test
    public void testValidateNonNullString() {
        System.out.println("validateNonNullString");
        Validations instance = new Validations();
        String expResult = "";
        String result = instance.validateNonNullString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateEmailInput method, of class Validations.
     */
    @Test
    public void testValidateEmailInput() {
        System.out.println("validateEmailInput");
        Validations instance = new Validations();
        String expResult = "";
        String result = instance.validateEmailInput();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateQuantity method, of class Validations.
     */
    @Test
    public void testValidateQuantity() {
        System.out.println("validateQuantity");
        Validations instance = new Validations();
        int expResult = 0;
        int result = instance.validateQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validatePhone method, of class Validations.
     */
    @Test
    public void testValidatePhone_0args() {
        System.out.println("validatePhone");
        Validations instance = new Validations();
        String expResult = "";
        String result = instance.validatePhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidIDCard method, of class Validations.
     */
    @Test
    public void testIsValidIDCard() throws Exception {
        System.out.println("isValidIDCard");
        String cedula = "";
        Validations instance = new Validations();
        boolean expResult = false;
        boolean result = instance.isValidIDCard(cedula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
