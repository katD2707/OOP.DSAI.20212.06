package dsai.piano.model;

import java.util.ArrayList;

public class Record implements Playable {
	private ArrayList<pianoNote> record;
	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}
	
	public Record() {
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
