package com.darshit.lib.model;

public class Media{
  public String title, location, authorName;
  public int id;
  Media(String title, int id, String location,  String authorName){
    this.title = title;
    this.id = id;
    this.authorName = authorName;
    this.location = location;
  }
}
