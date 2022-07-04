package piano.controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;


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
}
