package com.darshit.lib.controller;

import com.darshit.lib.model.*;
public class Transaction{
  String msg = "";
  int i , j;

  public String issueBook(int userId, int bookId, String userType){
    if(userType.equals("student")){
      for(i=0; i <= DAO.students.length; i++){
        if(DAO.students[i].id == userId){
          break;
        }
        if(i == DAO.students.length){
          msg = "Invalid user or book Id";
          return msg;
        }
      }
      for(j = 0; j <= DAO.hardMedia.length; j++){
        if(DAO.hardMedia[j].id == bookId){
          break;
        }
        if(i == DAO.hardMedia.length){
          msg = "Invalid user or book Id";
          return msg;
        }
      }
      if(DAO.students[i].bookLimit < 1){
        msg = "Insufficient balance to issue book";
        return msg;
      }else if(DAO.hardMedia[j].mediaCount < 1){
        msg = "Book is not available";
        return msg;
      }else{
        DAO.students[i].bookLimit--;
        DAO.hardMedia[j].mediaCount--;
        msg = "book issued successfully";
        return msg;
      }
    }else if(userType.equals("staff")){
      for(int i=0; i <= DAO.staffs.length; i++){
        if(DAO.staffs[i].id == userId){
          break;
        }
        if(i == DAO.staffs.length){
          msg = "Invalid user or bookId";
          return msg;
        }
      }
      for(j = 0; j <= DAO.hardMedia.length; j++){
        if(DAO.hardMedia[j].id == bookId){
          break;
        }
        if(i == DAO.hardMedia.length){
          msg = "Invalid user or book Id";
          return msg;
        }
      }
      if(DAO.staffs[i].bookLimit < 1){
        msg = "Insufficient balance to issue book";
        return msg;
      }else if(DAO.hardMedia[j].mediaCount < 1){
        msg = "Book is not available";
        return msg;
      }else{
        DAO.staffs[i].bookLimit--;
        DAO.hardMedia[j].mediaCount--;
        msg = "book issued successfully";
        return msg;
      }
    }
    return msg;
  }

  public String returnBook(int userId, int bookId, String userType){
    if(userType.equals("student")){
      for(i=0; i <= DAO.students.length; i++){
        if(DAO.students[i].id == userId){
          break;
        }
        if(i == DAO.students.length){
          msg = "Invalid user or book Id";
          return msg;
        }
      }
      for(j = 0; j <= DAO.hardMedia.length; j++){
        if(DAO.hardMedia[j].id == bookId){
          break;
        }
        if(i == DAO.hardMedia.length){
          msg = "Invalid user or book Id";
          return msg;
        }
      }
      DAO.students[i].bookLimit++;
      DAO.hardMedia[j].mediaCount++;
      msg = "book issued successfully";
      return msg;
    }else if(userType.equals("staff")){
      for(int i=0; i <= DAO.staffs.length; i++){
        if(DAO.staffs[i].id == userId){
          break;
        }
        if(i == DAO.staffs.length){
          msg = "Invalid user or bookId";
          return msg;
        }
      }
      for(j = 0; j <= DAO.hardMedia.length; j++){
        if(DAO.hardMedia[j].id == bookId){
          break;
        }
        if(i == DAO.hardMedia.length){
          msg = "Invalid user or book Id";
          return msg;
        }
      }
      DAO.staffs[i].bookLimit++;
      DAO.hardMedia[j].mediaCount++;
      msg = "book issued successfully";
      return msg;
    }
    return msg;
  }

  public int checkBalance(int userId, String userType){
    if(userType.equals("student")){
      for(i = 0; i <= DAO.students.length; i++){
        if(DAO.students[i].id == userId){
          return DAO.students[i].bookLimit;
        }
        if(i == DAO.students.length){
          return -1;
        }
      }
    }else if(userType.equals("staff")){
      for(i = 0; i <= DAO.staffs.length; i++){
        if(DAO.staffs[i].id == userId){
          return DAO.staffs[i].bookLimit;
        }
        if(i == DAO.staffs.length){
          return -1;
        }
      }
    }
    return -1;
  }

  public String searchBook(String bookTitle){
    for(i = 0; i <= DAO.hardMedia.length; i++){
      if(DAO.hardMedia[i].title.equals(bookTitle)){
        return DAO.hardMedia[i].location;
      }else{
        msg = "Book not Found!";
        return msg;
      }
    }
    return msg;
  }
}
