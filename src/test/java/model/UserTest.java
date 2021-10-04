/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import model.dao.DBConnector;
import model.dao.DBManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author dom_h
 */
public class UserTest {
    private DBConnector connector;
    private Connection conn;
    private DBManager manager;
        
    public UserTest() throws ClassNotFoundException, SQLException {
        connector = new DBConnector();
        conn = connector.connection();
        manager = new DBManager(conn);
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        User instance = new User("email","password");
        String expResult = "email";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        User instance = new User("email","password");
        String expResult = "password";
        String result = instance.getPassword();
        assertEquals(expResult, result);

    }
    
    @Test
    public void testFindUser() throws SQLException {
        System.out.println("FindUser");
        User exUser = new User("abc@abc.com", "password123");
        User outUser = manager.findUser("abc@abc.com", "password123");
        assertEquals(exUser.getEmail(), outUser.getEmail());
        assertEquals(exUser.getPassword(), outUser.getPassword());
    }

    
    
}
