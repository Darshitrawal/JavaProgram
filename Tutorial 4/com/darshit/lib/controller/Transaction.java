package com.darshit.lib.controller;

import com.darshit.lib.model.*;
import java.util.*;

public class Transaction{

  String msg = "";
  boolean flag = false;
  boolean status = false;
  int i , j, k, balance;

  public String issueBook(int userFoundIndex, int bookFoundIndex, String userType)
    throws InsufficientBalanceException, BookNotAvailableException{
    if(userType.equals("student")){
      if(DAO.students[userFoundIndex].bookLimit < 1){
        msg = "Insufficient Balance to issue book!";
        throw new InsufficientBalanceException(msg);
      }else if(DAO.hardMedia[bookFoundIndex].mediaCount < 1){
        msg = "Book not available!";
        throw new BookNotAvailableException(msg);
      }else{
        DAO.students[userFoundIndex].bookLimit--;
        DAO.hardMedia[bookFoundIndex].mediaCount--;
        msg = "Book Issued Successfully";
      }
    }else if(userType.equals("staff")){
      if(DAO.staffs[userFoundIndex].bookLimit < 1){
        msg = "Insufficient Balance to issue book!";
        throw new InsufficientBalanceException(msg);
      }else if(DAO.hardMedia[bookFoundIndex].mediaCount < 1){
        msg = "Book not available!";
        throw new BookNotAvailableException(msg);
      }else{
        DAO.staffs[userFoundIndex].bookLimit--;
        DAO.hardMedia[bookFoundIndex].mediaCount--;
        msg = "Book Issued Successfully";
      }
    }
    return msg;
  }

  public String returnBook(int userFoundIndex, int bookFoundIndex, String userType)
  throws InsufficientBalanceException{
    if(userType.equals("student")){
      if(DAO.students[userFoundIndex].bookLimit > 4){
        msg = "you didn't Issued any book!";
        throw new InsufficientBalanceException(msg);
      }else{
        DAO.students[userFoundIndex].bookLimit++;
        DAO.hardMedia[bookFoundIndex].mediaCount++;
        msg = "Book Returned Successfully";
      }
    }else if(userType.equals("staff")){
      if(DAO.staffs[userFoundIndex].bookLimit > 4){
        msg = "you didn't Issued any book!";
        throw new InsufficientBalanceException(msg);
      }else{
        DAO.staffs[userFoundIndex].bookLimit++;
        DAO.hardMedia[bookFoundIndex].mediaCount++;
        msg = "Book Returned Successfully";
      }
    }
    return msg;
  }

  public int checkBalance(int userFoundIndex, String userType){
    if(userType.equals("student")){
      balance = DAO.students[userFoundIndex].bookLimit;
    }else if(userType.equals("staff")){
      balance = DAO.staffs[userFoundIndex].bookLimit;
    }
    return balance;
  }

  // Overloaded
  public String checkBookAvailability(String bookTitle)
  throws BookNotFoundException{
    for(i = 0; i < DAO.hardMedia.length; i++){
      if(bookTitle.equals(DAO.hardMedia[i].title)){
        msg = DAO.hardMedia[i].location;
        break;
      }
    }
    if(i == DAO.hardMedia.length){
      msg = "Book not Found!";
      throw new BookNotFoundException(msg);
    }
    return msg;
  }

  public int checkUserAvailability(int userId, String userType)
  throws UserNotFoundException{
    if(userType.equals("student")){
      for(i = 0; i <= DAO.students.length; i++){
        if(DAO.students[i].id == userId){
          break;
        }
        if(i == DAO.students.length){
          msg = "Invalid user or book Id";
          i = -1;
          throw new UserNotFoundException(msg);
        }
      }
    }else if(userType.equals("staff")){
      for(i = 0; i < DAO.staffs.length; i++){
        if(DAO.staffs[i].id == userId){
          break;
        }
        if(i == DAO.staffs.length){
          msg = "Invalid user or book Id";
          i = -1;
          throw new UserNotFoundException(msg);
        }
      }
    }
    return i;
  }

  public int checkBookAvailability(int bookId)
  throws BookNotFoundException{
    for(j = 0; j < DAO.hardMedia.length; j++){
      if(DAO.hardMedia[j].id == bookId){
        break;
      }
      if(j == DAO.hardMedia.length){
        msg = "Invalid user or book Id";
        j = -1;
        throw new BookNotFoundException(msg);
      }
    }
    return j;
  }

  public boolean checkUserType(String userType){
    status = false;
    if(userType.equals("student") || userType.equals("staff")){
      status = true;
    }else{
      status = false;
    }
    return status;
  }

}
