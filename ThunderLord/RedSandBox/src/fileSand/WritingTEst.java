package fileSand;

import java.io.*;

public class WritingTEst
{

    public static void main(String[] args) throws IOException
    {
        File file = new File("XD.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        
        String line = null;
        while (( line = reader.readLine() ) != null )
        {
            System.out.println(line);
        }
        
        reader.close();
        
    }
}
