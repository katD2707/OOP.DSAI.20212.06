package draft.piano.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainScreenController {
	
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
