/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import model.Offender;

/**
 *
 * @author dom_h
 */
public class Incident implements Serializable {
    private int id;
    private Venue venue;
    private String type;
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String reporter;
    private String offender;

    public Incident(Venue venue, String type, LocalDate date, LocalTime time, String description, String reporter, String offender) {
        this.venue = venue;
        this.type = type;
        this.date = date;
        this.time = time;
        this.description = description;
        this.reporter = reporter;
        this.offender = offender;
    }
    
    public Incident(String type, String description, String reporter, String offender){
        this.type = type;
        this.description = description;
        this.reporter = reporter;
        this.offender = offender;
    }

    public Incident() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getOffender() {
        return offender;
    }

    public void setOffender(String offender) {
        this.offender = offender;
    }
    
    
}
