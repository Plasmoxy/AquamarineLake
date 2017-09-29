package shepardTone;


/*
 * Plasmoxy 2017
 * 
 * Simple midi sequence extension that takes an array with tracks which have
 * arrays with notes inside. Meant to be used polymorphicaly.
 */
import java.util.ArrayList;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class SimpleArraySequence extends Sequence
{
	
	public ArrayList<Track> tracks;
	
	private int noteOnTicks = 4;
	private int velocity = 100;
	private int channel = 1;
	private final int noteOnMidiMessage = 144;
	private final int noteOffMidiMessage = 128;
	
	public SimpleArraySequence(int[][] notes) throws InvalidMidiDataException
	{
		super(PPQ, 4);
		
		tracks = new ArrayList<Track>();
		
		for (int[] trackNotes : notes)
		{
			Track track = createTrack();
			
			// notei = current note index
			for (int notei = 0; notei < trackNotes.length ; notei++)
			{
				if (trackNotes[notei] == -1) continue;
				
				ShortMessage noteonmsg = new ShortMessage();
				ShortMessage noteoffmsg = new ShortMessage();
				noteonmsg.setMessage(noteOnMidiMessage, channel, trackNotes[notei], velocity);
				noteoffmsg.setMessage(noteOffMidiMessage, channel, trackNotes[notei], velocity);
				
				MidiEvent noteon = new MidiEvent(noteonmsg, notei);
				MidiEvent noteoff = new MidiEvent(noteoffmsg, notei+noteOnTicks);
				
				track.add(noteon);
				track.add(noteoff);
				
			}
		}
		
	}

}
