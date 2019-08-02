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
        for(int i = 0; i < htmlTag.length(); i++)
        {
            if(htmlTag.charAt(i) == '<')
            {
                flag = 0;
            }
            else if(htmlTag.charAt(i) == '>')
            {
                flag = 1;
            }
            else if(flag == 1)
            {
                System.out.print(htmlTag.charAt(i));
            }
        }
    }
}