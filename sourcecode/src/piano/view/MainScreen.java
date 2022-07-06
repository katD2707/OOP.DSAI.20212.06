package piano.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainScreen extends Application {
	Stage mainStage;
	
	@Override
	public void start(Stage mainStage) throws Exception {
		this.mainStage = mainStage;
		final String MAIN_FXML_FILE_PATH = "/piano/screen/fxmlSupporter/Main.fxml";
		Parent root = FXMLLoader.load(getClass().getResource(MAIN_FXML_FILE_PATH));
		
		
		Scene scene = new Scene(root);
		
		mainStage.setScene(scene);
		mainStage.setTitle("Piano");
		mainStage.getIcons().add(new Image("file:src/piano/picture/icon.png"));
		mainStage.setResizable(false);
		mainStage.centerOnScreen();
		
		mainStage.setOnCloseRequest(e -> {
			e.consume();
			closeProgram();
		});
		
		mainStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
//	private void closeProgram() {
//		Boolean answer = ConfirmBox.display("Title", "Sure you want to exit?");
//		if (answer) {
//			mainStage.close();
//		}
//	} 
	
	private void closeProgram() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirm exit");
		alert.setHeaderText("Please don't go :<<<");
		alert.setContentText("Play with us <3");
		alert.showAndWait();
//		alert.setTitle(STYLESHEET_CASPIAN);
		if(alert.getResult() == ButtonType.CANCEL) {
			mainStage.close();
		}			
	}
}
