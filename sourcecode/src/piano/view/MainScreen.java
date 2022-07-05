package piano.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import piano.controllers.MainScreenController;

public class MainScreen extends Application {
	
	@Override
	public void start(Stage mainStage) throws Exception {
		final String MAIN_FXML_FILE_PATH = "/piano/screen/fxmlSupporter/Main.fxml";
		Parent root = FXMLLoader.load(getClass().getResource(MAIN_FXML_FILE_PATH));
		
		
		Scene scene = new Scene(root);

		mainStage.setScene(scene);
		mainStage.setTitle("Piano");
		mainStage.getIcons().add(new Image("file:src/piano/picture/icon.png"));
		mainStage.setResizable(false);
		mainStage.centerOnScreen();
		mainStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
