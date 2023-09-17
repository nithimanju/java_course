package com.example.pg.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.pg.PgApplication;
import com.example.pg.person.Guest;
import com.example.pg.person.Owner;
import com.example.pg.person.Person;
import com.example.pg.person.PersonOBJ;
import com.example.pg.room.Room;
import com.example.pg.room.RoomOBJ;

@Controller
public class OwnerController {
    private Owner owner = null;
    {
        PgApplication.addOwner();
        try{
            owner = PgApplication.getOwner();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

  @GetMapping("/owner")
  public String showLogin(Model model) {

    model.addAttribute("owner", owner);
    return "Owner";
  }

  @GetMapping("/owner/info")
  public String showInfo(Model model) {

    model.addAttribute("owner", owner);
    return "OwnerInfo";
  }

  @GetMapping("/owner/room")
  public String showRoom(Model model){

    model.addAttribute("owner", owner);
    return "OwnerRoom";
  }

  @GetMapping("/owner/room/addRoom")
  public String addRoom(Model model){

    model.addAttribute("RoomOBJ", new RoomOBJ());
    return "OwnerAddRoom";
  }

  @PostMapping("/owner/room/addRoom1")
  public void processAddRoom(@ModelAttribute RoomOBJ roomobj, Model model){
    int roomNo = roomobj.getRoomNo();
    int floorNo = roomobj.getRoomNo();
    int windowNo = roomobj.getWindowNo();
    PgApplication.addRoom(null, floorNo, roomNo, windowNo);
    System.out.println(roomNo+" "+floorNo+" "+windowNo);
    //return "";
  }

  @GetMapping("/owner/addPerson")
  public String addPerson(Model model){
    model.addAttribute("PersonOBJ", new PersonOBJ());
    return "OwnerAddPerson";
  }


  @PostMapping("/owner/addPerson1")
  public String newPerson(@ModelAttribute PersonOBJ personobj, Model model) {
    String name = personobj.getName();
    String dob = personobj.getDob();
    String adhaarNo = personobj.getAdhaarNo();
    String phNo = personobj.getPhNo();
    String email = personobj.getEmail();
    String profession = personobj.getProfession();
    Person p = new Guest(name, dob, adhaarNo, phNo, email, profession);
    PgApplication.setPersonList(p);
    System.out.println(((Guest)p).getAdhaarNo()+" ");
    model.addAttribute("Guest", ((Guest)p));
    return "OwnerShowPerson";
  }

  @GetMapping("/owner/room/allocateRoom")
  public String allocateRoom(Model model){
    model.addAttribute("owner", owner);
    return "OwnerAllocateRoom";
  }

  @GetMapping("/owner/room/deallocateRoom")
  public String deallocateRoom(Model model){
    model.addAttribute("owner", owner);
    return "OwnerDeallocateRoom";    
  }

  @GetMapping("/owner/room/printRoom")
  public String printRoom(Model model){
    ArrayList<Room> roomList = PgApplication.getRoomList();
    model.addAttribute("room", roomList);
    return "OwnerPrintRoom";    
  }

}
