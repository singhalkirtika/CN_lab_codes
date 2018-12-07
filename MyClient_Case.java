import java.net.*;
import java.io.*;

class MyClient_Case{
  public static void main(String args[]) throws Exception{
    Socket s=new Socket("localhost",3333);
    DataInputStream din=new DataInputStream(s.getInputStream());
    DataOutputStream dout=new DataOutputStream(s.getOutputStream());
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    String str="",str2="",str3="",str4="";
    while(!str.equals("stop")){
        str=br.readLine();
        dout.writeUTF(str);
        dout.flush();
        str2=din.readUTF();

        if(!str2.equals("stop"))
        {
      	  	System.out.println(str2);

          	if(str2.equals("Enter Choice whether UPPER or LOWER Case"))
          	 	{
                str3=br.readLine();
                dout.writeUTF(str3);
                dout.flush();
                str4=din.readUTF();
                System.out.println(str4);
              }
        }

      	else
      	 	break;
    }

    dout.close();
    s.close();

  }
}
