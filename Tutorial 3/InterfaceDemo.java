interface p{
  int pVar = 5;
  public void displayP();
}
interface p1 extends p{
  int p1Var = 10;
  public void displayP1();
}
interface p2 extends p{
  int p2Var = 15;
  public void displayP2();
}
interface p12 extends p1, p2{
  int p12Var = 20;
  public void displayP12();
}
class Q implements p12{
  public void displayP12(){
    System.out.println(p12.p12Var);
  }
  public void displayP1(){
    System.out.println(p1.p1Var);
  }
  public void displayP2(){
    System.out.println(p2.p2Var);
  }
  public void displayP(){
    System.out.println(p.pVar);
  }
}
class InterfaceDemo{
  public static void main(String args[]){
    Q q = new Q();
    int choice = Integer.parseInt(args[0]);
    switch(choice){
      case 1: q.displayP12();
              break;
      case 2: q.displayP1();
              break;
      case 3: q.displayP2();
              break;
      case 4: q.displayP();
              break;
      default:System.out.println("Invalid choice!");
    }
  }
}
