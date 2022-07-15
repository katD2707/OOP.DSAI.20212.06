package dsai.piano.model.instrument;

public abstract class Instrument {
	private String name;
	private static int instrument_id;
	
	public Instrument() {
		super();
	}
	
	public Instrument(int id) {
		super();
		Instrument.instrument_id = id;
	}

	public Instrument(String name) {
		super();
		this.name = name;
	}
	
	public Instrument(int id, String name) {
		super();
		Instrument.instrument_id = id;
		this.name = name;
	}
	
	public String toString() {
		return null;
	}
	
	public static int getInstrumentId() {
		return Instrument.instrument_id; 
	}
	
	public String getName() {
		return this.name;
	}

	public abstract String getInstrument();
}
	
