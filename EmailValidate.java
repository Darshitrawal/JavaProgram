class EmailValidate
{
    public static void main(String args[])
    {
        if(args.length != 1){
            System.out.println("ERROR:::TOO FEW ARGUMENT");
            System.out.println("i.e. java EmailValidate <Email Address>");
            System.out.println("<Email Address> - Enter Email Address");
            System.exit(0);
        }
        String email = args[0];
        int flag = 1;
        int firstLetter = email.codePointAt(0);
        if(firstLetter >= 97 && firstLetter <= 122)
        {
            String emailParts[] = email.split("@");
            int emailNameLength = emailParts[0].length();
            if(emailNameLength >= 8 && emailNameLength <= 20)
            {
                for(int i = 1; i < emailNameLength ; i++)
                {
                    int charUnicode = emailParts[0].codePointAt(i);
                    if(charUnicode<48 || (charUnicode>57 && charUnicode<65) || (charUnicode>90 && charUnicode<97) || charUnicode>122)
                    {
                        flag = 0;
                    }
                }
                if(flag == 1)
                {
                    int checkPos = email.indexOf('@');
                    int checkDotPos = email.indexOf('.');
                    if(checkPos != -1)
                    {
                        if(checkDotPos != -1)
                        {
                            if((checkDotPos - checkPos) > 2)
                            {
                                System.out.println("valid Email Address");
                            }
                            else
                            {
                                System.out.println("Invalid Email Address");
                            }
                        }
                        else
                        {
                            System.out.println("Invalid Email Address");
                        }                        
                    }
                    else
                    {
                        System.out.println("Invalid Email Address");
                    } 
                }
                else
                {
                    System.out.println("Invalid Email Address");
                }                       
            }
            else
            {
                System.out.println("Invalid Email Address");
            }
        }
        else
        {
            System.out.println("Invalid Email Address");
        }    
    }
}