// import java.lang.*;
// import java.net.*;
// import java.io.*;
import Messenger.MyServer;

class ServerMain
{
    public static void main(String arg[]) throws Exception
    {
        System.out.println("\nServer application is running....\n");
        
        MyServer sObj = new MyServer();
        sObj.communicate();

        sObj = null;

        System.gc();

        System.out.println("\nEnd of Server main");
    }
}


