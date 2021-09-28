/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.LinkedList;

/**
 *
 * @author dom_h
 */
public class Venue {
    private int id;
    private String name;
    private double lat;
    private double lon;
    private String suburb;
    private String address;
    private LinkedList<Incident> incidents;

    public Venue(int id, String name, double lat, double lon) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }

    public Venue(int id, String name, double lat, double lon, String address) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.address = address;
    }
    
    public Venue(int id, String name, String suburb, String address, LinkedList<Incident> incidents) {
        this.id = id;
        this.name = name;
        this.suburb = suburb;
        this.address = address;
        this.incidents = incidents;
    }
    
    public Venue(int id, String name, String suburb, String address) {
        this.id = id;
        this.name = name;
        this.suburb = suburb;
        this.address = address;
    }


    @Override
    public String toString() {
        return "Venue{" + "name=" + name + '}';
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }


    public void setSuburb(String suburb){
        this.suburb = suburb;
    }
    public String getSuburb(){
        return suburb;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getAddress(){
        return address;
    }
    public LinkedList<Incident> getIncidents() {
        return incidents;
    }
    public void setIncidents(LinkedList<Incident> incidents) {
        this.incidents = incidents;
    }
}



