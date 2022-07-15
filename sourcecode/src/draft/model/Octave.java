package draft.model;


import java.io.IOException;

public class Octave {
	static private int OCTAVE = 5;
	
	public Octave() {
		super();
	}
	
	public Octave(int oct) {
		super();
		Octave.OCTAVE = oct;
	}
	
	public static int getOCTAVE() {
		return Octave.OCTAVE;
	}
	
	public void setOCTAVE(int oct) throws IOException {
		// TODO: apply IOException when oct > 10 or oct < 0 
		if (oct < 0 || oct > 10) {
//			throws 
			System.out.println("Range error");
		} else {
			Octave.OCTAVE = oct;
		}
		
	}
	public void increaseOctave() {
		if (Octave.OCTAVE < 10) {
			Octave.OCTAVE += 1;
		}
	}
	public void decreaseOctave() {
		if (Octave.OCTAVE > 0) {
			Octave.OCTAVE -= 1;
		}
	}

//	@Override
//	public void keyTyped(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void keyPressed(KeyEvent e) {
//		// TODO Auto-generated method stub
//		String ev = "" +  e.getKeyChar();
//		if (ev.equals("+")) {
//			this.increaseOctave();
//		}
//		if (ev.equals("-")) {
//			this.decreaseOctave();
//		}
//		System.out.println(Octave.OCTAVE);
//	}
//
//	@Override
//	public void keyReleased(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
}
