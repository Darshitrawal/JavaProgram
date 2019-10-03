package com.darshit.lib.model;

import java.util.*;

public class Staff extends User{
  public String designation;
  public int bookLimit = 6;
  public Staff(int id, String name, String branch, String designation, int bookLimit){
    super(name, branch, id);
    this.designation = designation;
  }

  public String toString(){
    return this.id + "," +
           this.name + "," +
           this.branch + "," +
           this.designation + "," +
           this.bookLimit + ";" ;
  }
}
