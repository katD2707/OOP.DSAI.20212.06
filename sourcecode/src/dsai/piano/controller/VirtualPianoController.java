package dsai.piano.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import dsai.piano.exception.NullPianoNoteException;
import dsai.piano.map.BidirectionalMap;
import dsai.piano.model.piano2;
import dsai.piano.model.component.pianoNote;
import dsai.piano.model.instrument.Flute;
import dsai.piano.model.instrument.Guitar;
import dsai.piano.model.instrument.Piano;
import dsai.piano.model.instrument.Trumpet;
import dsai.piano.model.instrument.Violin;
import dsai.piano.model.record.Record;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VirtualPianoController {
	private piano2 piano;
	private boolean assistantOn = true;
    private boolean songVisible = false;
    private boolean volumeVisible = false;
    private boolean instrumentVisible = false;
    boolean[] enableKeys;
    BidirectionalMap<String, Button> buttonMap;
	public VirtualPianoController(piano2 piano) {
		super();
		this.piano = piano;
		this.enableKeys = new boolean[12];
		for (int i = 0; i < 12; i++) {
			this.enableKeys[i] = true;
		} 
	};
	
    @FXML
    private TextField keyLabel, titleLabel;
    @FXML
    private Slider VolumeSlider;
    
    @FXML
    private MenuButton instrumentMenu;

    @FXML
    private ToggleGroup instrumentGroup;
    
    @FXML
    private Label saveLabel, assitantLabel;

    @FXML
    private Button btnC, btnB, btnAb, btnA, btnE, btnde, btnFg, btnGa, btnCd, btnG, btnD, btnF;
    
    @FXML
    private VBox volumeVbox, songBox;
    
    @FXML
    private HBox instrumentBox, titleBox;
    

    @FXML
    void notePressed(KeyEvent event) throws NullPianoNoteException {
//    	System.out.println(event.getSource().toString());
//    	System.out.println( ( (Button)event.getSource() ).getText() );
//    	switch (( (Button)event.getSource() ).getText()) {
//    	System.out.println(event.getSource().toString());
    	System.out.println(event.getText());
    	String keyChar = event.getText();
//    	switch (event.getText()) {
//    		case "a": 
//    			System.out.println("C3 was pressed");
////    			piano.startNote(new pianoNote("C5"));
//    			pianoNote note = piano.getNotesMap().get(event.getText().toUpperCase());
//    			piano.startNote(note);
////    			btnC.fire();
//    			break;
//    		case "b":
//    			System.out.println("D3 was pressed");
//    			piano.startNote(new pianoNote("E9"));
////    			btnD.fire();
//    			break;
//    		case "s":
//    			piano.setInstrument(new Flute());
//    			break;
//    	}
    	if (titleLabel.isFocused()) {
    		System.out.println("focus");
    		if (event.getCode().equals(KeyCode.ENTER)) {
        		System.out.println("enter pressed");
        		btnA.requestFocus();
    		}
    	} else {
	    	try {
	    		pianoNote note = piano.getNotesMap().get(keyChar.toUpperCase());
	    		if (this.enableKeys[note.getId()]) {
	    			updateKeyLabel(note.getOriginalString());
	    			piano.startNote(note);
	    			this.enableKeys[note.getId()] = false;
	    			
	    			System.out.println(buttonMap.get(note.getKeyChar().toLowerCase()).getText());
	    		} 
	    	} catch (NullPointerException e) {
	    		System.err.println(keyChar + " is not bind to pianoNote");
	    	}
	    	
    	}
    }

    @FXML
    void noteReleased(KeyEvent event) throws NullPianoNoteException {
    	String keyChar = event.getText();
    	System.out.println("note released");
    	try {
    		pianoNote note = piano.getNotesMap().get(keyChar.toUpperCase());
    		if (!this.enableKeys[note.getId()]) {
//    			updateKeyLabel(note.getOriginalString);
    			piano.stopNote(note);
    			this.enableKeys[note.getId()] = true;
    		} 
    	} catch (NullPointerException e) {
    		System.err.println(keyChar + " is not bind to pianoNote");
//    		System.err.println(e.getLocalizedMessage());
    	}
    }
    private void updateKeyLabel(String text) {									// DONE
    	keyLabel.setText(keyLabel.getText() + " " + text);
    }
    
    @FXML
    void a(ActionEvent event) {
//    	Button btn = (((Button) event.getSource()) );
//    	String key = buttonMap.getKey(btn).toUpperCase();
//    	pianoNote note = piano.getNotesMap().get(key);
//    	piano.startNote(note);
//    	String keychar = btn.getText().c
//    	System.out.println(buttonMap.);
//    	System.out.println(piano.);;
    	
    	
    	
    	
//    	System.out.println(event.getSource().toString());
//    	System.out.println( ( (Button)event.getSource() ).getText() );
    	System.out.println("action: ");
    	System.out.println(event.getSource().toString());
    	
//    	switch ((((Button) event.getSource()) ).getText()) {
//    	case "a":
//    		System.out.println("a");
//    	default:
//    		System.out.println((((Button) event.getSource()) ).getText());
//    	}
    	
    }
    @FXML 
    void btnMousePressed(MouseEvent event) {
    	Button btn = (((Button) event.getSource()) );
    	String key = buttonMap.getKey(btn).toUpperCase();
    	pianoNote note = piano.getNotesMap().get(key);
    	piano.startNote(note);
    }
    
    // START MouseEvent
    @FXML 
    void AssistantClicked(MouseEvent event) {									// DONE
    	if (assistantOn) {
    		assistantOn = false;
    		for (Button btn: buttonMap.valueSet()) {
    			String oldText = btn.getText();
    			btn.setText(oldText.substring(0, oldText.indexOf(" ", 0)));
    		}
    	} else {
    		assistantOn = true;
    		for (Button btn: buttonMap.valueSet()) {
    			String oldText = btn.getText();
    			btn.setText(oldText + " (" + buttonMap.getKey(btn).toUpperCase() + ")");
    		}
    	}
    }
    
   
    
    @FXML
    void volumeBoxClicked(MouseEvent event) {  			// done
    	if (volumeVisible) {
    		volumeVisible = false;
    	} else {
    		songVisible = false;
    		songBox.setVisible(false);
    		instrumentVisible = false;
    		instrumentBox.setVisible(false);
    		volumeVisible = true;
    	}
    	volumeVbox.setVisible(volumeVisible);
    }
    @FXML
    void instrumentBoxClicked(MouseEvent event) {		// done
    	System.out.println("instrument box clicked");
    	if (instrumentVisible) {
    		instrumentVisible = false;
    	} else {
    		instrumentVisible = true;
    		volumeVisible = false;
    		volumeVbox.setVisible(false);
    		songVisible = false;
    		songBox.setVisible(false);
    	}
    	instrumentBox.setVisible(instrumentVisible);
    }   
    @FXML
    void songBoxClicked(MouseEvent event) {				// done
    	if (songVisible) {
    		songVisible = false;
    	} else {
    		songVisible = true;
    		volumeVisible = false;
    		volumeVbox.setVisible(false);
    		instrumentVisible = false;
    		instrumentBox.setVisible(false);
    	}
    	songBox.setVisible(songVisible);
    }

    @FXML
    void startRecord(MouseEvent event) {
    	System.out.println("record starting");
    	saveLabel.setDisable(false);
    	titleBox.setVisible(true);
    	keyLabel.setText("");
    	titleLabel.setText("");
    }

    @FXML
    void saveRecord(MouseEvent event) {											// DONE 
    	saveLabel.setDisable(true);
    	titleBox.setVisible(false);
    	Record record = new Record(titleLabel.getText(), keyLabel.getText());
    	piano.addRecord(record);
    }

    // END MouseEvent 
    
    
    @FXML
    void initialize() {
    	buttonMap = new BidirectionalMap<String, Button>();
    	buttonMap.put("a", btnC);
    	buttonMap.put("s", btnD);
    	buttonMap.put("d", btnE);
    	buttonMap.put("g", btnG);
    	buttonMap.put("h", btnA);
    	buttonMap.put("f", btnF);
    	buttonMap.put("j", btnB);
    	buttonMap.put("w", btnCd);
    	buttonMap.put("e", btnde);
    	buttonMap.put("t", btnFg);
    	buttonMap.put("y", btnGa);
    	buttonMap.put("u", btnAb);
    	
    	instrumentGroup.selectedToggleProperty().addListener((observable, oldToggle, newToggle) -> {
    		switch (((RadioMenuItem)newToggle).getText()) {
    		case "Default":
    			piano.setInstrument(new Piano());
    			break;
    		case "Guitar":
    			piano.setInstrument(new Guitar());
    			break;
    		case "Flute":
    			piano.setInstrument(new Flute());
    			break;
    		case "Trumpet":
    			piano.setInstrument(new Trumpet());
    			break;
    		case "Violin":
    			piano.setInstrument(new Violin());
    			break;
    		}
	        instrumentMenu.setText(piano.getInstrument());
    	});
    	
    	VolumeSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				// TODO Auto-generated method stub
				piano.setVolume(arg2.intValue());
				System.out.println(piano.getVolume());
			}
		});
    }
}
