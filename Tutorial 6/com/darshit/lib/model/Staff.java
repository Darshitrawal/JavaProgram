package com.darshit.lib.model;

import java.util.*;

public class Staff extends User{
  public String designation;
  public int bookLimit = 6;
  public Staff(int id, String name, String branch, String designation){
    super(name, branch, id);
    this.designation = designation;
  }
}
