package com.example.pg;
public abstract class Person {
    
    private final String name;
    private final String dob;
    private final String adhaarNo;
    private final String phNo;
    private final String email;
    
    public Person(String name, String dob, String adhaarNo, String phNo, String email) {
        this.name = name;
        this.dob = dob;
        this.adhaarNo = adhaarNo;
        this.phNo = phNo;
        this.email = email;
    }

    
}
