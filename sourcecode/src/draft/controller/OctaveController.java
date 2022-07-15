package draft.controller;


import draft.model.Octave;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

public class OctaveController {
	private Octave octave;
    @FXML
    private Button btnDecreaseOctave;

    @FXML
    private Button btnIncreaseOctave;

    @FXML
    private Label lblOctave;

    // using these 2 method to click on 2 button
    @FXML
    void btnDecreaseOctavePressed(ActionEvent event) {
//    	octave.decreaseOctave();
//    	lblOctave.setText("" + Octave.getOCTAVE());
    }

    @FXML
    void btnIncreaseOctavePressed(ActionEvent event) { 
    	octave.increaseOctave();
    	lblOctave.setText("" + Octave.getOCTAVE());
    }
    public OctaveController(Octave octave) {
    	this.octave = octave;
    }
    
    final KeyCombination keyShiftEqual = new KeyCodeCombination(KeyCode.EQUALS, KeyCombination.SHIFT_DOWN);
//    final KeyCodeCombination keyMinus = new KeyCodeCombination(KeyCode.MINUS, null);
    @FXML
	public void initialize() {
    	btnDecreaseOctave.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if (event.getCode().equals(KeyCode.MINUS)) {
//				if (keyMinus.match(event)) {
					octave.decreaseOctave();
			    	lblOctave.setText("" + Octave.getOCTAVE());
				} else if (keyShiftEqual.match(event)) {
					octave.increaseOctave();
					lblOctave.setText("" + Octave.getOCTAVE());
				}
				System.out.println(event.getText());
			}
		});
    	btnIncreaseOctave.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
//				System.out.println(event.getText());
				if (event.getCode().toString() == "MINUS") {
					btnDecreaseOctave.fire();
					octave.decreaseOctave();
			    	lblOctave.setText("" + Octave.getOCTAVE());
				} else if (keyShiftEqual.match(event)) {
//					octave.increaseOctave();
//					lblOctave.setText("" + Octave.getOCTAVE());
//					btnIncreaseOctave.setFocusTraversable(true);
					btnIncreaseOctave.fire();
				}
//				System.out.println(event.getText());
			}
		});
	}
}
