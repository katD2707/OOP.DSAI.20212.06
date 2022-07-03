package piano.main;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("../screen/Pianov2.fxml"));
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../screen/application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Piano");
			primaryStage.getIcons().add(new Image("file:src/piano/picture/icon.png"));

			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
