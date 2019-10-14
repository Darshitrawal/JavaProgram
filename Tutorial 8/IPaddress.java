import java.net.InetAddress;
import java.util.*;

public class IPaddress{
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    int choice;
    while(true){
      try{
        System.out.println("\n\n1. Get Ip using System Name \n2. Get System Name using Ip \n3. Exit");
        System.out.print("Enter Choice: ");
        choice = keyboard.nextInt();
        switch(choice){
          case 1: System.out.print("Enter System Name: ");
                  String SystemName = keyboard.next();
                  InetAddress ia = InetAddress.getByName(SystemName);
                  System.out.println("System Ip Address is: "+ia);
                  break;
          case 2: System.out.print("Enter Ip Address Of System: ");
                  String ip = keyboard.next();
                  InetAddress ina = InetAddress.getByName(ip);
                  System.out.println("System Name is: "+ina.getHostName());
                  break;
          case 3: System.exit(0);
                  break;
          default: System.out.println("Invalid choice!");
      }
    }catch(Exception e){
      System.out.println("Invalid Ip OR Host Name!");
      System.exit(0);
    }
  }
}
}
