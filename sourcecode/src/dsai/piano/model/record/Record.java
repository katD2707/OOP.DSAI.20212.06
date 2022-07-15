package dsai.piano.model.record;

public class Record {
	private String name = "No name";		// name of record
	private StringBuilder pattern; 	// content
	
	public Record() {
		super();
	}
	
	public Record(String pattern) {
		super();
		this.pattern = new StringBuilder(pattern);
	}
	
	public Record(String name, String pattern) {
		super();
		this.name = name;
		this.pattern = new StringBuilder(pattern);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StringBuilder getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern =  new StringBuilder(pattern);
	}

	public int getLength() {
		return (this.pattern.toString().trim().split("\\s+")).length;
	}
	
	public void addContent(String content) {
		this.pattern = this.pattern.append(" " + content);
	}
	
	
	public String toString() {
		return this.name;
	}

}
