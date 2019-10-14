import java.util.*;

class ArrayLists{
  public ArrayList<String> list1 = new ArrayList<String>();
  public ArrayList<String> list2 = new ArrayList<String>();
  public ArrayList<String> list3 = new ArrayList<String>();
  int counter, noOfElements;
  boolean flag;
  public boolean transferElements(String[] elements){
    noOfElements = elements.length;
    for(int i = 0; i < noOfElements; i++){
      for(int j = 0; j < list1.size(); j++){
        if(elements[i].equals(list1.get(j))){
          list2.add(list1.get(j));
          counter++;
        }
      }
    }
    if(counter == noOfElements){
      flag = true;
    }else{
      flag = false;
    }
    return flag;
  }

  public boolean addElements(String[] elements){
    for(int i = 0; i < elements.length; i++){
      if(list1.add(elements[i])){
        flag = true;
      }else{
        flag = false;
      }
    }
    return flag;
  }

  public ArrayList<String> displayList(String type){
    if(type.equals("list1")){
      list3 = list1;
    }else if(type.equals("list2")){
      list3 = list2;
    }
    return list3;
  }
}

class ArrayListMover{
  public static void main(String args[]){
    Scanner keyboard = new Scanner(System.in);
    ArrayList<String> list = new ArrayList<String>();
    ArrayLists arl = new ArrayLists();
    while(true){
      System.out.println("\n\n1. Transfer Elements To Another List2\n2. Add Into List1\n3. Display Elements\n4. Exit");
      System.out.print("Enter your choice: ");
      int choice = keyboard.nextInt();
      switch(choice){
        case 1: System.out.print("Enter Subjects to move (saprated by ',') : ");
                String subjects = keyboard.next();
                String[] Subject = subjects.split(",");
                if(arl.transferElements(Subject)){
                  System.out.println("Subjects Transfer Successful !!");
                }else{
                  System.out.println("Entered Subject is not present in the List 1 !!");
                }
                break;
        case 2: System.out.print("Enter Subjects to Add into List1: ");
                subjects = keyboard.next();
                Subject = subjects.split(",");
                if(arl.addElements(Subject)){
                  System.out.println("Subject Added Successfully !!");
                }else{
                  System.out.println("Can't Add subjects !!");
                }
                break;
        case 3: System.out.print("\n\nEnter the list you want to see: ");
                System.out.println("\n1. list1 \n2. list2");
                System.out.print("Enter Your Choice: ");
                int type = keyboard.nextInt();
                switch(type){
                  case 1: list = arl.displayList("list1");
                          break;
                  case 2: list = arl.displayList("list2");
                          break;
                  default: System.out.println("Invalid Choice !!");
                }
                for(int i = 0; i < list.size(); i++){
                  System.out.println(i+1 +" : "+ list.get(i));
                }
                break;
        case 4: System.exit(0);
                break;
        default: System.out.println("Invalid Choice!!");
      }
    }
  }
}
