/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author arun
 */
public class RegisterServletTest {
    
    public RegisterServletTest() {
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
    
    @Test // Testing PasswordMatch method in Register Servlet
    public void testPasswordMatch() throws Exception {
         System.out.println("Test PasswordMatch Method\n");
        String pass1 = "Test";
        String pass2 = "Test";
        String pass3 = "Test1";
        RegisterServlet instance = new RegisterServlet();
        Boolean test1 = instance.passwordMatch(pass1, pass2);
        Boolean test2 = instance.passwordMatch(pass2, pass3);
        assertEquals(test1, true);
        assertEquals(test2, false);
    }
}
