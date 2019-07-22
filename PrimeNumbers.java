class PrimeNumbers
{
   public static void main(String args[])
   {
       if(args.length != 1){
            System.out.println("ERROR:::TOO FEW ARGUMENT");
            System.out.println("i.e. java PrimeNumbers <Count of PrimeNumbers>");
            System.out.println("<Count of PrimeNumbers> - Enter number number of prime number you want ot find");
            System.exit(0);
        }
        
      int n, status = 1, num = 3, count, j;
       
      System.out.println("Enter the number of prime numbers you want");
      n = Integer.parseInt(args[0]);
     
      if (n >= 1)
      {
         System.out.println("First "+n+" prime numbers are:");
         System.out.println(2);
      }
     
      for (count = 2; count <=n;)
      {
         for (j = 2; j <= Math.sqrt(num); j++)
         {
            if (num%j == 0)
            {
               status = 0;
               break;
            }
         }
         if (status != 0)
         {
            System.out.println(num);
            count++;
         }
         status = 1;
         num++;
      }        
   }
}