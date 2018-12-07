import java.net.*;
import java.io.*;

class MyServer{
public static void main(String args[])throws Exception{
  ServerSocket ss=new ServerSocket(3333);
  Socket s=ss.accept();
  DataInputStream din=new DataInputStream(s.getInputStream());
  DataOutputStream dout=new DataOutputStream(s.getOutputStream());
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  InetAddress ip ;
  String str="",str2="",str3="";
  while(!str.equals("stop")){
      str=din.readUTF();
      if(!str.equals("stop"))
        {
          try{
              ip = InetAddress.getByName(str);
              System.out.println("Host Name: "+ip.getHostName());
              str2=ip.getHostAddress();
              dout.writeUTF("IP Address: "+str2);
            }
          catch (Exception e) {
                    dout.writeUTF("Invalid Host Name");
           }
     }

      else
       {
          dout.writeUTF("stop");
          break;
       }
              dout.flush();
  }
  din.close();
  s.close();
  ss.close();
}}
