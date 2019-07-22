class BasicCalc
{
    public static void main(String args[])
    {
        if(args.length!=3)
        {
           System.out.println("ERROR::: TOO FEW ARGUMENTS");
           System.out.println("i.e. java BasicCalc <Ammount 1> <Operation to perform> <Ammount 2>");
           System.out.println("<Ammount 1> - first operator on which you want to perform opration");
           System.out.println("<operation to perform> - \n+ \n- \n* \n/");
           System.out.println("<Ammount 2> - second operator on which you want to perform opration");
           System.exit(0);
        }           
        double amt1 = Double.parseDouble(args[0]);
        String sign = args[1];
        double amt2 = Double.parseDouble(args[2]);
        double result;
        if(sign.equals("+"))
        {
            result = amt1 + amt2;
            System.out.println(result);
        }else if(sign.equals("-"))
        {
            result = amt1 - amt2;
            System.out.println(result);
        }else if(sign.equals('*'))
        {
            result = amt1 * amt2;
            System.out.println(result);
        }else if(sign.equals("/"))
        {
            result = amt1 / amt2;
            System.out.println(result);
        }else
        {
            System.out.println("Invalid!");
        }
    }
}