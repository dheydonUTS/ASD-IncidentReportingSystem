package model.dao;

/**
 *
 * @author joe
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.User;
import java.util.Date;
import java.util.LinkedList;

public class DBManager {

    private DBConnector db;
    private Connection con;
    private Statement st;
    private PreparedStatement stmtInsert;

    public DBManager() throws SQLException {
        try {
            db = new DBConnector();
            con = db.connection();
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public DBManager(Connection con) throws SQLException {
        st = con.createStatement();         // To allow statements to be sent to database accessible via connection conn
    }

    /*
        Offenders
     */
    public void addOffender(String first_name, String last_name, String email, int phone, Boolean is_banned) throws SQLException {
        st.executeUpdate("INSERT INTO \"Offender\" (first_name, last_name,"
                + "email, phone, is_banned)"
                + "VALUES('" + first_name + "','" + last_name + "','" + email + "',"
                + phone + "," + is_banned + ")");
    }

    public void getOffenders() throws SQLException {

    }

}
