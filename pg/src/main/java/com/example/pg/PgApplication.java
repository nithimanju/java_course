package com.example.pg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.pg.instrument.Instrument;
import com.example.pg.person.Owner;
import com.example.pg.person.Person;
import com.example.pg.room.KitchenRoom;
import com.example.pg.room.Room;
import com.example.pg.room.TwoShare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class PgApplication {
	public static List<Instrument> instrumentList = new ArrayList<Instrument>();
	private static List<Room> roomList = new ArrayList<Room>();
    public static Map<Person,Integer> accountMap = new HashMap<Person, Integer>();
	public static List<Instrument> repairList = new ArrayList<Instrument>();
	private static List<Person> personList = new ArrayList<Person>();
	private static Owner own;
	public static void main(String[] args) {
		SpringApplication.run(PgApplication.class, args);	
	}

	public static Instrument getInstrument(String floorNo, String roomNo, String type){
		List<Instrument> it = instrumentList.stream()
				.filter(s -> (s.floorNo() == floorNo && s.roomNo() == roomNo && s.type() == type))
				.collect(Collectors.toList());
		return it.get(0);
	}

	public static boolean addRoom(List<Person> personList, List<Instrument> instrumentList, int floorNo, int roomNo, int windowNo){
		if(roomList.add(new KitchenRoom(personList, instrumentList, floorNo, roomNo, windowNo))){
			return true;
		}
		return false;
	}

	public static boolean addRoom(List<Person> personList, int floorNo, int roomNo, int windowNo){
		if(roomList.add(new TwoShare(personList, floorNo, roomNo, windowNo))){
			return true;
		}
		return false;
	}

	public static Room getRoom(int floorNo, int roomNo){
		List<Room> it = roomList.stream()
				.filter(s -> (s.getFloorNo() == floorNo && s.getRoomNo() == roomNo))
				.collect(Collectors.toList());
		return it.get(0);		
	}

	public static ArrayList<Room> getRoomList() {
		return (ArrayList<Room>)roomList;
	}

	public static List<Room> printRoom(){
		System.out.println(roomList);
		return roomList;
	}
	public static void allocateRoom(int floorNo, int roomNo, Person person){
		Room room = getRoom(floorNo, roomNo); 
		own.allocateRoom(person, room);
	}

	public static void addOwner(){
		own = new Owner("Venkatesh Anna", "01/01/01", "123456789",
					 "987654321", "venkateshanna@venkatasaipg.com");
	}

	public static Owner getOwner(){
		return own;
	}

	public static List<Person> getPersonList() {
		return personList;
	}

	public static void setPersonList(Person p) {
		personList.add(p);
	}

}
