package bullshit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class HugeFactorial
{
    public static void main(String[] args) throws IOException
    {
        FileWriter fw = new FileWriter(new File("factorial.txt"));
        
        int n = 1000000;
        
        String strn = String.valueOf(n);
        BigInteger a = new BigInteger("1");
        BigInteger t = new BigInteger(strn);
        
        while (t.compareTo(BigInteger.ZERO) == 1)
        {
            System.out.println(t.toString());
            //System.out.printf("n=%s a=%s\n", strn, a.toString());
            a = a.multiply(t);
            t = t.subtract(BigInteger.ONE);
            //try {Thread.sleep(100); } catch(Exception e) {}
        }

        String parsedStr = a.toString().replaceAll("(.{180})", "$1\n");
        
        fw.write(parsedStr);
        fw.close();

        System.out.println(parsedStr);

        System.out.println(strn + "! complete, wrote to file.");
        
    }
}
