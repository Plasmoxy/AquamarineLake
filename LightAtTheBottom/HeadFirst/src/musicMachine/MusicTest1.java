package musicMachine;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class MusicTest1 {
	
	public void play()
	{
		try {
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			
			Track track = seq.createTrack();
			
			int j = 1;
			for ( int i = 20; i<=100; i+=2)
			{
				ShortMessage a = new ShortMessage();
				a.setMessage(144,1,i,100);
				MidiEvent noteOn = new MidiEvent(a, j);
				track.add(noteOn);
				j++;
			}
			
			/*
			ShortMessage b = new ShortMessage();
			b.setMessage(144,1,47,100);
			MidiEvent noteOff = new MidiEvent(b, 1);
			track.add(noteOff);*/
			
			player.setTempoInBPM(180);
			player.setSequence(seq);
			player.start();
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args)
	{
		MusicTest1 mt = new MusicTest1();
		mt.play();
	}

}
