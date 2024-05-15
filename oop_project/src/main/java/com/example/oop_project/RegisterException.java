package com.example.oop_project;

public class RegisterException  extends  Exception{

    String message;

    public RegisterException(String message) {
        this.message = message;
    }
}
