/*
 * Joe Test Class
 * 
 * 
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
 * @author joe
 */
public class WarningTest {
    
    public WarningTest() {
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
     * Test of getId method, of class Warning.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Warning instance = new Warning(1,1,"e",1);
        int expResult = 1;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Warning.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 1;
        Warning instance = new Warning(1,1,"e",1);
        instance.setId(id);

    }

    /**
     * Test of getVenue_id method, of class Warning.
     */
    @Test
    public void testGetVenue_id() {
        System.out.println("getVenue_id");
        Warning instance = new Warning(1,1,"e",1);
        int expResult = 1;
        int result = instance.getVenue_id();
        assertEquals(expResult, result);

    }

    /**
     * Test of setVenue_id method, of class Warning.
     */
    @Test
    public void testSetVenue_id() {
        System.out.println("setVenue_id");
        int venue_id = 1;
        Warning instance = new Warning(1,1,"e",1);
        instance.setVenue_id(venue_id);

    }

    /**
     * Test of getDescription method, of class Warning.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Warning instance = new Warning(1,1,"e",1);
        String expResult = "e";
        String result = instance.getDescription();
        assertEquals(expResult, result);

    }

    /**
     * Test of setDescription method, of class Warning.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "e";
        Warning instance = new Warning(1,1,"e",1);
        instance.setDescription(description);

    }

    /**
     * Test of getOffender_id method, of class Warning.
     */
    @Test
    public void testGetOffender_id() {
        System.out.println("getOffender_id");
        Warning instance = new Warning(1,1,"e",1);
        int expResult = 1;
        int result = instance.getOffender_id();
        assertEquals(expResult, result);

    }

    /**
     * Test of setOffender_id method, of class Warning.
     */
    @Test
    public void testSetOffender_id() {
        System.out.println("setOffender_id");
        int offender_id = 1;
        Warning instance = new Warning(1,1,"e",1);
        instance.setOffender_id(offender_id);

    }
    
}
