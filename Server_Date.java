import java.net.*;
import java.io.*;
import java.util.*;

class Server_Date{
public static void main(String args[])throws Exception{
  ServerSocket ss=new ServerSocket(3333);
  Socket s=ss.accept();
  //DataInputStream din=new DataInputStream(s.getInputStream());
  DataOutputStream dout=new DataOutputStream(s.getOutputStream());
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

  String str="",str2="",str3="";
  dout.writeUTF("Server Date: " + (new Date()).toString() + "\n");

  //din.close();
  s.close();
  ss.close();
}}
