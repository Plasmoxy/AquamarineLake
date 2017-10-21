package SebuLinkTEST;

import java.util.*;
import java.io.*;

public class FileLinkedList extends LinkedList<String>
{
	
	public FileLinkedList(String fileName) throws IOException
	{
		
		File file = new File(fileName);
		Scanner sc = new Scanner(new FileInputStream(file));
		while(sc.hasNextLine())
		{
			this.add(sc.nextLine());
		}
	}
	
}