/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author adam
 */
public class Offender {
    private String id;
    private String firstName;
    private String surname;
    private String gender;
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
