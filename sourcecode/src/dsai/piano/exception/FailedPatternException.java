package dsai.piano.exception;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class FailedPatternException extends Exception {

	public FailedPatternException() {
		// TODO Auto-generated constructor stub
	}

	public FailedPatternException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FailedPatternException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public FailedPatternException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FailedPatternException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws FailedPatternException {
		Pattern pattern = new Pattern("Con chim non 1 as d e f # %$@");
		Player player = new Player();
		try {
			player.play(pattern);
		} catch (Exception e) {
			throw new FailedPatternException();
		}
	}
}
