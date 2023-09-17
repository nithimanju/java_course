package com.example.pg.person;

import java.util.HashMap;
import java.util.List;

import com.example.pg.instrument.Instrument;
import com.example.pg.instrument.InstrumentInterface;

import lombok.Getter;

@Getter
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
