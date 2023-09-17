package com.example.pg.room;

import lombok.Getter;

@Getter
public abstract class Room {
    private final int floorNo;
    private final int roomNo;
    private final int windowNo;

    Room(int floorNo, int roomNo, int windowNo){
        this.floorNo = floorNo;
        this.roomNo = roomNo;
        this.windowNo = windowNo;
    }
  
}
