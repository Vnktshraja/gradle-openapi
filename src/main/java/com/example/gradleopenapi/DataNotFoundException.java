package com.example.gradleopenapi;

public class DataNotFoundException extends RuntimeException{

    public DataNotFoundException(String msg) {
        super(msg);
    }
}
