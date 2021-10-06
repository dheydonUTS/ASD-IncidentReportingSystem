/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author christianlopez
 */
public class OffenderTest {
    
    public OffenderTest() {
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
     * Test of getId method, of class Offender.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Offender instance = new Offender(1, "c", "c", "c", "026", "c", true);
        int expResult = 1;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setId method, of class Offender.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Offender instance = new Offender();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getFirstName method, of class Offender.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Offender instance = new Offender(1, "c", "c", "c", "026", "c", true);
        String expResult = "c";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setFirstName method, of class Offender.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        Offender instance = new Offender();
        instance.setFirstName(firstName);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getLastName method, of class Offender.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Offender instance = new Offender(1, "c", "c", "c", "026", "c", true);
        String expResult = "c";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setLastName method, of class Offender.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        Offender instance = new Offender();
        instance.setLastName(lastName);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEmail method, of class Offender.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Offender instance = new Offender(1, "c", "c", "c", "026", "c", true);
        String expResult = "c";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setEmail method, of class Offender.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Offender instance = new Offender();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPhone method, of class Offender.
     */
    @Test
    public void testGetPhone() {
        System.out.println("getPhone");
        Offender instance = new Offender(1, "c", "c", "c", "026", "c", true);
        String expResult = "026";
        String result = instance.getPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setPhone method, of class Offender.
     */
    @Test
    public void testSetPhone() {
        System.out.println("setPhone");
        String phone = "";
        Offender instance = new Offender();
        instance.setPhone(phone);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getGender method, of class Offender.
     */
    @Test
    public void testGetGender() {
        System.out.println("getGender");
        Offender instance = new Offender(1, "c", "c", "c", "026", "male", true);
        String expResult = "male";
        String result = instance.getGender();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setGender method, of class Offender.
     */
    @Test
    public void testSetGender() {
        System.out.println("setGender");
        String gender = "";
        Offender instance = new Offender();
        instance.setGender(gender);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isIsBanned method, of class Offender.
     */
    @Test
    public void testIsIsBanned() {
        System.out.println("isIsBanned");
        Offender instance = new Offender();
        boolean expResult = false;
        boolean result = instance.isIsBanned();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setIsBanned method, of class Offender.
     */
    @Test
    public void testSetIsBanned() {
        System.out.println("setIsBanned");
        boolean isBanned = false;
        Offender instance = new Offender();
        instance.setIsBanned(isBanned);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
