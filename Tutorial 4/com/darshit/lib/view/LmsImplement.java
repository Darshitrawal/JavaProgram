package com.darshit.lib.view;

import java.util.Scanner;
import com.darshit.lib.model.*;
import com.darshit.lib.controller.*;


class LmsImplement{

  public static void welcomeMessagePrint(String welcomeMessage){
    System.out.println("");
    System.out.print("\t\t\t\t");
    for(int i = 0; i < welcomeMessage.length(); i++){
      System.out.print(welcomeMessage.charAt(i));
      try{
        Thread.sleep(100);
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
    boolean availUserType;
    int userFoundIndex, bookFoundIndex;
    // int[] array = new int[6];
    Transaction transaction = new Transaction();
    DAO.initData();
    while(true){
      System.out.println("Choose From Below: ");
      System.out.println("1. issue book");
      System.out.println("2. return book");
      System.out.println("3. check balance");
      System.out.println("4. search book");
      //System.out.println("5. Chech user status");
      System.out.println("5. exit");
      int choice = keyboard.nextInt();
      keyboard.nextLine();
      try{
        switch(choice){
          case 1: System.out.println("Enter User Type: ");
                  userType = keyboard.nextLine();
                  System.out.println("Enter User Id: ");
                  userId = keyboard.nextInt();
                  System.out.println("Enter Book Id: " );
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
          case 2: System.out.println("Enter User Type: ");
                  userType = keyboard.nextLine();
                  System.out.println("Enter User Id: ");
                  userId = keyboard.nextInt();
                  System.out.println("Enter Book Id:" );
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
          case 3: System.out.println("Enter User Type: ");
                  userType = keyboard.nextLine();
                  System.out.println("Enter User Id: ");
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
          case 4: System.out.println("Enter book title for you want to search: ");
                  bookTitle = keyboard.nextLine();
                  System.out.println("Book Found At location: "+transaction.checkBookAvailability(bookTitle));
                  break;
          case 5: System.exit(0);
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
