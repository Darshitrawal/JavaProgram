package com.darshit.lib.controller;

public class BookNotAvailableException extends Exception{
  String msg = "";
  BookNotAvailableException(String msg){
    this.msg = msg;
  }
  public String getMessage(){
    return msg;
  }
  public String toString(){
    return "com.darshit.lib.controller.BookNotAvailableException:" +msg;
  }
}
