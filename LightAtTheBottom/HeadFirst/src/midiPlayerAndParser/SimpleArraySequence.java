package midiPlayerAndParser;


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
	
	private int noteOnLength = 4;
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
			tracks.add(track);
			
			// notei = current note index
			for (int notei = 0; notei < trackNotes.length ; notei++)
			{
				if (trackNotes[notei] == -1) continue;
				
				ShortMessage noteonmsg = new ShortMessage();
				ShortMessage noteoffmsg = new ShortMessage();
				noteonmsg.setMessage(noteOnMidiMessage, channel, trackNotes[notei], velocity);
				noteoffmsg.setMessage(noteOffMidiMessage, channel, trackNotes[notei], velocity);
				
				MidiEvent noteon = new MidiEvent(noteonmsg, notei);
				MidiEvent noteoff = new MidiEvent(noteoffmsg, notei+noteOnLength);
				
				track.add(noteon);
				track.add(noteoff);
				
			}
		}
		
	}
	
	public SimpleArraySequence(int[][] notes, int noteDuration) throws InvalidMidiDataException
	{
		this(notes);
		this.noteOnLength = noteDuration;
	}
	
	public SimpleArraySequence(int[][] notes, int noteDuration, int velocity) throws InvalidMidiDataException
	{
		this(notes);
		this.noteOnLength = noteDuration;
		this.velocity = velocity;
	}
	
	public SimpleArraySequence(int[][] notes, int noteDuration, int velocity, int channel) throws InvalidMidiDataException
	{
		this(notes);
		this.noteOnLength = noteDuration;
		this.velocity = velocity;
		this.channel = channel;
	}
	

}
