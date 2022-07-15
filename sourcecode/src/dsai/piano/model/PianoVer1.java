package dsai.piano.model;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import org.jfugue.realtime.RealtimePlayer;

import dsai.piano.model.component.Volume;
import dsai.piano.model.component.PianoNote;

public class PianoVer1  {
	private Volume volume;
	private Map<String, PianoNote> notesMap;
	private ArrayList<PianoNote> PianoNotes;
	private RealtimePlayer player;
	public boolean[] enableKeys;
	public PianoVer1() throws MidiUnavailableException {
		super();
		this.player = new RealtimePlayer();
		this.setUpPiano();
	}
	
	
	public Volume getVolume() {
		return volume;
	}


	public Map<String, PianoNote> getNotesMap() {
		return notesMap;
	}


	public ArrayList<PianoNote> getPianoNotes() {
		return PianoNotes;
	}


	public void setVolume() {
		this.getPlayer().changeController((byte) 7, this.volume.getCoarseVolume());
		this.getPlayer().changeController((byte) 39, this.volume.getFineVolume());
	}
	
	
	public void addPianoNote(PianoNote note) {
		this.PianoNotes.add(note);
		this.notesMap.put(note.getKeyChar(), note);
	}
	
	
	public void increaseOctave() {
		for (PianoNote note: PianoNotes) {
			note.increaseOctave();
		}
	}
	
	public void decreaseOctave() {
		for (PianoNote note: PianoNotes) {
			note.decreaseOctave();
		}
	}
	public byte getOctave() {
		return this.PianoNotes.get(0).getOctave();
	}
	
	public void setUpPiano() {
		this.volume = new Volume();
		this.PianoNotes = new ArrayList<PianoNote>();
		this.notesMap = new HashMap<String, PianoNote>();
			
		PianoNote noteC = new PianoNote("C", "A");
		this.addPianoNote(noteC);
		PianoNote noteCD = new PianoNote("C#", "W");
		this.addPianoNote(noteCD);
		PianoNote noteD = new PianoNote("D", "S");
		this.addPianoNote(noteD);
		PianoNote noteDE = new PianoNote("D#", "E");
		this.addPianoNote(noteDE);
		PianoNote noteE = new PianoNote("E", "D");
		this.addPianoNote(noteE);
		PianoNote noteF = new PianoNote("F", "F");
		this.addPianoNote(noteF);
		PianoNote noteFG = new PianoNote("F#", "T");
		this.addPianoNote(noteFG);
		PianoNote noteG = new PianoNote("G", "G");
		this.addPianoNote(noteG);
		PianoNote noteGA = new PianoNote("G#", "Y");
		this.addPianoNote(noteGA);
		PianoNote noteA = new PianoNote("A", "H");
		this.addPianoNote(noteA);
		PianoNote noteAB = new PianoNote("A#", "U");
		this.addPianoNote(noteAB);
		PianoNote noteB = new PianoNote("B", "J");
		this.addPianoNote(noteB);
	
		enableKeys = new boolean[12];
		for (int i = 0; i < 12; i++) {
			enableKeys[i] = true;
		}
	}
	
