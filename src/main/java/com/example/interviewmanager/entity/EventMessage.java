package com.example.interviewmanager.entity;

/**
 * Eventbus
 */
public class EventMessage {
     private String message;

    public EventMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
