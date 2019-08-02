class CheckForAnagram
{
    public static void main(String args[])
    {
        if(args.length != 2){
            System.out.println("ERROR:::TOO FEW ARGUMENT");
            System.out.println("i.e. java CheckForAnagram <String1> <String2>");
            System.out.println("<String1> = Enter String 1");
            System.out.println("<String2> = Enter String 2");
            System.exit(0);
        }
        int[] forSting1 = new int[127];
        int[] forSting2 = new int[127];
        int flag = 0;
        String first = args[0];
        int firstLength = first.length();
        String second = args[1];
        int secondLength = second.length();
        for(int i = 0; i < firstLength; i++)
        {
            forSting1[first.codePointAt(i)]++;
        }
        for(int i = 0; i < secondLength; i++)
        {
            forSting2[second.codePointAt(i)]++;
        }
        int stringLength = forSting1.length;
        for(int i = 0; i < stringLength; i++)
        {
            if(forSting1[i] == forSting2[i])
            {
                flag = 1;
            }
            else
            {
                flag = 0;
                break;
            }
        }
        if(flag == 1)
        {
            System.out.println("Anagram String");
        }
        else
        {
            System.out.println("Not Anagram String");
        }
    }   
}