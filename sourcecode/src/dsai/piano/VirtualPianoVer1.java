package dsai.piano;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dsai.piano.model.PianoVer1;

public class VirtualPianoVer1 extends JFrame {
	private PianoVer1 piano;
	private Map<String, JButton> map;
	
	public void BuildGUI() throws MidiUnavailableException{
		this.piano = new PianoVer1();
		this.map = new HashMap<String, JButton>();
		piano.getPlayer().changeInstrument(40);
		
		
		this.setLayout(new GridLayout(3, 1));
		
		JPanel panel = new JPanel(new GridLayout(2, 1));
		
		this.add(panel);
		this.setSize(600, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		for (int i = 0; i< 12; i++) {
			String keyStr = this.piano.getPianoNotes().get(i).getKeyChar();
			JButton btn = new JButton(this.piano.getPianoNotes().get(i).getOriginalString());
			map.put(keyStr, btn);
			panel.add(btn);
			btn.setFocusable(false);
			btn.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					piano.getPlayer().stopNote(piano.getNotesMap().get(keyStr));
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					piano.getPlayer().startNote(piano.getNotesMap().get(keyStr));
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		
		JPanel panel1 = new JPanel(new GridLayout(2,1));
		JPanel panel10 = new JPanel(new FlowLayout());
		panel1.add(panel10);
		JButton deVolBtn = new JButton("-");
		deVolBtn.setFocusable(false);
		JLabel lblVol = new JLabel("Volume: 50");
		JButton inVolBtn = new JButton("+");
		inVolBtn.setFocusable(false);
		panel10.add(deVolBtn);
		panel10.add(lblVol);
		panel10.add(inVolBtn);
		
		
		inVolBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				piano.getVolume().increaseVolume();
				piano.setVolume();
				lblVol.setText("Volume: " + piano.getVolume().getValue());
			}
		});
		deVolBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				piano.getVolume().decreaseVolume();
				piano.setVolume();
				lblVol.setText("Volume: " + piano.getVolume().getValue());
			}
		});
		this.add(panel1);
		
		JPanel panel11 = new JPanel(new FlowLayout());
		panel1.add(panel11);
		
		JButton deOctBtn = new JButton("-");
		deOctBtn.setFocusable(false);
		JButton inOctBtn = new JButton("+");
		inOctBtn.setFocusable(false);
		JLabel lblOct = new JLabel("Octave: " + piano.getOctave());
		panel11.add(deOctBtn);
		panel11.add(lblOct);
		panel11.add(inOctBtn);
		
		deOctBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				piano.decreaseOctave();
				lblOct.setText("Octave: " + piano.getOctave());
			}
		});
		inOctBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				piano.increaseOctave();
				lblOct.setText("Octave: " + piano.getOctave());
			}
		});
		
		
		
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if ("ASDFGHJTYUWE".contains(("" + e.getKeyChar()))){
					piano.enableKeys[piano.getPianoNotes().indexOf(piano.getNotesMap().get("" + e.getKeyChar()))] = true;
					// stop node
					piano.getPlayer().stopNote(piano.getNotesMap().get("" + e.getKeyChar()));
					
					
					map.get("" + e.getKeyChar()).setText(piano.getNotesMap().get("" + e.getKeyChar()).originalString);
					map.get("" + e.getKeyChar()).setForeground(Color.BLACK);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if ("ASDFGHJTYUWE".contains(("" + e.getKeyChar()))){
					boolean playable = piano.enableKeys[piano.getPianoNotes().indexOf(piano.getNotesMap().get("" + e.getKeyChar()))] ;
					if (playable) {
						piano.enableKeys[piano.getPianoNotes().indexOf(piano.getNotesMap().get("" + e.getKeyChar()))] = false;
								piano.getPlayer().startNote(piano.getNotesMap().get("" + e.getKeyChar()));
								map.get("" + e.getKeyChar()).setText("O");
								map.get("" + e.getKeyChar()).setForeground(Color.GREEN);
					}
				}  else if (("" + e.getKeyChar()).equals("-")) {
					deVolBtn.doClick();
				} else if (("" + e.getKeyChar()).equals("+")) {
					inVolBtn.doClick();
				} else if (("" + e.getKeyChar()).equals("[")) {
					deOctBtn.doClick();
				} else if (("" + e.getKeyChar()).equals("]")) {
					inOctBtn.doClick();
				} else {
					System.out.println(e.getKeyChar());
				}
			}
		});
		JPanel panel3 = new JPanel(new GridLayout(2, 1));
		
		JLabel guideline = new JLabel("Turn on Caplocks to play (A-S-D-F-G-H-J W-E T-Y-U)");
		JLabel guideline2 = new JLabel("Change octave while pressing button or keyboard occurs non-stop note playing");
		panel3.add(guideline);
		panel3.add(guideline2);
		this.add(panel3);
		this.setVisible(true);
		
		
		
	}
	public static void main(String[] args) throws MidiUnavailableException {
		new VirtualPianoVer1().BuildGUI();
	}
}
