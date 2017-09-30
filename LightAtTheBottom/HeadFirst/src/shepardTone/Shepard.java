package shepardTone;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Shepard
{
	
	static String readFile(String path) throws IOException 
	{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, StandardCharsets.UTF_8);
	}
	
	public static void main(String[] args)
	throws Exception
	{
		
		String notesSource = readFile("notes.txt");
		
		int[][] notes = NoteParser.niceParse(notesSource);
		
		SimpleArraySequence seq = new SimpleArraySequence(notes);
		MidiPlayer player = new MidiPlayer(seq, 80);
		
		player.play();
		
	}
	
}
