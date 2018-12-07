import java.net.*;
import java.io.*;
import java.util.*;

class MyServer_Case{

public static void main(String args[])throws Exception{
  ServerSocket ss=new ServerSocket(3333);
  Socket s=ss.accept();
  DataInputStream din=new DataInputStream(s.getInputStream());
  DataOutputStream dout=new DataOutputStream(s.getOutputStream());
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

  String str="",str2="",str3="";
  while(!str.equals("stop")){
      str=din.readUTF();
      System.out.println(str);
      int f=0;

      if(!str.equals("stop"))
        {
          try{

                if(str.compareTo(str.toLowerCase())==0)
                   dout.writeUTF(str.toUpperCase());

                else if(str.compareTo(str.toUpperCase())==0)
                   dout.writeUTF(str.toLowerCase());

                else
                {
                     dout.writeUTF("Enter Choice whether UPPER or LOWER Case");
                     str2=din.readUTF();
                     str3=str2.toUpperCase();
                     if(str3.compareTo("UPPER")==0)
                      dout.writeUTF(str.toUpperCase());

                      else if(str3.compareTo("LOWER")==0)
                       dout.writeUTF(str.toLowerCase());
                  }

            }
          catch (Exception e) {
                    dout.writeUTF("Invalid");
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
