package dsai.piano.controller;


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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VirtualPianoController {
	private piano2 piano;
	private byte octave = 4;
	private boolean isRecording = false;
	private boolean assistantOn = false;
    private boolean songVisible = false;
    private boolean volumeVisible = false;
    private boolean instrumentVisible = false;
    boolean[] enableKeys;
    BidirectionalMap<String, Button> buttonMap;
	public VirtualPianoController(piano2 piano) {
		super();
		this.piano = piano;
		this.enableKeys = new boolean[piano.getNotesMap().size()];
		for (int i = 0; i < piano.getNotesMap().size(); i++) {
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
    private Label saveLabel, recordLabel;
    @FXML
    private Button btn1, btn2, btn3, btn4, btn5, btnQ, btnW, btnE, btnR, btnT, btnY, btnU;
    @FXML
    private Button btnA, btnS, btnD, btnF, btnG, btnH, btnJ, btn6, btn7, btn8, btn9, btn0;
    @FXML
    private Button btnZ, btnX, btnC, btnV, btnB, btnN, btnM, btnI, btnO, btnP, btnK, btnL;
    @FXML
    private Button btnRemoveRecord, btnPlayRecord;
    
    @FXML
    private VBox volumeVbox, songBox;
    
    @FXML
    private HBox instrumentBox, titleBox;
    
    @FXML
    private ComboBox<Record> recordCombobox;

    
    
    
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
    void noteReleased(KeyEvent event) {
    	String keyChar = event.getText();
    	System.out.println("note released");
    	try {
    		pianoNote note = piano.getNotesMap().get(keyChar.toUpperCase());
    		if (!this.enableKeys[note.getId()]) {
    			piano.stopNote(note);
    			this.enableKeys[note.getId()] = true;
    		} 
    	} catch (NullPointerException e) {
    		
    		System.err.println(event.getCode().toString() + " is not bind to pianoNote");
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("PIANO ERROR FROM KEYBOARD");
    		alert.setHeaderText("NullPointerException");
    		alert.setContentText(event.getCode().toString() + " is not used for piano note.");
        	
    		alert.showAndWait();
    	}
    }
    
    @FXML
    void btnNoteMouseReleased(MouseEvent event) {
    	Button btn = (((Button) event.getSource()) );
    	String key = buttonMap.getKey(btn).toUpperCase();
    	try {
    	pianoNote note = piano.getNotesMap().get(key);
    	if (!this.enableKeys[note.getId()]) {
			piano.stopNote(note);
			this.enableKeys[note.getId()] = true;
			
		}
    	} catch (NullPointerException e) {
    		System.out.println(key + " is not bind");
    	}
    }
    
    @FXML 
    void btnNoteMousePressed(MouseEvent event) {
    	Button btn = (((Button) event.getSource()) );
    	String key = buttonMap.getKey(btn).toUpperCase();
    	try {
    		pianoNote note = piano.getNotesMap().get(key);
    		if (this.enableKeys[note.getId()]) {
    			updateKeyLabel(note.getOriginalString());
    			piano.startNote(note);
    			this.enableKeys[note.getId()] = false;
    			
    			System.out.println(buttonMap.get(note.getKeyChar().toLowerCase()).getText());
    		}
    	} catch (NullPointerException e) {
    		System.out.println(key + " is not bind");
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("PIANO ERROR");
    		alert.setHeaderText("NullPointerException");
    		alert.setContentText(key + " is not used for piano note.");
        	
    		alert.showAndWait();
    	}
    }
    @FXML
    void a(MouseEvent event) {
    	if (this.octave > 0) {
    		this.octave -= 1;
    		for (pianoNote note: piano.getNotesMap().values()) {
    			note.decreaseOctave();
    		}
    	}
    	updateNoteDisplay();
    }

    @FXML
    void b(MouseEvent event) {
    	if (this.octave < 7) {
    		this.octave += 1;
    		for (pianoNote note: piano.getNotesMap().values()) {
    			note.increaseOctave();
    		}
    	}
    	updateNoteDisplay();
    }

    // START MouseEvent
    @FXML 
    void assistantClicked(MouseEvent event) {									// DONE
    	if (assistantOn) {
    		assistantOn = false;
    		for (Button btn: buttonMap.valueSet()) {
    			pianoNote note = piano.getNotesMap().get(buttonMap.getKey(btn).toUpperCase());
    			try {
    				btn.setText(note.getOriginalString());
    			} catch (Exception e) {
    				System.err.print(e.getLocalizedMessage());
    				System.err.println(btn.getText());
    			}
    		}
    	} else {
    		assistantOn = true;
    		for (Button btn: buttonMap.valueSet()) {
    			pianoNote note = piano.getNotesMap().get(buttonMap.getKey(btn).toUpperCase());
    			btn.setText(note.getOriginalString() + " (" + buttonMap.getKey(btn).toUpperCase() + ")");
    		}
    	}
    }
    
   
    
    @FXML
    void volumeBoxClicked(MouseEvent event) {  			// DONE
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
    void instrumentBoxClicked(MouseEvent event) {		// DONE
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
    void songBoxClicked(MouseEvent event) {				// DONE
    	if (songVisible) {
    		songVisible = false;
    	} else {
    		songVisible = true;
    		volumeVisible = false;
    		volumeVbox.setVisible(false);
    		instrumentVisible = false;
    		instrumentBox.setVisible(false);
    		updateRecordBox(null);
    	}
    	songBox.setVisible(songVisible);
    }

    @FXML
    void recordLabelClicked(MouseEvent event) {									// DONE
    	if (! isRecording) {
    		recordLabel.setText("CANCEL");
    		isRecording = true;
	    	System.out.println("record starting");
	    	saveLabel.setDisable(false);
	    	titleBox.setVisible(true);
	    	keyLabel.setText("");
	    	titleLabel.setText("");
    	} else {
    		recordLabel.setText("RECORD");
    		isRecording = false;
    		System.out.println("cancel");
    		saveLabel.setDisable(true);
    		titleLabel.setText("");
    		titleBox.setVisible(false);
    	}
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
    void replayPatternClicked(MouseEvent event) {								// DONE
    	piano.play(keyLabel.getText());	
    }

    @FXML
    void clearPatternClicked(MouseEvent event) {								// DONE
    	keyLabel.setText("");
    }


    @FXML																		// DONE
    void btnPlayRecordPressed(ActionEvent event) {
    	Record rec = recordCombobox.getSelectionModel().getSelectedItem();
    	piano.play(rec);
    }

    @FXML
    void btnRemoveRecordPressed(ActionEvent event) {							// DONE
    	Record rec = recordCombobox.getSelectionModel().getSelectedItem();
    	piano.removeRecord(rec);
    	recordCombobox.getSelectionModel().clearSelection();
    }
    
    @FXML
    void initialize() {
    	buttonMap = new BidirectionalMap<String, Button>();
    	buttonMap.put("a", btnA);
    	buttonMap.put("s", btnS);
    	buttonMap.put("d", btnD);
    	buttonMap.put("g", btnF);
    	buttonMap.put("h", btnG);
    	buttonMap.put("f", btnH);
    	buttonMap.put("j", btnJ);
    	buttonMap.put("6", btn6);
    	buttonMap.put("7", btn7);
    	buttonMap.put("8", btn8);
    	buttonMap.put("9", btn9);
    	buttonMap.put("0", btn0);
    	
    	buttonMap.put("1", btn1);
    	buttonMap.put("2", btn2);
    	buttonMap.put("3", btn3);
    	buttonMap.put("4", btn4);
    	buttonMap.put("5", btn5);
    	buttonMap.put("q", btnQ);
    	buttonMap.put("w", btnW);
    	buttonMap.put("e", btnE);
    	buttonMap.put("r", btnR);
    	buttonMap.put("t", btnT);
    	buttonMap.put("y", btnY);
    	buttonMap.put("u", btnU);
    	
    	buttonMap.put("z", btnZ);
    	buttonMap.put("x", btnX);
    	buttonMap.put("c", btnC);
    	buttonMap.put("v", btnV);
    	buttonMap.put("b", btnB);
    	buttonMap.put("n", btnN);
    	buttonMap.put("m", btnM);
    	buttonMap.put("i", btnI);
    	buttonMap.put("o", btnO);
    	buttonMap.put("p", btnP);
    	buttonMap.put("k", btnK);
    	buttonMap.put("l", btnL);
    	
    	
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
    	
    	piano.addRecord("NoName", "C D E F");									// DEFAULT RECORD OF PIANO
    	if (piano.getRecords() != null) {
    		recordCombobox.setItems(piano.getRecords());
    	}
    	
    	recordCombobox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Record>() {
			@Override
			public void changed(ObservableValue<? extends Record> arg0, Record arg1, Record arg2) {
				updateRecordBox(arg2);
			}
		});
    }
    void updateRecordBox(Record rec) {											// DONE
    	if (rec != null) {
    		if (rec.getLength() > 3) {
    			keyLabel.setText(rec.getPattern().toString());
    			btnPlayRecord.setDisable(false);
    			btnRemoveRecord.setDisable(false);
    		} else {
    			btnPlayRecord.setDisable(true);;
    			btnRemoveRecord.setDisable(false);
    		}
    	} else {
    		System.out.println("here");
    		recordCombobox.getSelectionModel().clearSelection();
    		btnRemoveRecord.setDisable(true);
    		btnPlayRecord.setDisable(true);
    	}
    }
    
    void updateKeyLabel(String text) {											// DONE
    	keyLabel.setText(keyLabel.getText() + " " + text);
    }
    void updateNoteDisplay() {													// DONE
    	if (!assistantOn) {
    		for (Button btn: buttonMap.valueSet()) {
    			pianoNote note = piano.getNotesMap().get(buttonMap.getKey(btn).toUpperCase());
    				btn.setText(note.getOriginalString());
    		}
    	} else {
    		for (Button btn: buttonMap.valueSet()) {
    			pianoNote note = piano.getNotesMap().get(buttonMap.getKey(btn).toUpperCase());
    			btn.setText(note.getOriginalString() + " (" + buttonMap.getKey(btn).toUpperCase() + ")");
    		}
    	}
    }
}
