package com.example.pg;

import java.util.HashMap;
import java.util.List;

public class Owner extends Person implements OwnerInterface, InstrumentInterface{

    private final String name;
    private final String dob;
    private final String adhaarNo;
    private final String phNo;
    private final String email;
    
    
    public Owner(String name, String dob, String adhaarNo, String phNo, String email) {
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

    public boolean allocateRoom(Person person, Room room){
        
        if(room instanceof TwoShare){
            if(((TwoShare) room).addPerson(person)){
                return true;
            }
        }
        if(room instanceof KitchenRoom){
            if(((KitchenRoom)room).addPerson(person)){
                return true;
            }
        }
        return false;

    }

    public boolean deallocateRoom(Person person, Room room) {
        if(room instanceof TwoShare){
            if(((TwoShare)room).removePerson(person)){
                return true;
            }
        }
        if(room instanceof KitchenRoom){
            if(((KitchenRoom)room).removePerson(person)){
                return true;
            }
        }
        return false;
    }

    public void checkRoom(Room room){
        
        if(room instanceof TwoShare){
            System.out.println(((TwoShare)room).getPerson());
        }else if(room instanceof KitchenRoom){
            System.out.println(((KitchenRoom)room).getPerson()+"\n"+((KitchenRoom)room).getInstrument());
        }else{
            System.out.println(((Washroom)room).getInstrument());
        }
    }
    public boolean payPerson(HashMap<Person,Integer> account, Person p , Integer money){
        
        if(account.get(p) != null){
            Integer mon = account.get(p);
            account.put( p, mon + money);
            return true;
        }
        return false;
    }

}
