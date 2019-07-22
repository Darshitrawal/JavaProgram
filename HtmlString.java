class HtmlString
{
    public static void main(String args[])
    {
        if(args.length != 1){
            System.out.println("ERROR:::TOO FEW ARGUMENT");
            System.out.println("i.e. java HtmlString <Html_Tag>");
            System.out.println("<Html_Tag> - Enter Html Tag");
            System.exit(0);
        }
        String htmlTag = args[0];
        int flag = 1;
        int htmlTagLength = htmlTag.length();
        for(int i = 0; i < htmlTagLength; i++)
        {
            int asciiValue = htmlTag.codePointAt(i);
            if(asciiValue == 60)
            {
                flag = 0;
            }
            else if(asciiValue == 62)
            {
                flag = 1;
            }
            else if(flag == 1)
            {
                //char d = htmlTag.charAt(i);
                System.out.print(htmlTag.charAt(i));
            }
        }
    }
}