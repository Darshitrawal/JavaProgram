class Animation implements Runnable{
  String symbol;
  Animation(String symbol){
    Thread t = new Thread(this);
    this.symbol = symbol;
    t.start();
  }

  public void run(){
    try{
      while(true){
        System.out.print(symbol);
        Thread.sleep(400);
      }
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  public static void main(String args[]){
    Animation a1 = new Animation("0");
    Animation a2 = new Animation("1");
  }
}
