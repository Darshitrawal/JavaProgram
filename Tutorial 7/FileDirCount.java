import java.io.*;

class FileDirCount{
  public static void main(String args[]){
    if(args.length != 1){
         System.out.println("ERROR:::TOO FEW ARGUMENT");
         System.out.println("i.e. java FileDirCount <Absalute Path of Directory>");
         System.out.println("<Absalute Path of Directory> - Enter Absalute Path of Directory In Order to count files and directories");
         System.exit(0);
     }
    File f = new File(args[0]);
    int FileCount = 0;
    int DirCount = 0;
    if(f.isDirectory()){
      String[] objs = f.list();
      for(int i = 0; i < objs.length; i++){
        File temp = new File(objs[i]);
        if(temp.isFile()){
          FileCount++;
        }else{
          DirCount++;
        }
      }
      System.out.println("No. of Files are: " + FileCount);
      System.out.println("No. of Directories are: " + DirCount);
    }
  }
}
