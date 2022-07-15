package dsai.piano.model.component;
import javax.sound.midi.MidiUnavailableException;

import org.jfugue.realtime.RealtimePlayer;
import org.jfugue.theory.Note;

public class PianoNote extends Note {
	private String keyChar;
	private final int id;

	public PianoNote() {
		super();
		this.id = -1;
	}
	
	public PianoNote(String note) {
		super(note);
		this.id = -1;
	}
	
	public PianoNote(String note, String keyChar) {
		super(note);
		this.keyChar = keyChar;
		this.id = -1;
	}
	
	public PianoNote(String note, int id) {
		super(note);
		this.id = id;
	}
	public PianoNote(String note, int id, String keyChar, int octave) {
		super(note);
		this.id = id;
		this.keyChar = keyChar;
		this.setOctave(octave);
	}
	public PianoNote(String note, int id, String keyChar) {
		super(note);
		this.id = id;
		this.keyChar = keyChar;
	}
	

	public int getId() {
		return this.id;
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
	public static void main(String[] args) throws MidiUnavailableException {
		PianoNote note = new PianoNote("D#3");
//		System.out.println(note.getValue());
//		System.out.println();
		note.setValue((byte) 72);
		System.out.println(note.getOctave());
		
		PianoNote note2 = new PianoNote("C#2");
		System.out.println(note2.getOctave());
//		System.out.println(note2.increaseOctave());
		note2.increaseOctave();
		System.out.println(note2.getOctave());
		System.out.println(note2.getValue());
		RealtimePlayer player = new RealtimePlayer();
		player.startNote(note2);
		System.out.println(( ((int)(byte)49) % 12 + 12 * 4));
		player.close();
		System.out.println(note2.getOriginalString());
	}
}
