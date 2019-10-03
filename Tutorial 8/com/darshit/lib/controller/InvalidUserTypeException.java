package com.darshit.lib.controller;

public class InvalidUserTypeException extends Exception{
  String msg;
  public InvalidUserTypeException(String msg){
      this.msg = msg;
  }
  public String getMessage(){
    return msg;
  }
  public String toString(){
    return "com.darshit.lib.controller.InvalidUserTypeException:" +msg;
  }
}
