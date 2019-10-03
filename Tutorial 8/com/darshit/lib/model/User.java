package com.darshit.lib.model;

import java.util.*;

public class User{
  public String name, branch;
  public int id;
  public ArrayList<HardMedia> issuedBooks = new ArrayList<HardMedia>();

  User(String name, String branch, int id){
    this.name = name;
    this.branch = branch;
    this.id = id;
  }
}
