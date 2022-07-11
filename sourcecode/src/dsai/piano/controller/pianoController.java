package dsai.piano.controller;

import javax.sound.midi.MidiUnavailableException;

import dsai.piano.model.Piano;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

public class pianoController {
	private Piano piano;
	
	public pianoController(Piano piano) {
		this.piano = piano;
	}
	
    @FXML
    private Button btnInVol;

    @FXML
    private Button btnCd;

    @FXML
    private Label lblOct;

    @FXML
    private Button btnC;

    @FXML
    private Button btnDeOct;

    @FXML
    private Button noteGa;

    @FXML
    private Button btnInOct;

    @FXML
    private Button noteA;

    @FXML
    private Button noteD;

    @FXML
    private Button noteE;

    @FXML
    private Button noteB;

    @FXML
    private Button noteDe;

    @FXML
    private Button noteFg;

    @FXML
    private Button noteAb;

    @FXML
    private Button noteF;

    @FXML
    private Button noteG;

    @FXML
    private Button btnDeVol;

    @FXML
    private Label lblVol;

    @FXML
    void btnVolAct(ActionEvent event) {
    	
    }
    
    @FXML
    void btnVolPressed(KeyEvent event) {
    	
    }
    @FXML
    void btnOctAct(ActionEvent event) {
//    	if ( ((Button)event.getSource()).getText().equals("+") ) {
//    	} else if (event.getText().equals("-")) {
//    	}
    	if (((Button)event.getSource()).getText().equals("-")) {
    		piano.decreaseOctave();
    		lblOct.setText("Octave: " + piano.getOctave());
    	} else if (((Button)event.getSource()).getText().equals("+")) {
    		piano.increaseOctave();
    		lblOct.setText("Octave: " + piano.getOctave());
    	}
    }

    @FXML
    void btnOctPressed(KeyEvent event) {
//    	if ("+-".contains(event.getText()))
//    	System.out.println(event.getText());
//    	((Button) event.getSource()).fire();
//    }
    	String evt = event.getText();
    	if (btnInOct.getText().equals(evt)) {
    		btnInOct.fire();
    	} else if (btnDeOct.getText().equals(evt)) {
    		btnDeOct.fire();
    	} else {
    		System.out.println(evt);
    		System.out.println(event.getCode().getChar());
    	}
    }
    @FXML
    void noteAct(ActionEvent event) {
    	Button b = (Button)event.getSource();
    	System.out.println(b.getText());
    }
    

    @FXML
    void notePressed(KeyEvent event) {
    	if ("ASDFGHJTYUWE".contains(("" + event.getCode().getChar()))) {
    		boolean playable = piano.enableKeys[piano.getPianoNotes().indexOf(piano.getNotesMap().get("" + event.getCode().getChar()))];
    		if (playable) {
    			piano.enableKeys[piano.getPianoNotes().indexOf(piano.getNotesMap().get("" + event.getCode().getChar()))] = false;
    			piano.getPlayer().startNote(piano.getNotesMap().get("" + event.getCode().getChar()));
    			((Button)event.getSource()).setStyle("-fx-background-color: #ff8300;");
    			
    			if ("ASDFGHJ".contains(("" + event.getCode().getChar()))) {
    				((Button)event.getSource()).setStyle("-fx-background-color: black;");
    			} else {
    				((Button)event.getSource()).setStyle("-fx-background-color: gray;");
    			}
    		}
    	}
    	String i = "" + event.getCode().getChar();
    	if (noteA.getText().equals(i)) {
    		noteA.fire();
    		System.out.println("a");
    	} else if (noteB.getText().equals(i)) {
    		noteB.fire();
    		System.out.println("b");
    	} else if (btnC.getText().equals(i)) {
    		btnC.fire();
    		System.out.println('c');
    	}
    }

    @FXML
    void noteReleased(KeyEvent event) {
    	if ("ASDFGHJTYUWE".contains(("" + event.getCode().getChar()))) {
//    		boolean playable = piano.enableKeys[piano.getPianoNotes().indexOf(piano.getNotesMap().get("" + event.getCode().getChar()))];
//    		if (playable) {
    			piano.enableKeys[piano.getPianoNotes().indexOf(piano.getNotesMap().get("" + event.getCode().getChar()))] = true;
    			piano.getPlayer().stopNote(piano.getNotesMap().get("" + event.getCode().getChar()));
//    		}
    			if ("ASDFGHJ".contains(("" + event.getCode().getChar()))) {
    				((Button)event.getSource()).setStyle("-fx-background-color: gray;");
    			} else {
    				((Button)event.getSource()).setStyle("-fx-background-color: black;");
    			}	
    	}
    }
    
//    @FXML
//    public void initilize() throws MidiUnavailableException {
//    	piano = new Piano();
//    	piano.setUpPiano();
//    }
}
