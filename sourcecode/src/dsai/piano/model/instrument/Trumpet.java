package dsai.piano.model.instrument;

public class Trumpet extends Instrument {

	@Override
	public String getInstrument() {
		return "Trumpet";
	}
	
	public Trumpet() {
		super(56);
	}
	
	public Trumpet(String name) {
		super(56, name);
	}

}
