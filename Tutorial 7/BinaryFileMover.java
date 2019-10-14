import java.io.*;

class BinaryFileMover{
  public static void main(String[] args){
    try{
      File sourceFile = new File(args[0]);
      File destinationFile = new File(args[1]);
      byte[] dataChunk = new byte[1000000];
      FileInputStream fis = new FileInputStream(sourceFile);
      FileOutputStream fos = new FileOutputStream(destinationFile);
      while(fis.read(dataChunk) != -1){
        fos.write(dataChunk);
      }
      fis.close();
      fos.close();
    }catch(IOException ioe){
      ioe.printStackTrace();
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}
