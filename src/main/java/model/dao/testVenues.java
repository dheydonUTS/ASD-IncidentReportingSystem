/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import static java.lang.System.in;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import model.Offender;

/**
 *
 * @author dom_h
 */
public class testVenues {
    private DBConnector connector;
    private Connection conn;
    private DBManager manager;
            
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        new testVenues().options();
    }
        public testVenues() throws ClassNotFoundException, SQLException {
        connector = new DBConnector();
        conn = connector.connection();
        manager = new DBManager(conn);
    }

    public static Scanner scanner = new Scanner(System.in);
    
    private void options() throws SQLException{
        char c;
        help();
        while((c=readChar("Command [c/r/u/d/g/o/x]")) != 'x'){
            switch(c){
                //case 'c': testAdd();break;
                case 'r': testRead(); break;
                case 'u': testUpdate(); break;
                case 'd': testDelete();break;
             //  case 'g': testGetAll();break;*/
                default: help(); break;
            }
        }
    }
        private String read(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }
        private char readChar(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine().charAt(0);
    }
        
        private void help(){
        System.out.println("Database Operations: \n"
                + "c = Create User \n"
                + "r = Read User by ID-Password \n"
                + "u = Update User by ID \n"
                + "d = Delete User by ID\n"
                + "g = Get all Users\n"
                + "o = cancel all Users orders\n");
    }
/*private void testAdd() throws SQLException{
    int venueId = 1;
    String type = "test";
    String desc = "test";
    int rptr = 1;
    int ofndr = 1;
    int ausr = 1;
    int prio = 1;
    manager.addIncident(venueId,type , LocalDate.now(), LocalTime.now(), desc, rptr, ofndr, ausr, LocalDateTime.now(), prio);
    }
    
    private void testRead() throws SQLException{
        String email = read("Email");
        String password = read("Password");
        User user = manager.readUser(email,password);
        if(user != null){
        System.out.println("User with email: '" +email + "' and password: '" +password +"' exists.");
        }
        else{System.out.println("User with email: '" +email + "' and password: '" +password +"' does not exist.");}
    }
    
    private void testUpdate() throws SQLException{
    String email = read("Email");
    String password = read("Password");
    String title = read("Title");
    String first_name = read("First Name");
    String last_name = read("Last Name");
    String phone = read("Phone Number");
    boolean is_active = Boolean.parseBoolean(read("Active Status (true/false)"));
    char user_role = readChar("Role(c/s/n/a)");
    manager.updateUser(title, first_name, last_name, phone, email, password, is_active, user_role);
    System.out.println("User updated");
    }
    
    private void testDelete() throws SQLException{
    String email = read("Email");
    manager.deleteUser(email);
    System.out.println("User deleted");
    }
   
    private void testGetAll() throws SQLException{
    LinkedList<Offender> offenders = manager.getOffenders();
    System.out.println("Offender Table:");
        for(Offender o: offenders ){
           System.out.printf("%-20s %-30s %-30s %-20s %-30s %-20s %-20s \n", o.getId(), o.getFirstName(), o.getLastName(), o.getEmail(), o.getPhone(), o.getGender(), o.isIsBanned());
        }
    }
    
    */  
        
        private void testDelete() throws SQLException{
    Integer venueID = Integer.parseInt(read("venue id"));
    manager.deleteVenue(venueID);
    System.out.println("User deleted");
    }
        
        private void testUpdate() throws SQLException {
            Integer venueID = Integer.parseInt(read("venue id"));
            if (manager.checkVenue(venueID)) {
            String venueName = read("venue name");
            String address = read("address");
            double venueLat = Double.parseDouble(read("venue lat"));
            double venueLon = Double.parseDouble(read("venue lon"));
            
            manager.updateVenue(venueID, venueName, address, venueLat, venueLon);
            System.out.print("Update was successful");
            } else {
                System.out.print("unsuccessfyl bro");
            }
        }
        
        private void testRead() throws SQLException {
            Integer venueID = Integer.parseInt(read("Venue ID:"));
            manager.findVenue(venueID);
            System.out.print("It worked");
        }
    private int readInt(String prompt) {
        System.out.print(prompt + ": ");
        return Integer.parseInt(scanner.nextLine());
    }
}
