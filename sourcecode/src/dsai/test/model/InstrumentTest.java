package dsai.test.model;

import javax.sound.midi.MidiUnavailableException;

import dsai.piano.model.VirtualPianoVer2;
import dsai.piano.model.component.PianoNote;
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
		VirtualPianoVer2 piano = new VirtualPianoVer2(80);
		piano.changeInstrument(new Violin().getInstrumentId());
		PianoNote note = new PianoNote("D#4h");
		piano.startNote(note);
		
	}
}
