/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author joeda
 */
public class DummyIncident {
    private int id;
    private DummyVenue venue;
    private String type;
    private Date date;
    private String description;
    private String reporter;
    private String offender;

    public DummyIncident(DummyVenue venue, String type, Date date, String description, String reporter, String offender) {
        this.venue = venue;
        this.type = type;
        this.date = date;
        this.description = description;
        this.reporter = reporter;
        this.offender = offender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DummyVenue getVenue() {
        return venue;
    }

    public void setVenue(DummyVenue venue) {
        this.venue = venue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
