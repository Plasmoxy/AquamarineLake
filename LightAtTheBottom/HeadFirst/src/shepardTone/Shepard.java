package shepardTone;

public class Shepard
{
	
	
	
	public static void main(String[] args)
	throws Exception
	{
		int[][] notes = new int[1][101];
		for ( int i = 60; i<= 100; i++)
		{
			notes[0][i] = i;
		}
		SimpleArraySequence aseq = new SimpleArraySequence(notes);
		MidiPlayer plr = new MidiPlayer(aseq, 100);
		
		plr.play();
	}
	
}
