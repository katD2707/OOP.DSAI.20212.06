package dsai.piano.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.sound.midi.MidiUnavailableException;

import org.jfugue.pattern.Pattern;
import org.jfugue.realtime.RealtimePlayer;

import dsai.piano.model.component.Volume;
import dsai.piano.model.component.pianoNote;
import dsai.piano.model.instrument.Instrument;
import dsai.piano.model.instrument.Piano;
import dsai.piano.model.record.Record;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class piano2 extends RealtimePlayer {
	
	private Volume volume;
	private Map<String, pianoNote> notesMap;
	boolean[] enableKeys;
	private int nbPianoNotes = 0;
	private ObservableList<Record> records = FXCollections.observableArrayList();;
	private Instrument instrument = new Piano();
	
	public piano2() throws MidiUnavailableException {
		super();
		this.setUpPiano(new Volume());
		
	}
	
	public piano2(int value) throws MidiUnavailableException {
		super();
		this.setUpPiano(new Volume(value));
	}
	
	public piano2(Volume volume) throws MidiUnavailableException {
		super();
		this.setUpPiano(volume);
	}
	
	public void setUpPiano(Volume volume) {
		// TODO: Create a piano
//		this.volume = new Volume();
		this.volume = volume;
//		this.pianoNotes = new ArrayList<pianoNote>();
		this.notesMap = new HashMap<String, pianoNote>();
//		this.records = new ArrayList<Record>();
//		this.records = new ObservableList<Record>();
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
//		keyMap.put();
//		keyMap.put();
//		keyMap.put();
//		keyMap.put();
//		keyMap.put();
		
//		Iterator<String> iterator = keyMap.ite
		for (Entry<String, String> key: keyMap.entrySet()) {
			System.out.println(key);
			pianoNote note = new pianoNote(key.getKey(), nbPianoNotes++, key.getValue());
			this.addPianoNote(note);
//			nbPianoNotes++;
		}
		System.out.println("done");
//		pianoNote noteC = new pianoNote("C", "A");
//		this.addPianoNote(noteC);
//		pianoNote noteCD = new pianoNote("C#", "W");
//		this.addPianoNote(noteCD);
//		pianoNote noteD = new pianoNote("D", "S");
//		this.addPianoNote(noteD);
//		pianoNote noteDE = new pianoNote("D#", "E");
//		this.addPianoNote(noteDE);
//		pianoNote noteE = new pianoNote("E", "D");
//		this.addPianoNote(noteE);
//		pianoNote noteF = new pianoNote("F", "F");
//		this.addPianoNote(noteF);
//		pianoNote noteFG = new pianoNote("F#", "T");
//		this.addPianoNote(noteFG);
//		pianoNote noteG = new pianoNote("G", "G");
//		this.addPianoNote(noteG);
//		pianoNote noteGA = new pianoNote("G#", "Y");
//		this.addPianoNote(noteGA);
//		pianoNote noteA = new pianoNote("A", "H");
//		this.addPianoNote(noteA);
//		pianoNote noteAB = new pianoNote("A#", "U");
//		this.addPianoNote(noteAB);
//		pianoNote noteB = new pianoNote("B", "J");
//		this.addPianoNote(noteB);
	
		enableKeys = new boolean[12];
		for (int i = 0; i < 12; i++) {
			enableKeys[i] = true;
		}
	}

	private void addPianoNote(pianoNote note) {
		this.notesMap.put(note.getKeyChar(), note);
	}

	public Map<String, pianoNote> getNotesMap() {
		return this.notesMap;
	}
	
	public void setVolume() {			// tested
		// set access modifiers to private -> cannot use this method outside.
		this.changeController((byte) 7, this.volume.getCoarseVolume());
		this.changeController((byte) 39, this.volume.getFineVolume());
	}
	
	public void setVolume(int value) {	// tested
		this.volume.setVolume(value);
		this.changeController((byte) 7, this.volume.getCoarseVolume());
		this.changeController((byte) 39, this.volume.getFineVolume());
	}
	
	public int getVolume() {  			// tested
		return this.volume.getValue();
	}
	
	public void setOctave() {
		
	}

	public byte getOctave() {
		return (byte)2;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
		this.changeInstrument(instrument.getInstrumentId());
	}
	
	public String getInstrument() {
		return this.instrument.getInstrument();
	}
	
	public void setRecord() {
		
	}
	
	public ObservableList<Record> getRecords() {
		return this.records;
	}
	
	public void increaseVolume() {		// tested
		this.volume.increaseVolume();
		this.setVolume();
	}
	
	public void decreaseVolume() {		// tested
		this.volume.decreaseVolume();
		this.setVolume();
	}
	
	
	
	public void increaseOctave() {
		
	}
	
	public void decreaseOcatave() {
		
	}
	
	public void addRecord(Record record) {
		this.records.add(record);
	}
	
	public void addRecord(String name, String recordStr) {
		this.records.add(new Record(recordStr));
	}
	public void removeRecord(Record record) {
		if (this.getRecords().contains(record)) {
			this.records.remove(record);
		} else {
			System.out.println("not in piano record");
		}
	}
//	public void play(pianoNote note) {
//		this.startNote(note);
//	}
//	public void stop
//	public void play(Pattern pattern) {
//		this.play(pattern);
//	}
	
	public void play(Record record) {
		this.play(new Pattern(record.getPattern().toString()));
	}
	
	public void play(int i) {
		System.out.println("Play int");
		if (this.getRecords().size() > i) {
			System.out.println(i + "    "+ this.getRecords().size());;
			Record rec = this.getRecords().get(i);
			System.out.println(rec.getPattern().toString());
			this.play(new Pattern(rec.getPattern().toString()));
		}
	}
}
