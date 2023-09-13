package com.example.pg;

import java.util.List;
//hi how are you
public class Cheif extends Person implements ChefInterface, InstrumentInterface {

    private final String name;
    private final String dob;
    private final String adhaarNo;
    private final String phNo;
    private final String email;
    
    public Cheif(String name, String dob, String adhaarNo, String phNo, String email) {
        super(name, dob, adhaarNo, phNo, email);
        this.name = name;
        this.dob = dob;
        this.adhaarNo = adhaarNo;
        this.phNo = phNo;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getAdhaarNo() {
        return adhaarNo;
    }

    public String getPhNo() {
        return phNo;
    }

    public String getEmail() {
        return email;
    }

    public boolean askRepair(List<Instrument> repairList,Instrument instrument){
        repairList.add(instrument);
        return true;
    }   
    
    public void cook(){
        System.out.println("I am cooking Pizza");
    }
    public void wash(){
        System.out.println("I am washing pan");
    }
    public void serve(){
        System.out.println("I am serving VEG");
    }
    
}
