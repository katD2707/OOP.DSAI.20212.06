package dsai.test.model;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

import dsai.piano.model.Octave;
import dsai.piano.model.Pitch;
import dsai.piano.model.Playable;
import dsai.piano.model.Volume;
import dsai.piano.model.pianoNote;

public class pianoNoteTest {
	public static void main(String[] args) {
		pianoNote noteC = new pianoNote("C2");
		System.out.println(noteC.toString());
		noteC.setValue((byte) 12);
		System.out.println(noteC.toString());
		noteC.changeValue(11);
		System.out.println(noteC.toString());
		
		noteC.setOriginalString("C#3");

		System.out.println(noteC.toString());
		System.out.println(noteC.getOctave());
		new Player().play(noteC);
		System.out.println(noteC.toString());
		
		noteC.setOriginalString("C#7");
		new Player().play(noteC);
		System.out.println(noteC.getOctave());
		noteC.geto
		new Player().play(new Pattern("C#7 C#3"));
	}
}
