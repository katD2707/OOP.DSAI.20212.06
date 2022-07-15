package draft.view;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.JFrame;

import dsai.piano.model.PianoVer1;

public class Main extends JFrame  {
	private PianoVer1 piano;
	
	public void BuildGUI() throws MidiUnavailableException {
		this.piano.setUpPiano();
		
	}
}
