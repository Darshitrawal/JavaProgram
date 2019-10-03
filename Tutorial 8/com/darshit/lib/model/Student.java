package com.darshit.lib.model;

import java.util.*;

public class Student extends User{
  public int sem, bookLimit;
  public int enroll;

  public Student(int id, int enroll, String name, String branch, int sem, int bookLimit){
    super(name, branch, id);
    this.sem = sem;
    this.enroll = enroll;
    this.bookLimit = bookLimit;
  }

  public String toString(){
    return this.id+","
           +this.enroll+","
           +this.name+","
           +this.branch+","
           +this.sem+","
           +this.bookLimit+";";
  }
}
