// import java.lang.*;
// import java.net.*;
// import java.io.*;
import Messenger.MyClient;

class ClientMain
{
    public static void main(String arg[]) throws Exception
    {
        System.out.println("\nClient application is running....\n");

        MyClient cObj = new MyClient();
        cObj.communicate();
        
        cObj = null;

        System.gc();

        System.out.println("\nEnd of Client main");
    }
}


