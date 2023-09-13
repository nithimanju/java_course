package com.example.pg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KitchenRoom extends Room {

    private List<Person> personList = new ArrayList<Person>();
    private List<Instrument> instrumentList = new ArrayList<Instrument>();
    private final int floorNo;
    private final int roomNo;
    private final int windowNo;

    public KitchenRoom(List<Person> personList, List<Instrument> instrumentList){
        this(personList, instrumentList, 5, 4, 2);
    }

    public KitchenRoom(List<Person> personList, List<Instrument> instrumentList, int floorNo, int roomNo, int windowNo){
        super(floorNo, roomNo, windowNo);
        this.personList = personList;
        this.instrumentList = instrumentList;
        this.floorNo = floorNo;
        this.roomNo = roomNo;
        this.windowNo = windowNo;
    }


    public List<Person> getPersonList() {
        return personList;
    }

    public List<Instrument> getInstrumentList() {
        return instrumentList;
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
        if(p instanceof ChefInterface){
            personList.add(p);
            return true;
        }
        return false;
    }

    public boolean removePerson(Person p){
        if(p instanceof ChefInterface){
            int index = personList.indexOf(p);
            if( index > -1 ){
                personList.remove(index);
                return true;
            }
            return false;
        }
        return false;
    }    

    public void addInstrument(Instrument instrument){
        if(instrument instanceof Instrument){
            instrumentList.add(instrument);
        }
    }

    public List<Person> getPerson(){
        return Collections.unmodifiableList(personList);
    }

    public List<Instrument> getInstrument(){
        return Collections.unmodifiableList(instrumentList);
    }
}
