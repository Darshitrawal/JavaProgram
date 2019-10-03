package com.darshit.lib.controller;

import com.darshit.lib.model.*;
import java.util.*;

public class Transaction{

  String msg = "";
  boolean flag = false;
  boolean status = false;
  ArrayList<String> streamsTitle = new ArrayList<String>();
  ArrayList<String> streamsLocation = new ArrayList<String>();
  int i , j, k, balance;

  public String issueBook(int userFoundIndex, int bookFoundIndex, String userType)
    throws InsufficientBalanceException, BookNotAvailableException{
    if(userType.equals("student")){
      if(DAO.students.get(userFoundIndex).bookLimit < 1){
        msg = "Insufficient Balance to issue book!";
        throw new InsufficientBalanceException(msg);
      }else if(DAO.hardMedia.get(bookFoundIndex).mediaCount < 1){
        msg = "Book not available!";
        throw new BookNotAvailableException(msg);
      }else{
        DAO.students.get(userFoundIndex).bookLimit--;
        DAO.hardMedia.get(bookFoundIndex).mediaCount--;
        DAO.students.get(userFoundIndex).issuedBooks.add(DAO.hardMedia.get(bookFoundIndex));
        msg = "Book Issued Successfully";
      }
    }else if(userType.equals("staff")){
      if(DAO.staffs.get(userFoundIndex).bookLimit < 1){
        msg = "Insufficient Balance to issue book!";
        throw new InsufficientBalanceException(msg);
      }else if(DAO.hardMedia.get(bookFoundIndex).mediaCount < 1){
        msg = "Book not available!";
        throw new BookNotAvailableException(msg);
      }else{
        DAO.staffs.get(userFoundIndex).bookLimit--;
        DAO.hardMedia.get(bookFoundIndex).mediaCount--;
        DAO.staffs.get(userFoundIndex).issuedBooks.add(DAO.hardMedia.get(bookFoundIndex));
        msg = "Book Issued Successfully";
      }
    }
    return msg;
  }

  public String returnBook(int userFoundIndex, int bookFoundIndex, String userType)
  throws InsufficientBalanceException{
    if(userType.equals("student")){
      if(DAO.students.get(userFoundIndex).bookLimit > 3){
        msg = "you didn't Issued any book!";
        throw new InsufficientBalanceException(msg);
      }else{
        DAO.students.get(userFoundIndex).bookLimit++;
        DAO.hardMedia.get(bookFoundIndex).mediaCount++;
        DAO.students.get(userFoundIndex).issuedBooks.remove(DAO.hardMedia.get(bookFoundIndex));
        msg = "Book Returned Successfully";
      }
    }else if(userType.equals("staff")){
      if(DAO.staffs.get(userFoundIndex).bookLimit > 3){
        msg = "you didn't Issued any book!";
        throw new InsufficientBalanceException(msg);
      }else{
        DAO.staffs.get(userFoundIndex).bookLimit++;
        DAO.hardMedia.get(bookFoundIndex).mediaCount++;
        DAO.staffs.get(userFoundIndex).issuedBooks.remove(DAO.hardMedia.get(userFoundIndex));
        msg = "Book Returned Successfully";
      }
    }
    return msg;
  }

  public int checkBalance(int userFoundIndex, String userType){
    if(userType.equals("student")){
      balance = DAO.students.get(userFoundIndex).bookLimit;
    }else if(userType.equals("staff")){
      balance = DAO.staffs.get(userFoundIndex).bookLimit;
    }
    return balance;
  }

  // Overloaded
  public String checkBookAvailability(String bookTitle)
  throws BookNotFoundException{
    for(i = 0; i < DAO.hardMedia.size(); i++){
      if(bookTitle.equals(DAO.hardMedia.get(i).title)){
        msg = DAO.hardMedia.get(i).location;
        break;
      }
    }
    if(i == DAO.hardMedia.size()){
      msg = "Book not Found!";
      throw new BookNotFoundException(msg);
    }
    return msg;
  }

