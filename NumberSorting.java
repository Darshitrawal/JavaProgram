class NumberSorting
{
    public static void main(String args[])
    {   
        int[] numbersToSort = new int[args.length];
        for(int i = 0; i < args.length; i++)
        {
            numbersToSort[i] = Integer.parseInt(args[i]); 
        }
        for(int i = 0; i < args.length; i++)
        {
            for(int j = 0; j < args.length; j++)
            {
                if(numbersToSort[i] < numbersToSort[j])
                {
                    int temp = numbersToSort[i];
                    numbersToSort[i] = numbersToSort[j];
                    numbersToSort[j] = temp;
                }
            }
        }
        for(int i = 0; i < args.length; i++)
        {
            System.out.println(numbersToSort[i]);
        }
    }
}