	public void close() {
		this.getPlayer().close();
	}
	
//	public void buildGui2() throws MidiUnavailableException{
//		this.player = new RealtimePlayer();
//		Map<String, pianoNote> keysMap = new HashMap<String, pianoNote>();
//		boolean[] enableKeys = new boolean[12];
//		
//		ArrayList<pianoNote> pianoNotes = new ArrayList<pianoNote>();
//		
//		pianoNote noteC = new pianoNote("C", "a");
//		pianoNote noteCD = new pianoNote("C#", "w");
//		pianoNote noteD = new pianoNote("D", "s");
//		pianoNote noteDE = new pianoNote("D#", "e");
//		pianoNote noteE = new pianoNote("E", "d");
//		pianoNote noteF = new pianoNote("F", "f");
//		pianoNote noteFG = new pianoNote("F#", "t");
//		pianoNote noteG = new pianoNote("G", "g");
//		pianoNote noteGA = new pianoNote("G#", "y");
//		pianoNote noteA = new pianoNote("A", "h");
//		pianoNote noteAB = new pianoNote("A#", "u");
//		pianoNote noteB = new pianoNote("B", "j");
//		
//		
//		pianoNotes.add(noteC);
//		pianoNotes.add(noteCD);
//		pianoNotes.add(noteD);
//		pianoNotes.add(noteDE);
//		pianoNotes.add(noteE);
//		pianoNotes.add(noteF);
//		pianoNotes.add(noteFG);
//		pianoNotes.add(noteG);
//		pianoNotes.add(noteGA);
//		pianoNotes.add(noteA);
//		pianoNotes.add(noteAB);
//		pianoNotes.add(noteB);
//		
//		for (pianoNote note: pianoNotes) {
//			keysMap.put(note.getKeyChar(), note);
//		}
//		
//		
//		JFrame frame = new JFrame("key buttons");
//		frame.addKeyListener(new KeyListener() {
//			
//			@Override
//			public void keyTyped(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void keyReleased(KeyEvent e) {
//				// TODO Auto-generated method stub
////				player.stopNote(keysMap.get("" + e.getKeyChar()));
//				enableKeys[pianoNotes.indexOf(keysMap.get("" + e.getKeyChar()))] = true;
//			}
//			
//			@Override
//			public void keyPressed(KeyEvent e) {
//				// TODO Auto-generated method stub
//				boolean abc = enableKeys[pianoNotes.indexOf(keysMap.get("" + e.getKeyChar()))];
//				if (abc && "asdfghjweyut".contains(("" + e.getKeyChar()))) {
//					getPlayer().startNote(keysMap.get("" + e.getKeyChar()));
//					enableKeys[pianoNotes.indexOf(keysMap.get("" + e.getKeyChar()))] = false;
////					playable = false;
//				}
//			}
//		});
//		frame.setSize(600,300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setLayout(new GridLayout());
//		frame.setVisible(true);
//		
//		
//		
//	}
//	public void buildGui() throws MidiUnavailableException {
//		this.player = new RealtimePlayer();
//		
//		pianoNote noteC = new pianoNote("C", "A");
//		pianoNote noteCD = new pianoNote("C#", "W");
//		pianoNote noteD = new pianoNote("D", "S");
//		pianoNote noteDE = new pianoNote("D#", "E");
//		pianoNote noteE = new pianoNote("E", "D");
//		pianoNote noteF = new pianoNote("F", "F");
//		pianoNote noteFG = new pianoNote("F#", "T");
//		pianoNote noteG = new pianoNote("G", "G");
//		pianoNote noteGA = new pianoNote("G#", "Y");
//		pianoNote noteA = new pianoNote("A", "H");
//		pianoNote noteAB = new pianoNote("A#", "U");
//		pianoNote noteB = new pianoNote("B", "J");
//		
//		JFrame frame = new JFrame("key buttons");
//        JPanel panel = new JPanel(new GridLayout());
////        for (pianoNote note: this.pianoNotes) {
//////			note.setOctave(octave);
//////			note.setVolume(volume);
////        	
////		} 
//        ArrayList<JButton> lis = new ArrayList<JButton>();
//        JButton a = new JButton("C");
//        JButton s = new JButton("D");
//        JButton d = new JButton("E");
//        JButton f = new JButton("F");
//        JButton g = new JButton("G");
//        JButton h = new JButton("A");
//        JButton j = new JButton("B");
//        JButton w = new JButton("C#");
//        JButton e = new JButton("D#");
//        JButton t = new JButton("F#");
//        JButton y = new JButton("G#");
//        JButton u = new JButton("A#");
//        
//        lis.add(a);
//        lis.add(w);
//        lis.add(s);
//        lis.add(e);
//        lis.add(d);
//        lis.add(f);
//        lis.add(t);
//        lis.add(g);
//        lis.add(y);
//        lis.add(h);
//        lis.add(u);
//        lis.add(j);
//        
//        a.addActionListener(evt -> { this.getPlayer().startNote(noteC);});
//        s.addActionListener(evt -> { this.getPlayer().startNote(noteD);});
//        d.addActionListener(evt -> { this.getPlayer().startNote(noteE);});
//        f.addActionListener(evt -> { this.getPlayer().startNote(noteF);});
//        g.addActionListener(evt -> { this.getPlayer().startNote(noteG);});
//        h.addActionListener(evt -> { this.getPlayer().startNote(noteA);});
//        j.addActionListener(evt -> { this.getPlayer().startNote(noteB);});
//        w.addActionListener(evt -> { this.getPlayer().startNote(noteCD);});
//        e.addActionListener(evt -> { this.getPlayer().startNote(noteDE);});
//        t.addActionListener(evt -> { this.getPlayer().startNote(noteFG);});
//        y.addActionListener(evt -> { this.getPlayer().startNote(noteGA);});
//        u.addActionListener(evt -> { this.getPlayer().startNote(noteAB);});
//        
//        for (JButton btn: lis) {
//        	panel.add(btn);
//        	btn.setFocusable(false);
//        }
//        frame.setContentPane(panel);
//        frame.setVisible(true);
//        frame.pack();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        
//        KeyStroke us = KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false);
//        panel.getInputMap().put(us, "A");
//        panel.getActionMap().put("A", new AbstractAction(){
//            @Override
//            public void actionPerformed(ActionEvent evt){
//               a.doClick();
//            }
//        });
//        KeyStroke us1 = KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false);
//        panel.getInputMap().put(us1, "S");
//        panel.getActionMap().put("S", new AbstractAction(){
//            @Override
//            public void actionPerformed(ActionEvent evt){
//               s.doClick();
//            }
//        });
//        KeyStroke us2 = KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false);
//        panel.getInputMap().put(us, "D");
//        panel.getActionMap().put("D", new AbstractAction(){
//            @Override
//            public void actionPerformed(ActionEvent evt){
//               d.doClick();
//            }
//        });
//        
//	}
//	
//	public static void main(String[] args) throws MidiUnavailableException  {
//		Piano piano = new Piano();
//		System.out.println(piano.getPianoNotes().size());
//		pianoNote note = piano.getPianoNotes().get(3);
//		String noteChar = note.getKeyChar();
//		System.out.println(piano.getNotesMap().get(noteChar).getValue());
//		piano.getPianoNotes().get(3).changeValue(12);
//		System.out.println(piano.getNotesMap().get(noteChar).getValue());
//		System.out.println(piano.getPianoNotes().get(3).getValue());
//		
//	}


	public RealtimePlayer getPlayer() {
		return player;
	}
}