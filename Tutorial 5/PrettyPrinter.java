class Printer{
  synchronized public void print(String msg){
    System.out.print("[");
    try{
      Thread.sleep(1000);
    }catch(Exception e){
      e.printStackTrace();
    }
    System.out.print(msg);
    System.out.print("]");
  }
}

class User extends Thread{
  Printer p;
  String printJob;
  User(String printJob, Printer p){
    this.p = p;
    this.printJob = printJob;
    Thread t = new Thread(this);
    t.start();
  }
  public void run(){
    p.print(printJob);
  }
}

class PrettyPrinter{
  public static void main(String args[]){
    try{
      Printer p = new Printer();
      User u1 = new User("Darshit", p);
      User u2 = new User("Rawal", p);
      User u3 = new User("aka", p);
      User u4 = new User("Ronny", p);
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}
