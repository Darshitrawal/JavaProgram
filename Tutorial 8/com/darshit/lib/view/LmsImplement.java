package com.darshit.lib.view;

import com.darshit.lib.model.*;
import com.darshit.lib.controller.*;
import java.util.*;
import java.io.*;

class LmsImplement {

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

  public static void main(String args[]){
    String welcomeMessage = "- : Welcome To Library Management System : -";
    welcomeMessagePrint(welcomeMessage);
    Scanner keyboard = new Scanner(System.in);
    int userId, bookId, balance;
    String userType, message, bookTitle;
    String studentRecord="", staffRecord="", hardMediaRecord="";
    boolean availUserType, status = false;
    int userFoundIndex, bookFoundIndex;
    String studentBookLimit = "4", staffBookLimit = "6";
    ArrayList<String> titles = new ArrayList<String>();
    ArrayList<String> locations = new ArrayList<String>();
    Transaction transaction = new Transaction();
    try{
      File readFileStudent = new File("students.csv");
      File readFileStaff = new File("staffs.csv");
      File readFileHardMedia = new File("hardMedias.csv");
      if(readFileStudent.exists() && readFileStaff.exists() && readFileHardMedia.exists()){

        FileReader frStudent = new FileReader(readFileStudent);
        FileReader frStaff = new FileReader(readFileStaff);
        FileReader frHardMedia = new FileReader(readFileHardMedia);

        BufferedReader brStudent = new BufferedReader(frStudent);
        BufferedReader brStaff = new BufferedReader(frStaff);
        BufferedReader brHardMedia = new BufferedReader(frHardMedia);

        String fileRecordStudent = brStudent.readLine();
        String[] fileSaprateRecordStudent = fileRecordStudent.split(";");

        String fileRecordStaff = brStaff.readLine();
        String[] fileSaprateRecordStaff = fileRecordStaff.split(";");

        String fileRecordHardMedia = brHardMedia.readLine();
        String[] fileSaprateRecordHardMedia = fileRecordHardMedia.split(";");

        for(int i = 0; i < fileSaprateRecordStudent.length; i++){
          String[] studentElements = fileSaprateRecordStudent[i].split(",");
          DAO.students.add(new Student(Integer.parseInt(studentElements[0]), Integer.parseInt(studentElements[1]), studentElements[2], studentElements[3], Integer.parseInt(studentElements[4]), Integer.parseInt(studentElements[5])));
        }
        for(int i = 0; i < fileSaprateRecordStaff.length; i++){
          String[] staffElements = fileSaprateRecordStaff[i].split(",");
          DAO.staffs.add(new Staff(Integer.parseInt(staffElements[0]), staffElements[1], staffElements[2], staffElements[3], Integer.parseInt(staffElements[4])));
        }
        for(int i = 0; i < fileSaprateRecordHardMedia.length; i++){
          String[] hardMediaElements = fileSaprateRecordHardMedia[i].split(",");
          DAO.hardMedia.add(new HardMedia(Integer.parseInt(hardMediaElements[0]), hardMediaElements[1], hardMediaElements[2], Integer.parseInt(hardMediaElements[3]), hardMediaElements[4], Integer.parseInt(hardMediaElements[5]), hardMediaElements[6]));
        }

        brStudent.close();
        brStaff.close();
        brHardMedia.close();

      }else{
        DAO.initData();
      }
    }catch(Exception e){
      e.printStackTrace();
    }
    while(true){
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
                      if(transaction.newUser(newUserId, newUserEnroll, newUserName, newUserBrach, newUserSem, studentBookLimit.toString())){
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
                      if(transaction.newUser(newUserId, newUserName, newUserBrach, newUserDesignation, staffBookLimit.toString())){
                        System.out.println("User Added Successfully");
                      }else{
                        System.out.println("Unable To Add New User");
                      }
                    }else{
                      System.out.println("Unable To Add Staff Because Staff already exists");
                    }
                  }
                  break;
          case 8: studentRecord="";
                  for(int i = 0; i < DAO.students.size(); i++){
                    studentRecord += DAO.students.get(i).toString();
                  }
                  staffRecord="";
                  for(int i = 0; i < DAO.staffs.size(); i++){
                    staffRecord += DAO.staffs.get(i).toString();
                  }
                  hardMediaRecord="";
                  for(int i = 0; i < DAO.hardMedia.size(); i++){
                    hardMediaRecord += DAO.hardMedia.get(i).toString();
                  }

                  File writeFileStudent = new File("students.csv");
                  File writeFileStaff = new File("staffs.csv");
                  File writeFileHardMedia = new File("hardMedias.csv");

                  FileWriter fwStudent = new FileWriter(writeFileStudent);
                  FileWriter fwStaff = new FileWriter(writeFileStaff);
                  FileWriter fwHardMedia = new FileWriter(writeFileHardMedia);

                  fwStudent.write(studentRecord.toCharArray());
                  fwStaff.write(staffRecord.toCharArray());
                  fwHardMedia.write(hardMediaRecord.toCharArray());

                  fwStudent.close();
                  fwStaff.close();
                  fwHardMedia.close();

                  System.exit(0);
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
