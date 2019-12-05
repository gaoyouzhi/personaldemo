package com.ikang.model;

public class Message {
    public static final int HELLO = 1;
    private int id;
    private String message;
    private int status;

    public Message() {
    }

    public Message(String message, int id) {
        this.id = id;
        this.message = message;
    }

    public Message(int id, String message, int status) {
        this.id = id;
        this.message = message;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
