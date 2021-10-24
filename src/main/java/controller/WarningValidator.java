/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Offender;
import model.Venue;
import model.Warning;
import model.dao.DBConnector;
import model.dao.DBManager;

/**
 *
 * @author joeda
 */
public class WarningValidator {
    
    private DBConnector conn;
    private DBManager manager;
    
    public WarningValidator(){
        try {
            conn = new DBConnector();
            manager = new DBManager(conn.connection());
        } catch (Exception ex) {
            Logger.getLogger(IssueWarningServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Checks inputs, returns a LinkedList of errors
    public LinkedList<String> checkInputs(String venue_id, String description, String offender_id) {
        LinkedList<String> errors = new LinkedList();

        //Run methods for each input, add their input to errors if not valid
        errors.add((isVenueValid(venue_id)) ? null : "venue");
        errors.add((isDescriptionValid(description)) ? null : "description");
        errors.add((isOffenderValid(offender_id)) ? null : "offender");

        while (errors.remove(null));
        return errors;

    }

    public boolean isDescriptionValid(String description) {
        return (description.length() < 1000);
    }

    private boolean isVenueValid(String venue_id) {
        Venue venue = null;
        if(isInt(venue_id)){
            try {
                venue = manager.getVenue(Integer.parseInt(venue_id));
                System.out.println("Yep validating venue");
            } catch (SQLException ex) {
                Logger.getLogger(WarningValidator.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return (venue != null);
    }

    private boolean isOffenderValid(String offender_id) {
        Offender offender = null;
        if(isInt(offender_id)){
            try {
                offender = manager.getOffender(Integer.parseInt(offender_id));
                                System.out.println("Yep validating offender");

            } catch (SQLException ex) {
                Logger.getLogger(WarningValidator.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return (offender != null);    }


    public boolean isInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isFloat(String input) {
        try {
            Float.parseFloat(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }



}
