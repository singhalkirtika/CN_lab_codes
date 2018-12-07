import java.io.*;
import java.net.*;

class Client_File{
  public static void main(String args[]) throws Exception{

    Socket socket = new Socket(InetAddress.getByName("localhost"),5000);
    byte[] contents = new byte[10000];

    FileOutputStream fos = new FileOutputStream("tt1.txt");
    BufferedOutputStream bos = new BufferedOutputStream(fos);
    InputStream is = socket.getInputStream();

    int bytesRead = 0;

    while((bytesRead=is.read(contents))!=-1){
       bos.write(contents,0,bytesRead);
    }

    bos.flush();
    socket.close();

    System.out.println("File saved successfully");
  }
}
