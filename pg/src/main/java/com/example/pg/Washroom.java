package com.example.pg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Washroom extends Room {

    private List<Instrument> instrumentList = new ArrayList<Instrument>();
    private final int floorNo;
    private final int roomNo;

    public Washroom(List<Person> personList, List<Instrument> instrumentList){
        this(instrumentList, 5, 4);
    }

    public Washroom(List<Instrument> instrumentList, int floorNo, int roomNo){
        this.instrumentList = instrumentList;
        this.floorNo = floorNo;
        this.roomNo = roomNo;
    }

    public void addInstrument(Instrument instrument){
        if(instrument instanceof Instrument){
            instrumentList.add(instrument);
        }
    }

    public List<Instrument> getInstrument(){
        return Collections.unmodifiableList(instrumentList);
    }
}
