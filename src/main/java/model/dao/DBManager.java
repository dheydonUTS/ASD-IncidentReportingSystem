/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import model.Incident;

/**
 *
 * @author vince
 */
public class DBManager {
    private final Statement st;
    
    public DBManager(Connection con) throws SQLException{
        st = con.createStatement(); //Execute statements in the connected database via object con
    }
    
    /*-----------------Incident Reporting-----------------*/
    
    //Read all incidents from Incident table in Database
    public LinkedList<Incident> getIncidentList(){
        return null;
    }
}
