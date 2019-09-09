package com.darshit.lib.model;

public class HardMedia extends Media{
  public int pgNo, mediaCount;
  public String publication;
  HardMedia(int id, String publication, String title, int pgNo, String location, int mediaCount, String authorName){
    super(title, id, location, authorName);
    this.pgNo = pgNo;
    this.publication = publication;
    this.mediaCount = mediaCount;
  }
}
