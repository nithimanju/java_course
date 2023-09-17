package com.example.pg.person;

import java.util.HashMap;

public interface GuestInerface {
    public String profession;

    //public void askExchageRoom(int roomNo);
    public boolean payFee(HashMap<Person,Integer> account,Person person, int amount);

}
