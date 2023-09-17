package com.example.pg.person;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Person {
    
    private final String name;
    private final String dob;
    private final String adhaarNo;
    private final String phNo;
    private final String email;
}
