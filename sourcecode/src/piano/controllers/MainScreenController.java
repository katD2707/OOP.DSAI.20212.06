package piano.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import piano.test.HelpScreen;
import piano.test.PianoScreen;

public class MainScreenController {
	
	private HelpScreen helpScreen;
	private PianoScreen pianoScreen;
	
    @FXML
    private Button helpButton;

    @FXML
    private Button playButton;

    @FXML
    void helpButtonPressed(ActionEvent event) throws IOException {
		final String HELP_FXML_FILE_PATH = "/piano/screen/fxmlSupporter/Help.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(HELP_FXML_FILE_PATH));
		HelpTextController helpText = new HelpTextController();
		fxmlLoader.setController(helpText);
		Parent root = fxmlLoader.load();	
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../screen/cssSupporter/HelpSupporter.css").toExternalForm());
		
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.setTitle("Help");
		primaryStage.getIcons().add(new Image("file:src/piano/picture/icons8-question-mark-30.png"));
		primaryStage.centerOnScreen();
		
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.show();
    }

    @FXML
    void playButtonPresed(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/piano/screen/fxmlSupporter/Pianov2.fxml"));
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.setResizable(true);
    	stage.centerOnScreen();
    	stage.show();
    }

}
