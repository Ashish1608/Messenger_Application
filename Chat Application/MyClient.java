package Messenger;

// import java.lang.*;
import java.net.*;
import java.io.*;

public final class MyClient
{
   
    public String s1, s2;
    public Socket s;
    public BufferedReader brS, brK;
    public PrintStream ps;

    public MyClient()
    {   
        this.s1 = null;
        this.s2 = null;
        
        try
        {
            this.s = new Socket("localhost", 1100);         // request the server(viz. 'localhost') to connect to server sockect on port '1100'
            this.brK = new BufferedReader(new InputStreamReader(System.in));                    // read through keyboard
            this.brS = new BufferedReader(new InputStreamReader(s.getInputStream()));           // read through socket
            this.ps = new PrintStream(s.getOutputStream());
        }
        catch(IOException obj)
        {}
    }

    public void communicate()
    {
        try
        {   
            System.out.print("\nEnter message for server : ");
            while (!((this.s1 = this.brK.readLine()).equals("bye"))) 
            {
                this.ps.println(s1);
                this.s2 = this.brS.readLine();
                System.out.println("Server says : " + this.s2);
                System.out.print("\nEnter message for server : ");
            }
        }
        catch(IOException obj)
        {}
    }
        
    protected void finalize()
    {
        System.out.println("Inside finalize of Client");
        try
        {
            s.close();
            brS.close();
            brK.close();
            ps.close();
        }
        catch(IOException obj)
        {}
    }
}

// command to create '.class' file inside the package 'Messenger' inside your current directory :
// javac MyClient.java -d .
// -d : directory
// . : current directory
