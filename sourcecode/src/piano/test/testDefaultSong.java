package piano.test;

import org.jfugue.player.Player;
import org.jfugue.rhythm.Rhythm;

public class testDefaultSong {
	public static void main(String[] args) {
		Rhythm rhythm = new Rhythm()
				 .addLayer("O..oO...O..oOO..")
				 .addLayer("..S...S...S...S.")
				 .addLayer("````````````````")
				 .addLayer("...............+");
				Player player = new Player();
				player.play(rhythm.getPattern().repeat(4));

	}
}
