/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.SQLException;
import model.Incident;
import model.dao.DBConnector;
import model.dao.DBManager;

/**
 *
 * @author vince
 */
public class TestIncidentReports {
    private DBConnector connector;
    private Connection conn;
    private DBManager manager;

    public TestIncidentReports() throws ClassNotFoundException, SQLException {
        connector = new DBConnector();
        conn = connector.connection();
        manager = new DBManager(conn);
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println(new TestIncidentReports().testGetIncident(1).toString());
    }
    
    public Incident testGetIncident(int id) throws SQLException{
        return manager.getIncident(id);
    }
}
