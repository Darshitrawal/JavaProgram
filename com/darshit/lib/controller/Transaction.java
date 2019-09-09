package com.darshit.lib.controller;

import com.darshit.lib.model.*;
public class Transaction{
  String msg = "";
  boolean flag = false;
  int i , j;

  public String issueBook(int userId, int bookId, String userType)
    throws BookNotFoundException, InsufficientBalanceException, BookNotAvailableException, UserNotFoundException, InvalidUserTypeException{
    if(userType.equals("student")){
      for(i=0; i <= DAO.students.length; i++){
        if(DAO.students[i].id == userId){
          break;
        }
        if(i == DAO.students.length){
          msg = "Invalid user or book Id";
          throw new UserNotFoundException(msg);
        }
      }
      for(j = 0; j <= DAO.hardMedia.length; j++){
        if(DAO.hardMedia[j].id == bookId){
          break;
        }
        if(i == DAO.hardMedia.length){
          msg = "Invalid user or book Id";
          throw new BookNotFoundException(msg);
        }
      }
      if(DAO.students[i].bookLimit < 1){
        msg = "Insufficient balance to issue book";
        throw new InsufficientBalanceException(msg);
      }else if(DAO.hardMedia[j].mediaCount < 1){
        msg = "Book is not available";
        throw new BookNotAvailableException(msg);
      }else{
        DAO.students[i].bookLimit--;
        DAO.hardMedia[j].mediaCount--;
        msg = "book issued successfully";
      }
    }else if(userType.equals("staff")){
      for(int i=0; i <= DAO.staffs.length; i++){
        if(DAO.staffs[i].id == userId){
          break;
        }
        if(i == DAO.staffs.length){
          msg = "Invalid user or bookId";
          throw new UserNotFoundException(msg);
        }
      }
      for(j = 0; j <= DAO.hardMedia.length; j++){
        if(DAO.hardMedia[j].id == bookId){
          break;
        }
        if(i == DAO.hardMedia.length){
          msg = "Invalid user or book Id";
          throw new BookNotFoundException(msg);
        }
      }
      if(DAO.staffs[i].bookLimit < 1){
        msg = "Insufficient balance to issue book";
        throw new InsufficientBalanceException(msg);
      }else if(DAO.hardMedia[j].mediaCount < 1){
        msg = "Book is not available";
        throw new BookNotAvailableException(msg);
      }else{
        DAO.staffs[i].bookLimit--;
        DAO.hardMedia[j].mediaCount--;
        msg = "book issued successfully";
      }
    }else{
      msg = "Invalid user type";
      throw new InvalidUserTypeException(msg);
    }
    return msg;
  }

  public String returnBook(int userId, int bookId, String userType)
    throws BookNotFoundException, UserNotFoundException, InvalidUserTypeException{
    if(userType.equals("student")){
      for(i=0; i <= DAO.students.length; i++){
        if(DAO.students[i].id == userId){
          flag = true;
          break;
        }
        if(i == DAO.students.length){
          msg = "Invalid user or book Id";
          throw new UserNotFoundException(msg);
        }
      }
      for(j = 0; j <= DAO.hardMedia.length; j++){
        if(DAO.hardMedia[j].id == bookId){
          flag = true;
          break;
        }
        if(i == DAO.hardMedia.length){
          msg = "Invalid user or book Id";
          throw new BookNotFoundException(msg);
        }
      }
      if(true){
        DAO.students[i].bookLimit++;
        DAO.hardMedia[j].mediaCount++;
        msg = "book returned successfully";
      }
    }else if(userType.equals("staff")){
      for(int i=0; i <= DAO.staffs.length; i++){
        if(DAO.staffs[i].id == userId){
          flag = true;
          break;
        }
        if(i == DAO.staffs.length){
          msg = "Invalid user or bookId";
          throw new UserNotFoundException(msg);
        }
      }
      for(j = 0; j <= DAO.hardMedia.length; j++){
        if(DAO.hardMedia[j].id == bookId){
          flag = true;
          break;
        }
        if(i == DAO.hardMedia.length){
          msg = "Invalid user or book Id";
          throw new BookNotFoundException(msg);
        }
      }
      if(flag){
        DAO.staffs[i].bookLimit++;
        DAO.hardMedia[j].mediaCount++;
        msg = "book returned successfully";
      }
    }else{
      msg = "Invalid user type";
      throw new InvalidUserTypeException(msg);
    }
    return msg;
  }

  public int checkBalance(int userId, String userType)
    throws UserNotFoundException, InvalidUserTypeException{
    if(userType.equals("student")){
      for(i = 0; i <= DAO.students.length; i++){
        if(DAO.students[i].id == userId){
          return DAO.students[i].bookLimit;
        }
        if(i == DAO.students.length){
          msg = "Invalid user Id";
          throw new UserNotFoundException(msg);
        }
      }
    }else if(userType.equals("staff")){
      for(i = 0; i <= DAO.staffs.length; i++){
        if(DAO.staffs[i].id == userId){
          return DAO.staffs[i].bookLimit;
        }
        if(i == DAO.staffs.length){
          msg = "Invalid user Id";
          throw new UserNotFoundException(msg);
        }
      }
    }else{
      msg = "Invalid user type";
      throw new InvalidUserTypeException(msg);
    }
    return -1;
  }

  public String searchBook(String bookTitle)
    throws BookNotFoundException{
    for(i = 0; i <= DAO.hardMedia.length; i++){
      if(DAO.hardMedia[i].title.equals(bookTitle)){
        return DAO.hardMedia[i].location;
      }else{
        msg = "Book not Found!";
        throw new BookNotFoundException(msg);
      }
    }
    return msg;
  }
}
