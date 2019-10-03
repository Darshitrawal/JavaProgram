package com.darshit.lib.model;

public class SoftMedia extends Media{
  public String size;
  public SoftMedia(int id, String title, String size, String location, String authorName){
    super(title, id, location, authorName);
    this.size = size;
  }
}
