package com.darshit.lib.model;

public class HardMedia extends Media{
  public int pgNo, mediaCount;
  public String publication;
  public HardMedia(int id, String publication, String title, int pgNo, String location, int mediaCount, String authorName){
    super(title, id, location, authorName);
    this.pgNo = pgNo;
    this.publication = publication;
    this.mediaCount = mediaCount;
  }

  public String toString(){
    return this.id + "," +
           this.publication + "," +
           this.title + "," +
           this.pgNo + "," +
           this.location + "," +
           this.mediaCount + "," +
           this.authorName + ";" ;
  }
}
