package com.darshit.lib.controller;

public class InsufficientBalanceException extends Exception{
  String msg = "";
  public InsufficientBalanceException(String msg){
    this.msg = msg;
  }
  public String getMessage(){
    return msg;
  }
  public String toString(){
    return "com.darshit.lib.controller.InsufficientBalanceException:" +msg;
  }
}
