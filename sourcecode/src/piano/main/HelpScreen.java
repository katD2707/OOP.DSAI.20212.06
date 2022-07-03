package piano.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import piano.controllers.HelpTextController;

public class HelpScreen extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			final String help_FXML_FILE_PATH = "/piano/screen/fxmlSupporter/Help.fxml";
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(help_FXML_FILE_PATH));
			HelpTextController helpTextController = new HelpTextController();
			fxmlLoader.setController(helpTextController);
			
			Parent root = fxmlLoader.load();						
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../screen/cssSupporter/HelpSupporter.css").toExternalForm());
					
			primaryStage.setScene(scene);
			primaryStage.setTitle("Help");
			primaryStage.getIcons().add(new Image("file:src/piano/picture/icons8-question-mark-30.png"));
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
