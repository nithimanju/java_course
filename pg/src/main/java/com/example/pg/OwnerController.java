package com.example.pg;

import java.util.Arrays;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
  public String processAddRoom(@ModelAttribute RoomOBJ roomobj, Model model){
    int roomNo = roomobj.getRoomNo();
    int floorNo = roomobj.getRoomNo();
    int windowNo = roomobj.getWindowNo();
    System.out.println(roomNo+" "+floorNo+" "+windowNo);
    return "";
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
