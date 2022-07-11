package dsai.piano.model;

import java.util.ArrayList;

import dsai.piano.model.component.pianoNote;

public class Record1 implements Playable {
	private ArrayList<pianoNote> record;
	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}
	
	public Record1() {
	}
	public ArrayList<pianoNote> getRecord() {
		return this.record;
	}
	
	public String toString() {
		String strRecord = "";
		for (pianoNote note: record) {
			strRecord += note.toString() + " ";
		}
		return strRecord;
		
	}

}
