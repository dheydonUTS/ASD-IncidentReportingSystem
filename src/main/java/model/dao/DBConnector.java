package model.dao;

import java.sql.*;

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