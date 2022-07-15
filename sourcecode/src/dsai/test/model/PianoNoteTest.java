package dsai.test.model;

import java.util.concurrent.TimeUnit;

import javax.sound.midi.MidiUnavailableException;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

import dsai.piano.model.VirtualPianoVer2;
import dsai.piano.model.component.PianoNote;

public class PianoNoteTest {
	public static void main(String[] args) throws MidiUnavailableException, InterruptedException {
//		pianoNote noteC = new pianoNote("C2");
//		System.out.println(noteC.toString());
//		noteC.setValue((byte) 12);
//		System.out.println(noteC.toString());
//		noteC.changeValue(11);
//		System.out.println(noteC.toString());
//		
//		noteC.setOriginalString("C#3");
//
//		System.out.println(noteC.toString());
//		System.out.println(noteC.getOctave());
//		new Player().play(noteC);
//		System.out.println(noteC.toString());
//		
//		noteC.setOriginalString("C#7");
//		new Player().play(noteC);
//		System.out.println(noteC.getOctave());
////		noteC.geto
//		new Player().play(new Pattern("C#7 C#3"));
//		
		
		
		// setOctave() method 
		PianoNote noteD = new PianoNote("C#4");
		VirtualPianoVer2 piano = new VirtualPianoVer2(80);
		piano.startNote(noteD);

		System.out.println(noteD.getValue());
		TimeUnit.SECONDS.sleep(1);
		
		
		noteD.setOctave(4);
		piano.startNote(noteD);
		System.out.println(noteD.getValue());
		TimeUnit.SECONDS.sleep(1);
		
		
		noteD.setOctave(5);
		piano.startNote(noteD);

		System.out.println(noteD.getValue());
		TimeUnit.SECONDS.sleep(1);
		
	}
}
