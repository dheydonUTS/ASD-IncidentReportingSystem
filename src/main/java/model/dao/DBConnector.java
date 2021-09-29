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

public class DBConnector extends DB{
    public DBConnector() throws ClassNotFoundException, SQLException{
        Class.forName(driver);
        super.con = DriverManager.getConnection(url + db, dbuser, dbpass);
    }
    
    public Connection connection(){
        return this.con;
    }
    
    public void closeConnection() throws SQLException{
        this.con.close();
    }
}
