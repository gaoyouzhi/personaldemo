package com.ikang.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Message implements Serializable {

    public static final Integer HELLO = 0;
    public static final Integer GOODBYE = 1;
    private static final long serialVersionUID = -3220042820450541635L;

    private String message;

    private Integer status;

    public Message() {
    }

    public Message(String message, Integer status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
