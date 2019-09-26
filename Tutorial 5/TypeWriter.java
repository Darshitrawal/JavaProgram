class TypeWriter extends Thread{
  String msg;
  TypeWriter(String msg){
    this.msg = msg;
    Thread t = new Thread(this);
    t.start();
  }
  public void run(){
    try{
      int length = msg.length();
      for(int i = 0; i < length; i++){
        System.out.print(msg.charAt(i));
        Thread.sleep(100);
      }
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  public static void main(String args[]){
    try{
      TypeWriter tw = new TypeWriter("Hello World");
    }catch(Exception e){
      e.printStackTrace();
    }
    // int x = 1;
    // while(x <= 2){
    //   System.out.println(x);
    //   x++;
    // }
  }
}
