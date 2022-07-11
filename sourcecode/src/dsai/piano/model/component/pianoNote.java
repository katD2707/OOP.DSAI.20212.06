package dsai.piano.model.component;

import javax.sound.midi.MidiUnavailableException;

import org.jfugue.realtime.RealtimePlayer;
import org.jfugue.theory.Note;

public class pianoNote extends Note {
	private String keyChar;
	
	public pianoNote() {
		super();
	}
	
	public pianoNote(String note) {
		super(note);
	}
	
	public pianoNote(String note, String keyChar) {
		super(note);
		this.keyChar = keyChar;
	}
	
//	public void setVolume(Volume volume) {
//		this.volume = volume;
//	}
	
//	public void setOctave(Octave octave) {
//		this.octave = octave;
//	}

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
	
//	@Override
//	public void play() {
//		// TODO Auto-generated method stub
//	}
	public static void main(String[] args) throws MidiUnavailableException {
		pianoNote note = new pianoNote("D#3");
//		System.out.println(note.getValue());
//		System.out.println();
		note.setValue((byte) 72);
//		System.out.println(note.getOctave());
		
		pianoNote note2 = new pianoNote("C#2");
		System.out.println(note2.getOctave());
//		System.out.println(note2.increaseOctave());
		note2.increaseOctave();
		System.out.println(note2.getOctave());
		System.out.println(note2.getValue());
		RealtimePlayer player = new RealtimePlayer();
		player.startNote(note2);
		System.out.println(( ((int)(byte)49) % 12 + 12 * 4));
		
	}
}
