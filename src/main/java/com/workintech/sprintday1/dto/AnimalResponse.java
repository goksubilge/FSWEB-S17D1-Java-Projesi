package com.workintech.sprintday1.dto;

public class AnimalResponse {
    private String name;
    private String message;
    private int status;

    public AnimalResponse(String name, String message, int status) {
        this.name = name;
        this.message = message;
        this.status = status;
    }
    public String getName() {return name;}
    public String getMessage() {return message;}
    public int getStatus() {return status;}
}
