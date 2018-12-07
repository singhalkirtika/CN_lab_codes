import java.io.*;
import java.net.*;

class Server_File{
  public static void main(String args[]) throws Exception{

    ServerSocket ssock = new ServerSocket(5000);
    Socket socket = ssock.accept();

    File file = new File("E:\\test.txt.txt");
    FileInputStream fis = new FileInputStream(file);
    BufferedInputStream bis = new BufferedInputStream(fis);

    OutputStream out = socket.getOutputStream();

    byte[] contents;
    long filelength = file.length();
    long current = 0;

    while(current!=filelength)
    {
      int size = 10000;

      if((filelength-current)>=size)
            current +=size;

      else{
            current = filelength;
          }

      contents = new byte[size];
      bis.read(contents,0,size);
      out.write(contents);
      System.out.println("File sent successfully");
    }

    socket.close();
    ssock.close();
    System.out.println("File sent successfully");

  }
}
