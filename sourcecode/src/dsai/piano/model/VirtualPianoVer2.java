package dsai.piano.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.sound.midi.MidiUnavailableException;

import org.jfugue.pattern.Pattern;
import org.jfugue.realtime.RealtimePlayer;

import dsai.piano.model.component.Volume;
import dsai.piano.model.component.PianoNote;
import dsai.piano.model.instrument.Instrument;
import dsai.piano.model.instrument.Piano;
import dsai.piano.model.record.Record;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VirtualPianoVer2 extends RealtimePlayer {
	private Volume volume;
	private Map<String, PianoNote> notesMap;
	
	private int nbPianoNotes = 0;
	private ObservableList<Record> records = FXCollections.observableArrayList();;
	private Instrument instrument = new Piano();
	
	public VirtualPianoVer2() throws MidiUnavailableException {
		super();
		this.setUpPiano(new Volume());
	}
	
	public VirtualPianoVer2(int value) throws MidiUnavailableException {
		super();
		this.setUpPiano(new Volume(value));
	}
	
	public VirtualPianoVer2(Volume volume) throws MidiUnavailableException {
		super();
		this.setUpPiano(volume);
	}
	
	public void setUpPiano(Volume volume) {
		this.volume = volume;
		this.notesMap = new HashMap<String, PianoNote>();
		Map<String, String> keyMap = new HashMap<String, String>();
		keyMap.put("C", "A");
		keyMap.put("D", "S");
		keyMap.put("E", "D");
		keyMap.put("F", "F");
		keyMap.put("G", "G");
		keyMap.put("A", "H");
		keyMap.put("B", "J");
		keyMap.put("C#", "6");
		keyMap.put("D#", "7");
		keyMap.put("F#", "8");
		keyMap.put("G#", "9");
		keyMap.put("A#", "0");
		
		keyMap.put("C4", "Q");
		keyMap.put("D4", "W");
		keyMap.put("E4", "E");
		keyMap.put("F4", "R");
		keyMap.put("G4", "T");
		keyMap.put("A4", "Y");
		keyMap.put("B4", "U");
		keyMap.put("C#4", "1");
		keyMap.put("D#4", "2");
		keyMap.put("F#4", "3");
		keyMap.put("G#4", "4");
		keyMap.put("A#4", "5");
		
		keyMap.put("C6", "Z");
		keyMap.put("D6", "X");
		keyMap.put("E6", "C");
		keyMap.put("F6", "V");
		keyMap.put("G6", "B");
		keyMap.put("A6", "N");
		keyMap.put("B6", "M");
		keyMap.put("C#6", "I");
		keyMap.put("D#6", "O");
		keyMap.put("F#6", "P");
		keyMap.put("G#6", "K");
		keyMap.put("A#6", "L");
		
		for (Entry<String, String> key: keyMap.entrySet()) {
			System.out.println(key);
			PianoNote note = new PianoNote(key.getKey(), nbPianoNotes++, key.getValue());
			this.addPianoNote(note);
		}
	}

	private void addPianoNote(PianoNote note) {
		this.notesMap.put(note.getKeyChar(), note);
	}

	public Map<String, PianoNote> getNotesMap() {
		return this.notesMap;
	}
	
//	public void setVolume() {			// tested
//		// set access modifiers to private -> cannot use this method outside.
//		this.changeController((byte) 7, this.volume.getCoarseVolume());
//		this.changeController((byte) 39, this.volume.getFineVolume());
//	}
	
	public void setVolume(int value) {	
		this.volume.setVolume(value);
		this.changeController((byte) 7, this.volume.getCoarseVolume());
		this.changeController((byte) 39, this.volume.getFineVolume());
	}
	
	public int getVolume() {  			
		return this.volume.getValue();
	}
	
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
		this.changeInstrument(Instrument.getInstrumentId());
	}
	
	public String getInstrument() {
		return this.instrument.getInstrument();
	}
	
	public ObservableList<Record> getRecords() {
		return this.records;
	}

	public void increaseVolume() {		
		this.volume.increaseVolume();
		this.setVolume(this.getVolume());
	}
	
	public void decreaseVolume() {		
		this.volume.decreaseVolume();
		this.setVolume(this.getVolume());
	}

	public void addRecord(Record record) {
		this.records.add(record);
	}
	
	public void addRecord(String name, String recordStr) {
		this.records.add(new Record(name, recordStr));
	}
	
	public void removeRecord(Record record) {
		if (this.getRecords().contains(record)) {
			this.records.remove(record);
		} else {
			System.out.println("not in piano record");
		}
	}
	
	public void play(Record record) {
		super.play(new Pattern(record.getPattern().toString()));
	}
	
	public void play(int i) {
		/*
		 * Play i-th record in list of record
		 */
		if (this.getRecords().size() > i) {
			Record rec = this.getRecords().get(i);
			this.play(new Pattern(rec.getPattern().toString()));
		}
	}
}
