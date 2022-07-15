package dsai.piano;

import javax.sound.midi.MidiUnavailableException;

import dsai.piano.controller.VirtualPianoVer2Controller;
import dsai.piano.model.VirtualPianoVer2;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class VirtualPianoViewVer2 extends Application {
	private static VirtualPianoVer2 piano;
	Stage primaryStage;
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
  		final String PATH = "/piano/screen/fxmlSupporter/Pianov2.fxml"; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PATH));
		VirtualPianoVer2Controller controller = new VirtualPianoVer2Controller(piano);
		fxmlLoader.setController(controller);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Virtual Piano");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
//		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//
//			@Override
//			public void handle(WindowEvent arg0) {
//	    			piano.close();
//			}
//		});
		primaryStage.setOnCloseRequest(e -> {
			e.consume();
			closeProgram();
		});
		
	}
	public static void main(String[] args) throws MidiUnavailableException {
		piano = new VirtualPianoVer2();
		launch(args);
	}
	private void closeProgram() {
		Alert alert = new Alert(AlertType.NONE);
		alert.setTitle("Exit");
		alert.setHeaderText("Are you finish playing?");
		alert.setContentText("Play with us <3");
		alert.getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.FINISH);
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("file:src/piano/picture/icons8-fire-exit-50.png"));
		alert.showAndWait();
		if(alert.getResult() == ButtonType.FINISH) {
			piano.close();
			primaryStage.close();
		} 
	}
}
