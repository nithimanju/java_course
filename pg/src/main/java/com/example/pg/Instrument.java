package com.example.pg;

public record Instrument(String type, String brand, String color, 
        String size, float price, String floorNo, String roomNo) {
    public void work(){
        System.out.println("I am Working");
    }
}
