package com.gov.covid.controlevacina.exception;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidationExceptionDetails {
    private String  title;
    private int status;
    private String details;
    private String developerMessage;
    private LocalDateTime timestamp;
    private String fields;
    private  String fieldsMessage;

    public ValidationExceptionDetails() {
    }

    public ValidationExceptionDetails(String title, int status, String details, String developerMessage, LocalDateTime timestamp, String fields, String fieldsMessage) {
        this.title = title;
        this.status = status;
        this.details = details;
        this.developerMessage = developerMessage;
        this.timestamp = timestamp;
        this.fields = fields;
        this.fieldsMessage = fieldsMessage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public String getFieldsMessage() {
        return fieldsMessage;
    }

    public void setFieldsMessage(String fieldsMessage) {
        this.fieldsMessage = fieldsMessage;
    }
}
