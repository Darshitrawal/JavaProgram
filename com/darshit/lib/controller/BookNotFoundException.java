package com.darshit.lib.controller;

public class BookNotFoundException extends Exception{
  String msg = "";
  BookNotFoundException(String msg){
    this.msg = msg;
  }
  public String getMessage(){
    return msg;
  }
  public String toString(){
    return "com.darshit.lib.controller.BookNotFoundException:" +msg;
  }
}