  public int checkUserAvailability(int userId, String userType)
  throws UserNotFoundException{
    if(userType.equals("student")){
      for(i = 0; i < DAO.students.size(); i++){
        if(DAO.students.get(i).id == userId){
          break;
        }
      }
      if(i == DAO.students.size()){
        msg = "Invalid User Id";
        i = -1;
        throw new UserNotFoundException(msg);
      }
    }else if(userType.equals("staff")){
      for(i = 0; i < DAO.staffs.size(); i++){
        if(DAO.staffs.get(i).id == userId){
          break;
        }
      }
      if(i == DAO.staffs.size()){
        msg = "Invalid user or book Id";
        i = -1;
        throw new UserNotFoundException(msg);
      }
    }
    return i;
  }

  //Overloaded
  public int checkUserAvailability(String userId, String userType){
    int newUserIdInt = Integer.parseInt(userId);
    if(userType.equals("student")){
      for(i = 0; i < DAO.students.size(); i++){
        if(DAO.students.get(i).id == newUserIdInt){
          break;
        }
      }
      if(i == DAO.students.size()){
        i = -1;
      }
    }else if(userType.equals("staff")){
      for(i = 0; i < DAO.staffs.size(); i++){
        if(DAO.staffs.get(i).id == newUserIdInt){
          break;
        }
      }
      if(i == DAO.staffs.size()){
        i = -1;
      }
    }
    return i;
  }




  public int checkBookAvailability(int bookId){
    for(j = 0; j < DAO.hardMedia.size(); j++){
      if(DAO.hardMedia.get(j).id == bookId){
        break;
      }
    }
    if(j == DAO.hardMedia.size()){
      j = -1;
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

  public ArrayList<String> getBookTitle(int userFoundIndex, String userType){
    if(userType.equals("student")){
      for(int i = 0; i < DAO.students.get(userFoundIndex).issuedBooks.size(); i++){
        streamsTitle.add(DAO.students.get(userFoundIndex).issuedBooks.get(i).title);
      }
    }else if(userType.equals("staff")){
      for(int i = 0; i < DAO.staffs.get(userFoundIndex).issuedBooks.size(); i++){
        streamsTitle.add(DAO.staffs.get(userFoundIndex).issuedBooks.get(i).title);
      }
    }
    return streamsTitle;
  }

  public ArrayList<String> getBookLocation(int userFoundIndex, String userType){
    if(userType.equals("student")){
      for(int i = 0; i < DAO.students.get(userFoundIndex).issuedBooks.size(); i++){
        streamsLocation.add(DAO.students.get(userFoundIndex).issuedBooks.get(i).location);
      }
    }else if(userType.equals("staff")){
      for(int i = 0; i < DAO.staffs.get(userFoundIndex).issuedBooks.size(); i++){
        streamsLocation.add(DAO.staffs.get(userFoundIndex).issuedBooks.get(i).location);
      }
    }
    return streamsLocation;
  }

  public boolean newUser(String newUserId, String newUserEnroll, String newUserName, String newUserBrach, String newUserSem, String newBookLimit){
    if(DAO.students.add(new Student(Integer.parseInt(newUserId), Integer.parseInt(newUserEnroll), newUserName, newUserBrach, Integer.parseInt(newUserSem), Integer.parseInt(newBookLimit)))){
      status = true;
    }else{
      status = false;
    }
    return status;
  }

  //Overloaded
  public boolean newUser(String newUserId, String newUserName, String newUserBrach, String newUserDesignation, String newBookLimit){
    if(DAO.staffs.add(new Staff(Integer.parseInt(newUserId), newUserName, newUserBrach, newUserDesignation, Integer.parseInt(newBookLimit)))){
      status = true;
    }else{
      status = false;
    }
    return status;
  }

}
