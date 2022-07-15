package draft.model;

import java.util.ArrayList;

import dsai.piano.model.Playable;
import dsai.piano.model.component.PianoNote;

public class Record1 implements Playable {
	private ArrayList<PianoNote> record;
	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}
	
	public Record1() {
	}
	public ArrayList<PianoNote> getRecord() {
		return this.record;
	}
	
	public String toString() {
		String strRecord = "";
		for (PianoNote note: record) {
			strRecord += note.toString() + " ";
		}
		return strRecord;
		
	}

}
