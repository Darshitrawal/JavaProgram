package com.darshit.lib.controller;

public class UserNotFoundException extends Exception{
  String msg = "";
  public  UserNotFoundException(String msg){
    this.msg = msg;
  }
  public String getMessage(){
    return msg;
  }
  public String toString(){
    return "com.darshit.lib.controller.UserNotAvailableException:" +msg;
  }
}
