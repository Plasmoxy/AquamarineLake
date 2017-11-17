package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DerClient
{
    public void get()
    {
        try {
            Socket s = new Socket("localhost", 4242);

            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            System.out.println(reader.readLine());
            reader.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        DerClient client = new DerClient();
        client.get();
    }
}
