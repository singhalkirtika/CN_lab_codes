import java.net.*;
import java.io.*;

class Client_Date{
public static void main(String args[])throws Exception{
  Socket s=new Socket("localhost",3333);
  DataInputStream din=new DataInputStream(s.getInputStream());
  DataOutputStream dout=new DataOutputStream(s.getOutputStream());
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

  String str="";

  str=din.readUTF();
  System.out.println(str);

  dout.close();
  s.close();
}}
