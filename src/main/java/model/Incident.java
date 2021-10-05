/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private String description;
    private User reporter;
    private Offender offender;
    private LocalDate incidentDate;
    private LocalTime incidentTime;
// Ticketing System Variables
    private User assignedUser; 
    private LocalDateTime createdTime;
    private LocalDateTime closedTime;
    private String status;
    private int priority;

    public Incident(Venue venue, String type,LocalDate date, LocalTime time, String description, User reporter, Offender offender, User assignedUser, LocalDateTime createdTime,  int priority) { //Default constructor
        this.venue = venue;
        this.type = type;
        this.description = description;
        this.reporter = reporter;
        this.offender = offender;
        incidentDate=date;
        incidentTime=time;
        this.assignedUser = assignedUser;
        this.createdTime = createdTime;
        this.status = "open";
        this.priority = priority;
    }

    public Incident() {
    }

    public Incident(int id, Venue venue, String type, String description, User reporter, Offender offender, LocalDate incidentDate, LocalTime incidentTime, User assignedUser, LocalDateTime createdTime, int priority) {
        this.id = id;
        this.venue = venue;
        this.type = type;
        this.description = description;
        this.reporter = reporter;
        this.offender = offender;
        this.incidentDate = incidentDate;
        this.incidentTime = incidentTime;
        this.assignedUser = assignedUser;
        this.createdTime = createdTime;
        this.priority = priority;
        status = "open";
    }

    
    
    public Incident(int id, Venue venue, String type, String description, User reporter, Offender offender, LocalDate incidentDate, LocalTime incidentTime, User assignedUser, LocalDateTime createdTime, LocalDateTime closedTime, int priority) {
        this.id = id;
        this.venue = venue;
        this.type = type;
        this.description = description;
        this.reporter = reporter;
        this.offender = offender;
        this.incidentDate = incidentDate;
        this.incidentTime = incidentTime;
        this.assignedUser = assignedUser;
        this.createdTime = createdTime;
        this.status = "open";
        this.priority = priority;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getReporter() {
        return reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public Offender getOffender() {
        return offender;
    }

    public void setOffender(Offender offender) {
        this.offender = offender;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getClosedTime() {
        return closedTime;
    }

    public void setClosedTime(LocalDateTime closedTime) {
        this.closedTime = closedTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public LocalDate getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(LocalDate incidentDate) {
        this.incidentDate = incidentDate;
    }

    public LocalTime getIncidentTime() {
        return incidentTime;
    }

    public void setIncidentTime(LocalTime incidentTime) {
        this.incidentTime = incidentTime;
    }
    
    

}