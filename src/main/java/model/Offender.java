/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author adam
 */
public class Offender {
    private String id;
    private String firstName;
    private String surname;
    private String gender;
    private Incident[] incidents;
    
    public Offender(String firstName, String surname, String gender, Incident[] incidents){
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
    public void setFirstName(String firstNameT){
        this.firstName = firstNameT;
    }
    public String getSurname(){
        return this.surname;
    }
    public void setSurname(String surnameT){
        this.surname = surnameT;
    }
    public String getGender(){
        return this.gender;
    }
    public void setGender(String genderT){
        this.firstName = genderT;
    }
    public Incident[] getIncidents(String id){
        return this.incidents;
    }
    
    
}
