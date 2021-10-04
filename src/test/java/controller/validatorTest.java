/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.regex.Pattern;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author dom_h
 */
public class validatorTest {
    
    public validatorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }

    /**
     * Test of validate method, of class validator.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        Pattern pattern = Pattern.compile("([a-zA-Z0-9._-]+)(@)([a-zA-Z0-9]+)(.)([a-zA-Z0-9._-]+)");
        String in = "email@email.com";
        validator instance = new validator();
        boolean expResult = true;
        boolean result = instance.validate(pattern, in);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateEmail method, of class validator.
     */
    @Test
    public void testValidateEmail() {
        System.out.println("validateEmail");
        String email = "";
        validator instance = new validator();
        boolean expResult = false;
        boolean result = instance.validateEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of validatePassword method, of class validator.
     */
    @Test
    public void testValidatePassword() {
        System.out.println("validatePassword");
        String password = "";
        validator instance = new validator();
        boolean expResult = false;
        boolean result = instance.validatePassword(password);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateName method, of class validator.
     */
    @Test
    public void testValidateName() {
        System.out.println("validateName");
        String name = "";
        validator instance = new validator();
        boolean expResult = false;
        boolean result = instance.validateName(name);
        assertEquals(expResult, result);
    }
    
}
