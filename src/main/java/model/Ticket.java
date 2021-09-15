/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.*;

/**
 *
 * @author dom_h
 */
public class Ticket implements Serializable{
    private int ticketId;
    private User assignedUser; 
    private Incident incident;
    private LocalTime createdTime;
    private LocalTime closedTime;
    private String status;
    private int priority;

    public Ticket(int ticketId,  Incident incident, LocalTime createdTime) {
        this.ticketId = ticketId;
        this.incident = incident;
        this.createdTime = createdTime;
        this.status = "Open";
        this.priority = 1;
    }

    public Ticket() {
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    public LocalTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalTime getClosedTime() {
        return closedTime;
    }

    public void setClosedTime(LocalTime closedTime) {
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
    
}
