package perc;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    
    public static void main(String[] args) throws Exception{
    
        ServerSocket ss=new ServerSocket(8999 , 35);
        System.out.println("Server suru zhala!");
        int i = 1 ;
        while(i<21)
        {
        
            Socket s=ss.accept();
            System.out.println(i + " users connnected");
            new Cthread(s).start();
            i++;
        
        }
    
    }    

}
