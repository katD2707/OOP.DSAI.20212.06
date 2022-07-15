package dsai.piano.model.instrument;

public abstract class Instrument {
	private String name;
	private static int INSTRUMENT_ID;
	
	public Instrument() {
		super();
	}
	
	public Instrument(int id) {
		super();
		this.INSTRUMENT_ID = id;
	}

	public Instrument(String name) {
		super();
		this.name = name;
	}
	
	public Instrument(int id, String name) {
		super();
		this.INSTRUMENT_ID = id;
		this.name = name;
	}
	
	public String toString() {
		return null;
	}
	
	public static int getInstrumentId() {
		return Instrument.INSTRUMENT_ID; 
	}
	
	public String getName() {
		return this.name;
	}

	public String getInstrument() {
		return "UNSPECIFIED INSTRUMENT";
	};
}
