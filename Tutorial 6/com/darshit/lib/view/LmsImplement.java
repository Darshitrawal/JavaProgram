package com.darshit.lib.view;

import com.darshit.lib.model.*;
import com.darshit.lib.controller.*;
import java.util.*;
import java.io.*;

class LmsImplement extends Exception{

  public static void welcomeMessagePrint(String welcomeMessage){
    System.out.println("");
    System.out.print("\t\t\t\t");
    for(int i = 0; i < welcomeMessage.length(); i++){
      System.out.print(welcomeMessage.charAt(i));
      try{
        Thread.sleep(50);
      }catch(Exception e){
        e.printStackTrace();
      }
    }
    System.out.println("");
  }

  public static void clearScreen() throws Exception{
    Runtime.getRuntime().exec("cls");
  }

  public static void main(String args[]){
    String welcomeMessage = "- : Welcome To Library Management System : -";
    welcomeMessagePrint(welcomeMessage);
    Scanner keyboard = new Scanner(System.in);
    int userId, bookId, balance;
    String userType, message, bookTitle;
    boolean availUserType, status = false;
    int userFoundIndex, bookFoundIndex;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayList<String> locations = new ArrayList<String>();
    // int[] array = new int[6];
    Transaction transaction = new Transaction();
    DAO.initData();
    while(true){
      try{
        clearScreen();//new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      }catch(Exception e){

      }
      System.out.println("");
      System.out.println("");
      System.out.println("------------ Operation Choices ------------");
      System.out.println("1. issue book");
      System.out.println("2. return book");
      System.out.println("3. check balance");
      System.out.println("4. search book");
      System.out.println("5. user book list");
      System.out.println("6. add new Student");
      System.out.println("7. add new Staff");
      System.out.println("8. exit");
      System.out.print("Enter Your Choice: ");

      int choice = keyboard.nextInt();
      keyboard.nextLine();
      try{
        switch(choice){
          case 1: System.out.print("Enter User Type: ");
                  userType = keyboard.nextLine();
                  System.out.print("Enter User Id: ");
                  userId = keyboard.nextInt();
                  System.out.print("Enter Book Id: " );
                  bookId = keyboard.nextInt();
                  availUserType = transaction.checkUserType(userType);
                  if(availUserType == true){
                    userFoundIndex = transaction.checkUserAvailability(userId, userType);
                    bookFoundIndex = transaction.checkBookAvailability(bookId);
                    if(userFoundIndex == -1){
                      message = "Invalid user or book";
                      throw new UserNotFoundException(message);
                    }else if(bookFoundIndex == -1){
                      message = "Invalid user or book";
                      throw new BookNotFoundException(message);
                    }else{
                      System.out.println(transaction.issueBook(userFoundIndex, bookFoundIndex, userType));
                    }
                  }else if(availUserType == false){
                    message = "Invalid user type!";
                    throw new InvalidUserTypeException(message);
                  }
                  break;
          case 2: System.out.print("Enter User Type: ");
                  userType = keyboard.nextLine();
                  System.out.print("Enter User Id: ");
                  userId = keyboard.nextInt();
                  System.out.print("Enter Book Id:" );
                  bookId = keyboard.nextInt();
                  availUserType = transaction.checkUserType(userType);
                  if(availUserType == true){
                    userFoundIndex = transaction.checkUserAvailability(userId, userType);
                    bookFoundIndex = transaction.checkBookAvailability(bookId);
                    if(userFoundIndex == -1){
                      message = "Invalid user or book";
                      throw new UserNotFoundException(message);
                    }else if(bookFoundIndex == -1){
                      message = "Invalid user or book";
                      throw new BookNotFoundException(message);
                    }else{
                      System.out.println(transaction.returnBook(userFoundIndex, bookFoundIndex, userType));
                    }
                  }else if(availUserType == false){
                    message = "Invalid user type!";
                    throw new InvalidUserTypeException(message);
                  }
                  break;
          case 3: System.out.print("Enter User Type: ");
                  userType = keyboard.nextLine();
                  System.out.print("Enter User Id: ");
                  userId = keyboard.nextInt();
                  availUserType = transaction.checkUserType(userType);
                  if(availUserType == true){
                    userFoundIndex = transaction.checkUserAvailability(userId, userType);
                    if(userFoundIndex == -1){
                      message = "Invalid user";
                      throw new UserNotFoundException(message);
                    }else{
                      balance = transaction.checkBalance(userFoundIndex, userType);
                      System.out.println(userType + " Balance = " + balance);
                    }
                  }else if(availUserType == false){
                    message = "Invalid user type!";
                    throw new InvalidUserTypeException(message);
                  }
                  break;
          case 4: System.out.print("Enter book title for you want to search: ");
                  bookTitle = keyboard.nextLine();
                  System.out.println("Book Found At location: "+transaction.checkBookAvailability(bookTitle));
                  break;
          case 5: System.out.print("Enter User Type: ");
                  userType = keyboard.nextLine();
                  System.out.print("Enter User Id: ");
                  userId = keyboard.nextInt();
                  availUserType = transaction.checkUserType(userType);
                  if(availUserType == true){
                    userFoundIndex = transaction.checkUserAvailability(userId, userType);
                    if(userFoundIndex == -1){
                      message = "Invalid user";
                      throw new UserNotFoundException(message);
                    }else{
                      titles.addAll(transaction.getBookTitle(userFoundIndex, userType));
                      locations.addAll(transaction.getBookLocation(userFoundIndex, userType));
                      for(int i = 0; i < titles.size(); i++){
                        System.out.println("Book Titles: "+ titles.get(i));
                        System.out.println("Book location: "+ locations.get(i));
                      }
                    }
                  }else if(availUserType == false){
                    message = "Invalid user type!";
                    throw new InvalidUserTypeException(message);
                  }
                  break;
          case 6: System.out.print("Enter User Id: ");
                  String newUserId = keyboard.next();
                  System.out.print("Enter User enrollment No.: ");
                  String newUserEnroll = keyboard.next();
                  System.out.print("Enter User Name: ");
                  String newUserName = keyboard.next();
                  System.out.print("Enter User Branch: ");
                  String newUserBrach = keyboard.next();
                  System.out.print("Enter User Sem: ");
                  String newUserSem = keyboard.next();
                  userType = "student";
                  userFoundIndex = transaction.checkUserAvailability(newUserId, userType);
                  try{
                    int checkUserId = Integer.parseInt(newUserId);
                    int checkUserEnroll = Integer.parseInt(newUserEnroll);
                    int checkUserSem = Integer.parseInt(newUserSem);
                    status = true;
                  }catch(NumberFormatException nfe){
                    System.out.println("Provided Information must be in Int Formate");
                    status = false;
                  }
                  if(status){
                    if(userFoundIndex == -1){
                      if(transaction.newUser(newUserId, newUserEnroll, newUserName, newUserBrach, newUserSem)){
                        System.out.println("User Added Successfully");
                      }else{
                        System.out.println("Unable To Add New User");
                      }
                    }else{
                      System.out.println("Unable To Add Student Because Student already exists");
                    }
                  }
                  break;
          case 7: System.out.print("Enter User Id: ");
                  newUserId = keyboard.next();
                  System.out.print("Enter User Name: ");
                  newUserName = keyboard.next();
                  System.out.print("Enter User Branch: ");
                  newUserBrach = keyboard.next();
                  System.out.print("Enter User Designation: ");
                  String newUserDesignation = keyboard.next();
                  userType = "staff";
                  userFoundIndex = transaction.checkUserAvailability(newUserId, userType);
                  try{
                    int checkUserId = Integer.parseInt(newUserId);
                    status = true;
                  }catch(NumberFormatException nfe){
                    System.out.println("Provided Information must be in Int Formate");
                    status = false;
                  }
                  if(status){
                    if(userFoundIndex == -1){
                      if(transaction.newUser(newUserId, newUserName, newUserBrach, newUserDesignation)){
                        System.out.println("User Added Successfully");
                      }else{
                        System.out.println("Unable To Add New User");
                      }
                    }else{
                      System.out.println("Unable To Add Staff Because Staff already exists");
                    }
                  }
                  break;
          case 8: System.exit(0);
                  break;
          default: System.out.println("Invalid Choice!");
        }
      }catch(BookNotFoundException bnfe){
        System.out.println(bnfe);
      }catch(UserNotFoundException unfe){
        System.out.println(unfe);
      }catch(InsufficientBalanceException ibe){
        System.out.println(ibe);
      }catch(BookNotAvailableException bnae){
        System.out.println(bnae);
      }catch(InvalidUserTypeException iute){
        System.out.println(iute);
      }catch(Exception e){
        e.printStackTrace();
      }
    }
  }
}
