interface CalculateIntrust{
  public double Interest(double p, double n, double r);
}
class SimpleIntrust implements CalculateIntrust{
  public double Interest(double p, double n, double r){
    return ((p*r*n)/100);
  }
}
class CompoundIntrust implements CalculateIntrust{
  public double Interest(double p, double n, double r){
      return (p*(Math.pow(1+(r/100),n)));
  }
}
class IntrustImplementor{
  public static void main(String args[]){
    if (args.length != 4){
      System.out.println("Too Few Elements..");
      System.out.println("i.e. java IntrustImplementor <choice> < p > < n > < r >");
      System.out.println("<choice> : 1) SimpleIntrust \t 2) CompoundIntrust");
      System.out.println("< p > = Enter Value of p to CalculateIntrust");
      System.out.println("< n > = Enter Value of n to CalculateIntrust");
      System.out.println("< r > = Enter Value of r to CalculateIntrust");
      System.exit(0);
    }
    SimpleIntrust s = new SimpleIntrust();
    CompoundIntrust c = new CompoundIntrust();
    double ans = 0.0;
    double p = Double.parseDouble(args[1]);
    double n = Double.parseDouble(args[2]);
    double r = Double.parseDouble(args[3]);
    int intrustType = Integer.parseInt(args[0]);
    if (intrustType == 1){
      ans = s.Interest(p, n, r);
    }else if (intrustType == 2){
      ans = c.Interest(p, n, r);
    }else {
      System.out.println("Invalid Choice!");
    }
    System.out.println("Answer is: " + ans);
  }
}
