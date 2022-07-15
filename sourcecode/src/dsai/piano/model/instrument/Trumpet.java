package dsai.piano.model.instrument;

public class Trumpet extends Instrument {

	@Override
	public String getInstrument() {
		// TODO Auto-generated method stub
		return "Trumpet";
	}
	
	public Trumpet() {
		super(56);
	}
	
	public Trumpet(String name) {
		super(56, name);
	}
	
	
	

}
