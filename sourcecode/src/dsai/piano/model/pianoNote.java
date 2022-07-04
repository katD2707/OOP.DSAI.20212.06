package dsai.piano.model;

import org.jfugue.theory.Note;

public class pianoNote extends Note implements Playable {
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
	
	
	
	@Override
	public void play() {
		// TODO Auto-generated method stub
	}
	public static void main(String[] args) {
		pianoNote note = new pianoNote("D#3");
//		System.out.println(note.getValue());
//		System.out.println();
		note.setValue((byte) 72);
//		System.out.println(note.getOctave());
		
		pianoNote note2 = new pianoNote("C#9");
		System.out.println(note2.getOctave());
//		System.out.println(note2.increaseOctave());
		note2.increaseOctave();
		System.out.println(note2.getOctave());
		System.out.println(note2.getValue());
		
	}
}
