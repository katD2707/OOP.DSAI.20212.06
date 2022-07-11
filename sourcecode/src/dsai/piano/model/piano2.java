package dsai.piano.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.sound.midi.MidiUnavailableException;

import org.jfugue.pattern.Pattern;
import org.jfugue.realtime.RealtimePlayer;

import dsai.piano.model.component.Volume;
import dsai.piano.model.component.pianoNote;
import dsai.piano.model.instrument.Instrument;
import dsai.piano.model.record.Record;

public class piano2 extends RealtimePlayer {
	
	private Volume volume;
	private Map<String, pianoNote> notesMap;
	boolean[] enableKeys;
	private ArrayList<Record> records;
	private Instrument instrument;
	
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
		this.records = new ArrayList<Record>();
		pianoNote noteC = new pianoNote("C", "A");
		this.addPianoNote(noteC);
		pianoNote noteCD = new pianoNote("C#", "W");
		this.addPianoNote(noteCD);
		pianoNote noteD = new pianoNote("D", "S");
		this.addPianoNote(noteD);
		pianoNote noteDE = new pianoNote("D#", "E");
		this.addPianoNote(noteDE);
		pianoNote noteE = new pianoNote("E", "D");
		this.addPianoNote(noteE);
		pianoNote noteF = new pianoNote("F", "F");
		this.addPianoNote(noteF);
		pianoNote noteFG = new pianoNote("F#", "T");
		this.addPianoNote(noteFG);
		pianoNote noteG = new pianoNote("G", "G");
		this.addPianoNote(noteG);
		pianoNote noteGA = new pianoNote("G#", "Y");
		this.addPianoNote(noteGA);
		pianoNote noteA = new pianoNote("A", "H");
		this.addPianoNote(noteA);
		pianoNote noteAB = new pianoNote("A#", "U");
		this.addPianoNote(noteAB);
		pianoNote noteB = new pianoNote("B", "J");
		this.addPianoNote(noteB);
	
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
	
	public ArrayList<Record> getRecords() {
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
