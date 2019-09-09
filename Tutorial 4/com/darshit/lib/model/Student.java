package com.darshit.lib.model;

public class Student extends User{
  public int sem, bookLimit = 4;
  public int enroll;
  Student(int id, int enroll, String name, String branch, int sem){
    super(name, branch, id);
    this.sem = sem;
    this.enroll = enroll;
  }
}
