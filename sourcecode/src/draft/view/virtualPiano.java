package draft.view;

import javax.sound.midi.MidiUnavailableException;

import draft.controller.OctaveController;
import draft.controller.pianoController;
import draft.model.Octave;
import dsai.piano.model.PianoVer1;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class virtualPiano extends Application {
	private static PianoVer1 piano;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		final String STORE_FXML_FILE_PATH = "/dsai/piano/screen/view/pianoScreen.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		pianoController pianoCtl = new pianoController(piano);
		fxmlLoader.setController(pianoCtl);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Virtual Piano");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	public static void main(String[] args) throws MidiUnavailableException {
//		octave = new Octave();
		piano = new PianoVer1();
		piano.setUpPiano();
		launch(args);
	}
	

}
