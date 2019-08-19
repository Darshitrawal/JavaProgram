import java.util.*;

class Operations{
  static int arr[] = new int[10];
  int arrayLength = arr.length;
  static int top;
  public boolean push (int x){
    if (top > arrayLength){
      return false;
    }
    else{
      top++;
      arr[top] = x;
      return true;
    }
  }
  public boolean pop (){
    if (top < 0){
      return false;
    }
    else{
      top--;
      return true;
    }
  }
}
class StackImplementor{
  public static void main(String args[]){
    Scanner keyboard = new Scanner(System.in);
    Operations op = new Operations();
    boolean state = true;
    while(true){
      System.out.println("1. Push  Operation");
      System.out.println("2. Pop Operation");
      System.out.println("3. Exit");
      System.out.println("Enter Choice: ");
      int choice = keyboard.nextInt();
      switch (choice){
        case 1: System.out.println("Enter Value to Push into stack: ");
                int a = keyboard.nextInt();
                state = op.push(a);
                break;
        case 2: state = op.pop();
                break;
        case 3: System.exit(0);
                break;
        default: System.out.println("Invalid Choice!");
      }
      if (state){
        System.out.println("Operation Successful!");
      }
      else{
        System.out.println("Operation Failed!");
      }
    }
  }
}
