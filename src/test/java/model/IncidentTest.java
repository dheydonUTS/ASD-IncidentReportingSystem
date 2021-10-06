/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author dom_h
 */
public class IncidentTest {
    
    public IncidentTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }

    /**
     * Test of getId method, of class Incident.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Incident instance = new Incident();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Incident.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Incident instance = new Incident();
        instance.setId(id);
    }

    /**
     * Test of getVenue method, of class Incident.
     */
    @Test
    public void testGetVenue() {
        System.out.println("getVenue");
        Incident instance = new Incident();
        Venue expResult = null;
        Venue result = instance.getVenue();
        assertEquals(expResult, result);
    }

    /**
     * Test of setVenue method, of class Incident.
     */
    @Test
    public void testSetVenue() {
        System.out.println("setVenue");
        Venue venue = null;
        Incident instance = new Incident();
        instance.setVenue(venue);

    }


    /**
     * Test of setType method, of class Incident.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "";
        Incident instance = new Incident();
        instance.setType(type);
    }


    /**
     * Test of setDescription method, of class Incident.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Incident instance = new Incident();
        instance.setDescription(description);
    }

    /**
     * Test of getReporter method, of class Incident.
     */
    @Test
    public void testGetReporter() {
        System.out.println("getReporter");
        Incident instance = new Incident();
        User expResult = null;
        User result = instance.getReporter();
        assertEquals(expResult, result);

    }

    /**
     * Test of setReporter method, of class Incident.
     */
    @Test
    public void testSetReporter() {
        System.out.println("setReporter");
        User reporter = null;
        Incident instance = new Incident();
        instance.setReporter(reporter);
    }

    /**
     * Test of getOffender method, of class Incident.
     */
    @Test
    public void testGetOffender() {
        System.out.println("getOffender");
        Incident instance = new Incident();
        Offender expResult = null;
        Offender result = instance.getOffender();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOffender method, of class Incident.
     */
    @Test
    public void testSetOffender() {
        System.out.println("setOffender");
        Offender offender = null;
        Incident instance = new Incident();
        instance.setOffender(offender);
    }

    /**
     * Test of getAssignedUser method, of class Incident.
     */
    @Test
    public void testGetAssignedUser() {
        System.out.println("getAssignedUser");
        Incident instance = new Incident();
        User expResult = null;
        User result = instance.getAssignedUser();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAssignedUser method, of class Incident.
     */
    @Test
    public void testSetAssignedUser() {
        System.out.println("setAssignedUser");
        User assignedUser = null;
        Incident instance = new Incident();
        instance.setAssignedUser(assignedUser);
    }

    /**
     * Test of getCreatedTime method, of class Incident.
     */
    @Test
    public void testGetCreatedTime() {
        System.out.println("getCreatedTime");
        Incident instance = new Incident();
        LocalDateTime expResult = null;
        LocalDateTime result = instance.getCreatedTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCreatedTime method, of class Incident.
     */
    @Test
    public void testSetCreatedTime() {
        System.out.println("setCreatedTime");
        LocalDateTime createdTime = null;
        Incident instance = new Incident();
        instance.setCreatedTime(createdTime);
    }

    /**
     * Test of getClosedTime method, of class Incident.
     */
    @Test
    public void testGetClosedTime() {
        System.out.println("getClosedTime");
        Incident instance = new Incident();
        LocalDateTime expResult = null;
        LocalDateTime result = instance.getClosedTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setClosedTime method, of class Incident.
     */
    @Test
    public void testSetClosedTime() {
        System.out.println("setClosedTime");
        LocalDateTime closedTime = null;
        Incident instance = new Incident();
        instance.setClosedTime(closedTime);
    }

    /**
     * Test of setStatus method, of class Incident.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String status = "";
        Incident instance = new Incident();
        instance.setStatus(status);
    }

    /**
     * Test of getPriority method, of class Incident.
     */
    @Test
    public void testGetPriority() {
        System.out.println("getPriority");
        Incident instance = new Incident();
        int expResult = 0;
        int result = instance.getPriority();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPriority method, of class Incident.
     */
    @Test
    public void testSetPriority() {
        System.out.println("setPriority");
        int priority = 0;
        Incident instance = new Incident();
        instance.setPriority(priority);
    }

    /**
     * Test of getIncidentDate method, of class Incident.
     */
    @Test
    public void testGetIncidentDate() {
        System.out.println("getIncidentDate");
        Incident instance = new Incident();
        LocalDate expResult = null;
        LocalDate result = instance.getIncidentDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIncidentDate method, of class Incident.
     */
    @Test
    public void testSetIncidentDate() {
        System.out.println("setIncidentDate");
        LocalDate incidentDate = null;
        Incident instance = new Incident();
        instance.setIncidentDate(incidentDate);
    }

    /**
     * Test of getIncidentTime method, of class Incident.
     */
    @Test
    public void testGetIncidentTime() {
        System.out.println("getIncidentTime");
        Incident instance = new Incident();
        LocalTime expResult = null;
        LocalTime result = instance.getIncidentTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIncidentTime method, of class Incident.
     */
    @Test
    public void testSetIncidentTime() {
        System.out.println("setIncidentTime");
        LocalTime incidentTime = null;
        Incident instance = new Incident();
        instance.setIncidentTime(incidentTime);
    }
    
}
