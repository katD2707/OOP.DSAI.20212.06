package dsai.piano.controller;

import java.io.IOException;

import javax.sound.midi.MidiUnavailableException;

import dsai.piano.model.VirtualPianoVer2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainScreenController {
	
	private static VirtualPianoVer2 piano;
	
    @FXML
    private Button helpButton;

    @FXML
    private Button playButton;

    @FXML
    void helpButtonPressed(ActionEvent event) throws IOException {
    	HelpTextController helpController = new HelpTextController();
    	helpController.showHelp();    	
    }

    @FXML
    void playButtonPresed(ActionEvent event) throws IOException, MidiUnavailableException {
    	piano  = new VirtualPianoVer2();
    	
    	final String HELP_FXML_FILE_PATH = "/dsai/piano/screen/fxmlSupporter/Pianov2.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(HELP_FXML_FILE_PATH));
		VirtualPianoVer2Controller controller = new VirtualPianoVer2Controller(piano);
		fxmlLoader.setController(controller);
		Parent root = fxmlLoader.load();	
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../screen/cssSupporter/HelpSupporter.css").toExternalForm());
		
		Stage pianoStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		pianoStage.setScene(scene);

		pianoStage.centerOnScreen();

    	pianoStage.show();
    }

}
