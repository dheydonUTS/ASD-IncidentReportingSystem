/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author dom_h
 */
public class allocateTicketTest {
    
    public allocateTicketTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }

    /**
     * Test of nextFreeStaff method, of class allocateTicket.
     */
    @Test
    public void testNextFreeStaff() {
        System.out.println("nextFreeStaff");
        ArrayList staff = new ArrayList<int[]>();
        allocateTicket instance = new allocateTicket();
        int expResult = 0;
        int result = instance.nextFreeStaff(staff);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
