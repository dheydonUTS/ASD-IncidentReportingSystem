package model.dao;

/**
 *
 * @author joe
 */
import java.sql.*;

public abstract class DB {
    protected String url="jdbc:derby://localhost:1527/";
    protected String db = "incidentrs";
    protected String dbuser = "incidentrs";
    protected String dbpass = "password123";
    protected String driver = "org.apache.derby.jdbc.ClientDriver";
    protected Connection con;
}
