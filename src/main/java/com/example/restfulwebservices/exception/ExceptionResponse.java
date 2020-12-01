package com.example.restfulwebservices.exception;

import java.time.Instant;

public class ExceptionResponse {
    private  Instant timestamp;
    private String message;
    private String details;
    public ExceptionResponse(Instant timestamp, String message, String details) {
        this.timestamp=timestamp;
        this.message=message;
        this.details =details;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
