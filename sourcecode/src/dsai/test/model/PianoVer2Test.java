package dsai.test.model;

import javax.sound.midi.MidiUnavailableException;

import java.util.Scanner;

import dsai.piano.model.VirtualPianoVer2;
import dsai.piano.model.component.PianoNote;
import dsai.piano.model.instrument.Violin;

public class PianoVer2Test {
	public static void main(String[] args) throws MidiUnavailableException {
		VirtualPianoVer2 piano = new VirtualPianoVer2();
		
		
		// Test volume
		System.out.println("piano volume: " + piano.getVolume());

		// Increase volume
		piano.increaseVolume();
		System.out.println("piano volume after increasing: " + piano.getVolume());

		piano.setVolume(30);
		piano.decreaseVolume();
		System.out.println("before: 30\npiano volume after decreasing: " + piano.getVolume());



		
		// Test play sound
		piano.setVolume(80);

		Scanner scanner = new Scanner(System.in);
		boolean next = true;
		piano.changeInstrument(new Violin().getInstrumentId());
//		piano.chan
//		piano.startNote(note);
		
		System.out.println("Start");
		while (next) {
			String key = scanner.nextLine();
//			piano.stopNote(piano.getNotesMap().get(key.toUpperCase()));
			if (key.equals("stop")) {
				next = false;
			} else {
				key = scanner.nextLine();
				System.out.println(key.toUpperCase());
				System.out.println("note: " + piano.getNotesMap().get(key.toUpperCase()));
				piano.startNote(piano.getNotesMap().get(key.toUpperCase()));
				System.out.println("Continue: ? ");
			}
		}
		scanner.close();
		
		// Test change octave method
		PianoNote note = new PianoNote("D#4");
		
		// Test change instrument
		piano = new VirtualPianoVer2(80);
	}
}
