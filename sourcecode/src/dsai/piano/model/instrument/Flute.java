package dsai.piano.model.instrument;

public class Flute extends Instrument {

	@Override
	public String getInstrument() {
		// TODO Auto-generated method stub
		return "Flute";
	}
	
	public Flute() {
		super(73);
	}
	
	public Flute(String name) {
		super(73, name);
	}
}
