import java.net.*;
import java.io.*;
class MyClient{
public static void main(String args[])throws Exception{
  Socket s=new Socket("localhost",3333);
  DataInputStream din=new DataInputStream(s.getInputStream());
  DataOutputStream dout=new DataOutputStream(s.getOutputStream());
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

  String str="",str2="";
  while(!str.equals("stop")){
      str=br.readLine();
      dout.writeUTF(str);
      dout.flush();
      str2=din.readUTF();

      if(!str2.equals("stop") && !str2.equals("Invalid Host Name"))
    		System.out.println("IP address of given host is: "+str2);

    	else if(str2.equals("Invalid Host Name"))
    	 	System.out.println(str2);

    	else
    	 	break;
  }

  dout.close();
  s.close();
}}
