package dsai.test.sceen;

import dsai.piano.controller.OctaveController;
import dsai.piano.model.Octave;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test extends Application {
	private static Octave octave;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		final String STORE_FXML_FILE_PATH = "/dsai/piano/view/Octave.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		OctaveController octaveController = new OctaveController(octave);
		fxmlLoader.setController(octaveController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Octave");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	public static void main(String[] args) {
		octave = new Octave();
		launch(args);
	}
	
	
}
