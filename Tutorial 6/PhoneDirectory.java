import java.util.*;

class PhoneNumber{
    String name, number;
    Properties directory = new Properties();
    String searchContact(String name){
       return directory.getProperty(name);
    }
    void addPhoneNumber(String name, String Number){
      directory.put(name, Number);
    }
    void deletePhoneNumber(String name){
      directory.remove(name);
    }
}

class PhoneDirectory{
  public static void main(String args[]){
    Scanner keyboard = new Scanner(System.in);
    PhoneNumber phno = new PhoneNumber();
    boolean flag;
    while(true){
      System.out.println("1. Find Number \n2. Add Number \n3. Delete Contact \n4. Exit");
      System.out.print("Enter Your Choice: ");
      int choice = keyboard.nextInt();
      switch(choice){
        case 1: System.out.print("Enter Name To search Number: ");
                String name = keyboard.next();
                String Number = phno.searchContact(name);
                System.out.println(Number);
                break;
        case 2: System.out.print("Enter Name To Add: ");
                name = keyboard.next();
                System.out.print("Enter Number To Add: ");
                Number = keyboard.next();
                phno.addPhoneNumber(name, Number);
                break;
        case 3: System.out.print("Enter Name To search Number: ");
                name = keyboard.next();
                phno.deletePhoneNumber(name);
                break;
        case 4: System.exit(0);
                break;
        default: System.out.println("Invalid Choice!");
      }
    }
  }
}
