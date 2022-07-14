package dsai.piano;

import javax.sound.midi.MidiUnavailableException;

import dsai.piano.controller.VirtualPianoController;
import dsai.piano.model.piano2;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class VirtualPianoViewVer1 extends Application {
	private static piano2 piano;
	@Override
	public void start(Stage primaryStage) throws Exception {
  		final String PATH = "/piano/screen/fxmlSupporter/Pianov2.fxml"; 
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PATH));
		
		System.out.println("load fxml");
		VirtualPianoController controller = new VirtualPianoController(piano);
		fxmlLoader.setController(controller);
		System.out.println("set controller");
		
		Parent root = fxmlLoader.load();
		System.out.println("root");
		
		primaryStage.setTitle("Virtual Piano");
		primaryStage.setScene(new Scene(root));
		System.out.println("new scene");
		primaryStage.show();
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent arg0) {
	    			piano.close();
			}
		});
	}
	public static void main(String[] args) throws MidiUnavailableException {
		piano = new piano2();
		System.out.println("[]".toUpperCase());
		launch(args);
	}
}
