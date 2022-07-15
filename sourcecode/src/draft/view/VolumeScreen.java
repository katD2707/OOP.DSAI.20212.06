package draft.view;

import draft.controller.VolumeController;
import dsai.piano.model.component.Volume;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VolumeScreen extends Application {
	private static Volume volume;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		final String VOLUME_FXML_FILE_PATH = "/dsai/piano/screen/view/Volume.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(VOLUME_FXML_FILE_PATH));
		VolumeController volumeController = new VolumeController(volume);
		fxmlLoader.setController(volumeController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Volume");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		volume = new Volume();
		launch(args);
	}
}
