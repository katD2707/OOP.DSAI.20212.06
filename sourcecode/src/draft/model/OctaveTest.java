package draft.model;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OctaveTest extends JFrame {
	public JButton btn;
	public Octave octave;
	public OctaveTest() {
		this.octave = new Octave();

//		Container cp = new JPanel();
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(3, 1));
		
		JLabel lb = new JLabel("Label");
		cp.add(lb);

		this.btn = new JButton();
		this.btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lb.setText("Already reset");
				octave = new Octave();
				btn.setText("octave = " + octave.getOCTAVE());
			}
		});
//		this.btn.addKeyListener(new KeyListener() {
			
//			@Override
//			public void keyTyped(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void keyReleased(KeyEvent e) {
//				// TODO Auto-generated method stub
//			}
//			
//			@Override
//			public void keyPressed(KeyEvent e) {
//				// TODO Auto-generated method stub
//				String ev = "" + e.getKeyChar();
//				if (ev.equals("+")) {
//					octave.increaseOctave();
//				}
//				if (ev.equals("-")) {
//					octave.decreaseOctave();
//				}
//				btn.setText("octave = " + octave.getOCTAVE());
//				lb.setText("octave = " + octave.getOCTAVE());
//			}
//		});
		this.btn.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
	            if (e.getKeyChar() == 'A' || e.getKeyChar() == 'a') {
	                ((JButton) e.getSource()).doClick();
	            }
	        }
		});
		
		JButton btn2 = new JButton();
		btn2.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
	            if (e.getKeyChar() == 'B' || e.getKeyChar() == 'b') {
	                ((JButton) e.getSource()).doClick();
	            }
	        }
		});
		cp.add(btn2);
		
		cp.add(this.btn);
		setLocationRelativeTo(null);
		setSize(200, 100);
		setResizable(false);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new OctaveTest();
	}
	
}
