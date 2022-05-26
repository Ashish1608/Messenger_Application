package Messenger;

// import java.lang.*;
import java.net.*;
import java.io.*;

public final class MyServer 
{
    public String s1, s2;
    public ServerSocket ss;
    public Socket s;
    public BufferedReader brS, brK;
    public PrintStream ps;

    public MyServer() 
    {
        this.s1 = null;
        this.s2 = null;

        try 
        {
            this.ss = new ServerSocket(1100);       // create new socket on particular port on server
            this.s = ss.accept();                   // accept the request from client for connection on this port

            System.out.println("Connection established successfully\n");

            this.brK = new BufferedReader(new InputStreamReader(System.in));            // read through keyboard
            this.brS = new BufferedReader(new InputStreamReader(s.getInputStream()));   // read through socket
            this.ps = new PrintStream(s.getOutputStream());                             // send the message through socket
        } 
        catch (IOException obj) 
        {}
    }

    public void communicate() 
    {
        try 
        {
            while ((s1 = brS.readLine()) != null) 
            {
                System.out.println("Client says : " + s1);
                System.out.print("\nEnter message for client : ");
                s2 = brK.readLine();
                ps.println(s2);
            }
        } catch (IOException obj) 
        {}
    }

    protected void finalize() 
    {
        System.out.println("Inside finalize of Server");

        try 
        {
            s.close();
            ss.close();
            brS.close();
            brK.close();
            ps.close();
        } catch (IOException obj) 
        {}
    }

}

// command to create '.class' file inside the package 'Messenger' :
// javac MyServer.java -d .
// -d : directory
// . : current directory

