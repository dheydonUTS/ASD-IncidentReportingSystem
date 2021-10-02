/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author adam
 */
public class Offender implements Serializable{
    private String id;
    private String firstName;
    private String surname;
    private String email;
    private String phone;
    private String gender;
    private boolean isBanned;
    private LinkedList<Incident> incidents;
    
    public Offender(String firstName, String surname, String gender, LinkedList<Incident> incidents){
        this.firstName = firstName;
        this.surname = surname;
        this.gender = gender;
        this.incidents = incidents;
        this.id = "1000001";
    }
    
    public Offender(String id, String firstName, String surname, String gender){
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.gender = gender;
    }
    
     public Offender(String id, String firstName, String surname, String gender, String email, String phone, Boolean isBanned){
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.isBanned = isBanned;
    }

    public Offender() {
    }

    public boolean isIsBanned() {
        return isBanned;
    }

    public void setIsBanned(boolean isBanned) {
        this.isBanned = isBanned;
    }
    
    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    
    public String getID(){
        return this.id;
    }
    public void setID(String id){
        this.id = id;
    }
    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getSurname(){
        return this.surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }
    public String getGender(){
        return this.gender;
    }

    public void setGender(String gender){
        this.firstName = gender;
    }
    public LinkedList<Incident> getIncidents(String id){
        return this.incidents;
    }
    
    
}
