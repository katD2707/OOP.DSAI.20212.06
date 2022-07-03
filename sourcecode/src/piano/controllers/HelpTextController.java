package piano.controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;


public class HelpTextController {

    @FXML
    private TextArea helpText;
    
    private String line;
	
	public void editTextArea() {
		helpText.setStyle("-fx-text-fill: #ff8300");
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/piano/editable/help.txt"));
			System.out.println("Succeeded");
			while ((line = br.readLine()) != null) {
				helpText.appendText(line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
