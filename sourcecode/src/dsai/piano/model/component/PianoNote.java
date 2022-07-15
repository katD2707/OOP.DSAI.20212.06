package dsai.piano.model.component;
import javax.sound.midi.MidiUnavailableException;

import org.jfugue.realtime.RealtimePlayer;
import org.jfugue.theory.Note;

public class PianoNote extends Note {
	private String keyChar;
	private final int ID;

	public PianoNote() {
		super();
		this.ID = -1;
	}
	
	public PianoNote(String note) {
		super(note);
		this.ID = -1;
	}
	
	public PianoNote(String note, String keyChar) {
		super(note);
		this.keyChar = keyChar;
		this.ID = -1;
	}
	
	public PianoNote(String note, int ID) {
		super(note);
		this.ID = ID;
	}
	public PianoNote(String note, int ID, String keyChar, int octave) {
		super(note);
		this.ID = ID;
		this.keyChar = keyChar;
		this.setOctave(octave);
	}
	public PianoNote(String note, int ID, String keyChar) {
		super(note);
		this.ID = ID;
		this.keyChar = keyChar;
	}
	

	public int getId() {
		return this.ID;
	}
	
	public String getKeyChar() {
		return this.keyChar;
	}
	
	public void setOctave(int i) {
		if (i > 0 && i < 10) {
			this.setValue( (byte) ((byte) (this.getValue()) % 12 + i * 12));
		}
	}
	public void increaseOctave() {
		if (this.getOctave() < 9) {
			this.changeValue(12);
		}
	}
	public void decreaseOctave() {
		if (this.getOctave() > 0) {
			this.changeValue(-12);
		} 
	}
	
	public String toString() {
		return "Piano Note: " + this.getOriginalString() + ", Key String: " + this.getKeyChar();
	}
	
	@Override
	public String getOriginalString() {
		return super.getOriginalString().replaceAll("[0-9]+", "") + this.getOctave();
	}
	
}
