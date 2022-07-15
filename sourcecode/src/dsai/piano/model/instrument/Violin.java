package dsai.piano.model.instrument;

public class Violin extends Instrument {

	@Override
	public String getInstrument() {
		return "Violin";
	}

	public Violin() {
		super(40);
	}
	
	public Violin(String name) {
		super(40, name);
	}
}
