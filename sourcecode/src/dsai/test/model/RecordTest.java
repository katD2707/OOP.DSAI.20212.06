package dsai.test.model;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dsai.piano.model.VirtualPianoVer2;
import dsai.piano.model.component.PianoNote;
import dsai.piano.model.instrument.Flute;
import dsai.piano.model.instrument.Guitar;
import dsai.piano.model.instrument.Piano;
import dsai.piano.model.instrument.Trumpet;
import dsai.piano.model.instrument.Violin;
import dsai.piano.model.record.Record;

public class RecordTest extends JFrame {
	private VirtualPianoVer2 piano;;
	private Record rec1 = new Record("C C#7 D G# D#6");
	public RecordTest() throws MidiUnavailableException {
		piano = new VirtualPianoVer2(80);
		JPanel panel = new JPanel(new GridLayout(2, 1));
		JButton btn1 = new JButton("Start");
		JButton btn2 = new JButton("Stop");
		panel.add(btn2);
		panel.add(btn1);
//		piano.setInstrument(new Flute());;
		this.add(panel);
		btn1.addKeyListener(new KeyListener() {
			PianoNote a = new PianoNote("C3");
			boolean play = true;
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("release");
				System.out.println(e.getKeyChar());
				System.out.println(e.getSource().toString());
				if ((e.getKeyChar() == 'a') && (play== false)) {
					piano.stopNote(a);
					play = true;
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("press");
				if ((e.getKeyChar() == 'a') && (play == true)) {
					System.out.println("a");
					piano.startNote(a);
					play = false;
				}
			}
		});
		this.setSize(600, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public static void main(String[] args) throws MidiUnavailableException, InterruptedException {
//		// TODO Auto-generated method stub
		VirtualPianoVer2 piano = new VirtualPianoVer2(80);
		Record rec1 = new Record("C C#7 D G# D#6");
		Record rec2 = new Record("E B#7 D3 B  D#6");
		piano.setInstrument(new Flute());
		System.out.println(piano.getInstrument());

		PianoNote note = new PianoNote("C#4");
		note.setOctave(5);
		
		piano.addRecord(rec1);
		piano.addRecord(rec2);
		rec1.setName("record 1");
		rec1.addContent("C3 A4");
		
		piano.setInstrument(new Violin());  			// violin dont stop

		piano.setInstrument(new Flute());  				// flute dont stop

		piano.setInstrument(new Trumpet());  			// trumpet dont stop

		piano.setInstrument(new Guitar());  			// guitar DO stop
		
		piano.setInstrument(new Piano());  
//		piano.play(0);
		
		
		System.out.println(rec1.toString());

//		TimeUnit.SECONDS.sleep(1);
		piano.startNote(note);
		TimeUnit.SECONDS.sleep(4);
		piano.close();
		
	}

}
