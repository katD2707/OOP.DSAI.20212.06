package dsai.piano;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.JFrame;

import dsai.piano.model.Piano;

public class Main extends JFrame  {
	private Piano piano;
	
	public void BuildGUI() throws MidiUnavailableException {
		this.piano.setUpPiano();
		
	}
}
