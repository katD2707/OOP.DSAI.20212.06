package dsai.test.model.instrument;

import javax.sound.midi.MidiUnavailableException;

import dsai.piano.model.piano2;
import dsai.piano.model.component.pianoNote;
import dsai.piano.model.instrument.Flute;
import dsai.piano.model.instrument.Instrument;
import dsai.piano.model.instrument.Violin;

public class InstrumentTest {
	public static void main(String args[]) throws MidiUnavailableException {
		Instrument my_flute = new Flute("My flute");
		Instrument my_dad_violin = new Violin("My father violin");
		
		System.out.println("My dad violin: " + my_dad_violin.getInstrument());
		System.out.println(my_dad_violin.getName());
		System.out.println(my_flute.toString());
		piano2 piano = new piano2(80);
		piano.changeInstrument(new Violin().getInstrumentId());
		pianoNote note = new pianoNote("D#4h");
		piano.startNote(note);
		
	}
}
