package com.darshit.lib.view;

import java.util.Scanner;
import com.darshit.lib.model.*;
import com.darshit.lib.controller.*;

class LmsImplement{
  public static void main(String args[]){
    Scanner keyboard = new Scanner(System.in);
    int userId, bookId, balance;
    String userType, message, bookTitle;
    Transaction transaction = new Transaction();
    DAO.initData();
    while(true){
      System.out.println("Choose From Below: ");
      System.out.println("1. issue book");
      System.out.println("2. return book");
      System.out.println("3. check balance");
      System.out.println("4. search book");
      System.out.println("5. exit");
      int choice = keyboard.nextInt();
      keyboard.nextLine();
      switch(choice){
        case 1: System.out.println("Enter User Type: ");
                userType = keyboard.nextLine();
                System.out.println("Enter User Id: ");
                userId = keyboard.nextInt();
                System.out.println("Enter Book Id:" );
                bookId = keyboard.nextInt();
                message = transaction.issueBook(userId, bookId, userType);
                System.out.println(message);
                break;
        case 2: System.out.println("Enter User Id: ");
                userId = keyboard.nextInt();
                System.out.println("Enter Book Id:" );
                bookId = keyboard.nextInt();
                System.out.println("Enter User Type: ");
                userType = keyboard.nextLine();
                message = transaction.returnBook(userId, bookId, userType);
                System.out.println(message);
                break;
        case 3: System.out.println("Enter User Id: ");
                userId = keyboard.nextInt();
                System.out.println("Enter User Type: ");
                userType = keyboard.nextLine();
                balance = transaction.checkBalance(userId, userType);
                if(balance == -1){
                  System.out.println("User Not Found!");
                }else{
                  System.out.println(userType + " Balance =" + balance);
                }
                break;
        case 4: System.out.println("Enter book title for you want to search: ");
                bookTitle = keyboard.nextLine();
                message = transaction.searchBook(bookTitle);
                System.out.println("Book found at location: "+message);
                break;
        case 5: System.exit(0);
                break;
        default: System.out.println("Invalid Choice!");
      }
    }
  }
}
