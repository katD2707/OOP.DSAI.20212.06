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
	
	public static void main(String[] args) {
		Violin violin = new Violin();
		System.out.println(Violin.getInstrumentId());
		
		Violin vio2 = new Violin("My violin");
		System.out.println(vio2.getName());
	}
}
