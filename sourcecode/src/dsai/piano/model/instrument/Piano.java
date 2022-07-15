package dsai.piano.model.instrument;

public class Piano extends Instrument {

	@Override
	public String getInstrument() {
		// TODO Auto-generated method stub
		return "Piano";
	}
	
	public Piano() {
		super(0);
	}
	
	public Piano(String name) {
		super(0, name);
	}
}
