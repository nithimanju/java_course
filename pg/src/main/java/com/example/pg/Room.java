package com.example.pg;

public abstract class Room {
    private final int floorNo;
    private final int roomNo;
    private final int windowNo;

    Room(int floorNo, int roomNo, int windowNo){
        this.floorNo = floorNo;
        this.roomNo = roomNo;
        this.windowNo = windowNo;
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
}
