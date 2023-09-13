package com.example.pg;

import java.util.HashMap;

public interface OwnerInterface {
    public boolean allocateRoom(Person person, Room room);
    public void checkRoom(Room room);
    public boolean payPerson(HashMap<Person,Integer> account, Person p , Integer money);
    public boolean deallocateRoom(Person person, Room room); 
}
