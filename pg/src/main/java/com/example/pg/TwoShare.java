package com.example.pg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoShare extends Room {

    private List<Person> personList = new ArrayList<Person>(2);
    private Washroom washroom;
    private boolean hasAC;
    private final int floorNo;
    private final int roomNo;
    private final int windowNo;

    public TwoShare(List<Person> personList){
        this(personList, 5, 4, 2);
    }

    public TwoShare(List<Person> personList, int floorNo, int roomNo, int windowNo){
        super(floorNo, roomNo, windowNo);
        this.personList = personList;
        this.floorNo = floorNo;
        this.roomNo = roomNo;
        this.windowNo = windowNo;
        this.hasAC = true;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public Washroom getWashroom() {
        return washroom;
    }

    public boolean isHasAC() {
        return hasAC;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public int getWindowNo() {
        return windowNo;
    }

    public boolean addPerson(Person p){
        if(p instanceof GuestInerface){
            personList.add(p);
            return true;
        }
        return false;
    }

    public boolean removePerson(Person p){
        if(p instanceof GuestInerface){
            int index = personList.indexOf(p);
            if( index > -1 ){
                personList.remove(index);
                return true;
            }
            return false;
        }
        return false;
    }

    public List<Person> getPerson(){
        return Collections.unmodifiableList(personList);
    }
}
