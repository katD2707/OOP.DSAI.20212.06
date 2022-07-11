package piano.controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class HelpTextController {

    @FXML
    private TextArea helpText;

    private String line;
	
    @FXML
	public void initialize() {
		helpText.setStyle("-fx-text-fill: #ff8300");
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/piano/editable/help.txt"));

			while ((line = br.readLine()) != null) {
				helpText.appendText(line);
				helpText.appendText("\n");
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
    
    public void showHelp() throws IOException {
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
}
