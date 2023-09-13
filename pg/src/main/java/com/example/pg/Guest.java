package com.example.pg;

import java.util.HashMap;
import java.util.List;

public class Guest extends Person implements GuestInerface, InstrumentInterface {

    private final String name;
    private final String dob;
    private final String adhaarNo;
    private final String phNo;
    private final String email;
    private final String profession;

    public Guest(String name, String dob, String adhaarNo, String phNo, String email, String profession) {
        super(name, dob, adhaarNo, phNo, email);
        this.name = name;
        this.dob = dob;
        this.adhaarNo = adhaarNo;
        this.phNo = phNo;
        this.email = email;
        this.profession = profession;
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

    public String getProfession() {
        return String.valueOf(profession);
    }

    @Override
    public boolean payFee(HashMap<Person,Integer> account,Person person, int amount){
        if(person instanceof Owner){
            if(account.get(person) > -1){
                Integer money = account.get(person);
                account.put(person, money + amount);
                return true;
            }
        }
        return false;
    }

    public boolean askRepair(List<Instrument> repairList,Instrument instrument){
        repairList.add(instrument);
        return true;
    }
/*
    @Override
    public void askExchageRoom(int roomNo) {
        // TODO Auto-generated method stub

    }
 * 
 */
 
}
