package draft.model;

import java.io.BufferedReader;
import java.io.FileReader;

import draft.controller.HelpTextController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class HelpScreen extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			final String HELP_FXML_FILE_PATH = "/piano/screen/fxmlSupporter/Help.fxml";
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(HELP_FXML_FILE_PATH));
			HelpTextController helpText = new HelpTextController();
			fxmlLoader.setController(helpText);
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
