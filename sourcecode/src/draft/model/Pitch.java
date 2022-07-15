package draft.model;


import javafx.scene.input.KeyCode;

public class Pitch {
	private String keyCode;
	private String note;
	
	public Pitch() {
		super();
	}
	
	public Pitch(String keyCode, String note) {
		super();
		this.keyCode = keyCode;
		this.note = note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}
	
	public String getNote() {
		return this.note;
	}
	
	public String getKeyCode() {
		return this.keyCode;
	}
	
	public static void main(String[] args) {
		KeyCode keyCode = KeyCode.C;
		System.out.println(keyCode.getChar());
	}
}
