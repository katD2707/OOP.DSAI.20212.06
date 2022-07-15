package dsai.piano.model.instrument;

public class Guitar extends Instrument {

	@Override
	public String getInstrument() {
		return "Guitar";
	}
	
	public Guitar() {
		super(24);
	}

}
