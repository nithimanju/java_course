package com.example.pg;

import java.util.List;

public class Technician extends Person {

    public Technician(String name, String dob, String adhaarNo, String phNo, String email) {
        super(name, dob, adhaarNo, phNo, email);
    }

    public boolean repair(List<Instrument> repairInstrument, Instrument instrument){
        int index = repairInstrument.indexOf(instrument);
        if(index > -1){
            repairInstrument.remove(index);
            return true;
        }
        return false;
    }
    
}
