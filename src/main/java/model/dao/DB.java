/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.*;
/**
 *
 * @author vince
 */
public abstract class DB {
    protected String url="jdbc:derby://localhost:1527/";
    protected String db = "incidentrs";
    protected String dbuser = "incidentrs";
    protected String dbpass = "password123";
    protected String driver = "org.apache.derby.jdbc.ClientDriver";
    protected Connection con;
}
