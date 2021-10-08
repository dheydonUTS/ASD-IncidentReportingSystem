/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Incident;
import model.Offender;
import model.User;
import model.Venue;
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
public class GraphsMapsServletTest {
    
    public GraphsMapsServletTest() {
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

    /** T9-1
     * Test of incidentTypeCount method, of class GraphsMapsServlet.
     */
    @Test
    public void testIncidentTypeCount() {
        System.out.println("incidentTypeCount");
        LinkedList<Incident> IncidentList = new LinkedList();
        IncidentList.push(new Incident(1, new Venue(), "Theft", "e", new User(), new Offender(), LocalDate.now(), LocalTime.now(), new User(), LocalDateTime.now(), 1));
        GraphsMapsServlet instance = new GraphsMapsServlet();
        HashMap<String, Integer> expResult = new HashMap();
        expResult.put("Theft",1);
        HashMap<String, Integer> result = instance.incidentTypeCount(IncidentList);
        assertEquals(expResult, result);
    }

    /**T9-2
     * Test of venueIncidentCount method, of class GraphsMapsServlet.
     */
    @Test
    public void testVenueIncidentCount() {
        System.out.println("venueIncidentCount");
        LinkedList<Incident> IncidentList = new LinkedList();
        Venue expVenue = new Venue(1, "Name", "Addr", 1, 1);
        IncidentList.push(new Incident(1,expVenue, "Theft", "e", new User(), new Offender(), LocalDate.now(), LocalTime.now(), new User(), LocalDateTime.now(), 1));
        GraphsMapsServlet instance = new GraphsMapsServlet();
        HashMap<Venue, Integer> expResult = new HashMap();
        expResult.put(expVenue, 1);
        HashMap<Venue, Integer> result = instance.venueIncidentCount(IncidentList);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
