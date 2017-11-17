package networking;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DerServer
{
    public void start()
    {
        try {
            ServerSocket serverSock = new ServerSocket(4242);
            
            while(true) {
                Socket sock = serverSock.accept();
                System.out.println("["+sock.getInetAddress()+"]");
                
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                double rand = Math.random();
                writer.println(rand);
                System.out.println(">> " + Double.toString(rand));
                writer.close();
                System.out.println("---");
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        DerServer server = new DerServer();
        server.start();
    }
}
