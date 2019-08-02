class EnrollmentValidate
{
    public static void main(String args[])
    {
        if(args.length != 1){
            System.out.println("ERROR:::TOO FEW ARGUMENT");
            System.out.println("i.e. java EnrollmentValidate <Enrollment Number>");
            System.out.println("<Enrollment Number> - Enter Enrollment Number");
            System.exit(0);
        }
        String enrollment = args[0];
        int enrollmentLength = enrollment.length();
        int admissionYear = Integer.parseInt(enrollment.substring(0, 2));
        int admissioncollege = Integer.parseInt(enrollment.substring(3, 5));
        int studentType = Integer.parseInt(enrollment.substring(5, 7));
        int admissionBranch = Integer.parseInt(enrollment.substring(7, 9));
        int enrollmentSequence = Integer.parseInt(enrollment.substring(10, enrollmentLength));
        
        if(admissionYear == 17 || admissionYear == 18)
        {
            if(admissioncollege == 47)
            {
                if((studentType == 01 && admissionYear == 17) || (studentType == 31 && admissionYear == 18))
                {
                    if(admissionBranch == 07)
                    {
                        if(enrollmentSequence >= 1 && enrollmentSequence <= 65)
                        {
                            System.out.println("valid!");
                            System.exit(0);
                        }
                        else
                        {
                            System.out.println("Not Valid!");
                            System.exit(0);
                        }
                    }
                    else
                    {
                        System.out.println("Not Valid!");
                        System.exit(0);
                    }
                }
                else
                {
                    System.out.println("Not Valid!");
                    System.exit(0);
                }
            }
            else
            {
                System.out.println("Not Valid!");
                System.exit(0);
            }
        }
        else
        {
            System.out.println("Not Valid!");
            System.exit(0);
        }
    }
}