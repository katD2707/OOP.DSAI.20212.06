package dsai.piano.controller;


import java.io.IOException;

import dsai.piano.exception.NullPianoNoteException;
import dsai.piano.model.VirtualPianoVer2;
import dsai.piano.model.component.PianoNote;
import dsai.piano.model.instrument.Flute;
import dsai.piano.model.instrument.Guitar;
import dsai.piano.model.instrument.Piano;
import dsai.piano.model.instrument.Trumpet;
import dsai.piano.model.instrument.Violin;
import dsai.piano.model.record.Record;
import dsai.piano.tool.BidirectionalMap;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VirtualPianoVer2Controller {
	private VirtualPianoVer2 piano;
	private byte octave = 4;
	
	private boolean isRecording = false;
	private boolean assistantOn = false;
    private boolean songVisible = false;
    private boolean volumeVisible = false;
    private boolean instrumentVisible = false;
    boolean[] enableKeys;
    
    BidirectionalMap<String, Button> buttonMap;
	public VirtualPianoVer2Controller(VirtualPianoVer2 piano) {
		super();
		this.piano = piano;
		this.enableKeys = new boolean[piano.getNotesMap().size()];
		for (int i = 0; i < piano.getNotesMap().size(); i++) {
			this.enableKeys[i] = true;
		}   	
	};
	
	@FXML
	private Button helpButton;
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
    void helpButtonPressed(ActionEvent event) throws IOException {
    	HelpTextController helpController = new HelpTextController();
    	helpController.showHelp();  
    }
    
    @FXML
    void backLabelClicked(MouseEvent event) throws IOException {
    	final String HELP_FXML_FILE_PATH = "/dsai/piano/screen/fxmlSupporter/Main.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(HELP_FXML_FILE_PATH));
		
		Parent root = fxmlLoader.load();	
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("../screen/cssSupporter/MainSupporter.css").toExternalForm());
		
		Stage pianoStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		pianoStage.setScene(scene);

		pianoStage.centerOnScreen();

    	pianoStage.show();
    }
    
    @FXML
    void notePressed(KeyEvent event) throws NullPianoNoteException {
    	/*
    	 * This method plays piano Note binded to keyboard button from user keyboard when a key is pressed.
    	 * Throw NullPianoNoteException if the pressed key is not binded to piano Note.
    	 */
    	String keyChar = event.getText();
    	PianoNote note = piano.getNotesMap().get(keyChar.toUpperCase());
	    	try {
	    		if (note != null) {
	
		    		if (this.enableKeys[note.getId()]) {
		    			updateKeyLabel(note.getOriginalString());
		    			piano.startNote(note);
		    			this.enableKeys[note.getId()] = false;
		    			Button button = buttonMap.get(note.getKeyChar().toLowerCase());
		    			if (button.getText().indexOf('#')>=0) {
		    				button.setStyle("-fx-background-insets: 0,0 0 7 0, 0 0 8 0, 0 0 9 0;\r\n"
		    						+ "	-fx-border-color: #ff8300;\r\n"
		    						+ "	-fx-border-width: 2;");
		    			}   
		    			else {
		    				button.setStyle("-fx-background-color:  linear-gradient(#ffffff 0%, #e0e0e0 85%, #e0e0e0 85%);\r\n"
	    					+ "	-fx-padding: 2 0 -2 0;\r\n"
	    					+ "	-fx-background-insets: 2 0 -2 0;");
		    			}
		    			System.out.println(button.getText());
		    		}
	    		} else {
	    			throw new NullPianoNoteException();
	    		}
	    	} catch (NullPianoNoteException e) {
	    		System.err.println(event.getCode().toString() + " is not bind to pianoNote");
	    	}
	    	
    }

    @FXML
    void noteReleased(KeyEvent event) throws NullPianoNoteException {
    	/*
    	 * This method stops piano Note binded to keyboard button from user keyboard when a key is released.
    	 * Throw NullPianoNoteException if the released key is not binded to piano Note.
    	 */
    	String keyChar = event.getText();
    	try {
    		if (piano.getNotesMap().get(keyChar.toUpperCase()) != null) {
    			
    			PianoNote note = piano.getNotesMap().get(keyChar.toUpperCase());
    			if (!this.enableKeys[note.getId()]) {
    				piano.stopNote(note);
    				this.enableKeys[note.getId()] = true;
    				buttonMap.get(note.getKeyChar().toLowerCase()).setStyle("-fx-background-color:  linear-gradient(#ffffff 85%, #f8f8f8 88%, #e3e3e3 91%, #ffffff 100%);\r\n"
    						+ "	-fx-padding: 0 0 0 0;\r\n"
    						+ "	-fx-background-insets: 0 0 0 0;\r\n"
    						+ "	-fx-background-radius:  2 0 10 8;");
    			} 
    		} else {
    			throw new NullPianoNoteException();
    		}
    	} catch (NullPianoNoteException e) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("PIANO ERROR FROM KEYBOARD");
    		alert.setHeaderText("NullPianoNoteException");
    		alert.setContentText(event.getCode().toString() + " is not used for piano note.");
    		alert.showAndWait();
    	}
    }
    
    @FXML
    void btnNoteMouseReleased(MouseEvent event) throws NullPianoNoteException {
    	/*
    	 * This method stops piano Note binded to Button from screen when a button is released.
    	 * Throw NullPianoNoteException if the released button is not binded to piano Note.
    	 */
    	Button btn = (((Button) event.getSource()) );
    	String key = buttonMap.getKey(btn).toUpperCase();
    	try {
    		if (piano.getNotesMap().get(key) != null) {
    			PianoNote note = piano.getNotesMap().get(key);
    			if (!this.enableKeys[note.getId()]) {
    				piano.stopNote(note);
    				this.enableKeys[note.getId()] = true;
    			}
    		} else {
    			throw new NullPianoNoteException();
    		}
    	} catch (NullPianoNoteException e) {
    		System.err.println(key + " is not bind to pianoNote");
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("PIANO ERROR FROM MOUSE CLICK");
    		alert.setHeaderText("NullPianoNoteException");
    		alert.setContentText(key + " is not bind to pianoNote");
    		alert.showAndWait();
    	}
    }
    
    @FXML 
    void btnNoteMousePressed(MouseEvent event) {
    	/*
    	 * This method plays piano Note binded to Button from screen when a button is pressed.
    	 * Throw NullPianoNoteException if the pressed button is not binded to piano Note.
    	 */
    	Button btn = (((Button) event.getSource()) );
    	String key = buttonMap.getKey(btn).toUpperCase();
    	try {
    		if (piano.getNotesMap().get(key) != null) {
    			PianoNote note = piano.getNotesMap().get(key);
    			if (this.enableKeys[note.getId()]) {
    				updateKeyLabel(note.getOriginalString());
    				piano.startNote(note);
    				this.enableKeys[note.getId()] = false;
    			}
    		} else {
    			throw new NullPianoNoteException();
    		}
    	} catch (NullPianoNoteException e) {
    		System.err.println(key + " is not bind to pianoNote");
    	}
    }
    @FXML
    void decreaseOctaveBtnClicked(MouseEvent event) {
    	/*
    	 * This method decreases octave of every note when Increase Octave Button is clicked
    	 */
    	if (this.octave > 3) {
    		this.octave -= 1;
    		for (PianoNote note: piano.getNotesMap().values()) {
    			note.decreaseOctave();
    		}
    	}
    	updateNoteDisplay();
    }

    @FXML
    void increaseOctaveBtnClicked(MouseEvent event) {
    	/*
    	 * This method increases octave of every note when Increase Octave Button is clicked
    	 */
    	if (this.octave < 7) {
    		this.octave += 1;
    		for (PianoNote note: piano.getNotesMap().values()) {
    			note.increaseOctave();
    		}
    	}
    	updateNoteDisplay();
    }

    // START MouseEvent
    @FXML 
    void assistantClicked(MouseEvent event) {	
    	/*
    	 * This method update Label in every piano note.
    	 * When assistantOn, user can see both the note string and the key string to press.
    	 *     	 * When assitantOn is false (off), user only see the note string.
    	 */
    	if (assistantOn) {
    		assistantOn = false;
    		for (Button btn: buttonMap.valueSet()) {
    			PianoNote note = piano.getNotesMap().get(buttonMap.getKey(btn).toUpperCase());
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
    			PianoNote note = piano.getNotesMap().get(buttonMap.getKey(btn).toUpperCase());
    			btn.setText(note.getOriginalString() + " (" + buttonMap.getKey(btn).toUpperCase() + ")");
    		}
    	}
    }
    
   
    
    @FXML
    void volumeBoxClicked(MouseEvent event) {  			
    	/*
    	 * This method will show or hide Volume Box, close other box.
    	 */
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
    void instrumentBoxClicked(MouseEvent event) {	
    	/*
    	 * This method will show or hide Instrument Box, and close other box.
    	 */
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
    void RecordBoxClicked(MouseEvent event) {	
    	/*
    	 * This method will show or hide Record Box, and close other box.
    	 */
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
    void recordLabelClicked(MouseEvent event) {	
    	/*
    	 * When recordLabel is clicked, this method will work:
    	 * 		Start recording, title field is set to visible, save label is enable.
    	 * 		Cancel recording, title field is set to invisible, save label is disable (cannot save).
    	 */
    	if (! isRecording) {
    		isRecording = true;
    		recordLabel.setText("CANCEL");
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
    void saveRecord(MouseEvent event) {	
    	/*
    	 * This method will save the record from Key field and title field from screen.
    	 */
    	recordLabel.setText("RECORD");
		isRecording = false;
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
    	// Assign buttonMap to a Bidirectional Map which can retrieve both key and value.
    	buttonMap = new BidirectionalMap<String, Button>();
    	
    	buttonMap.put("a", btnA);
    	buttonMap.put("s", btnS);
    	buttonMap.put("d", btnD);
    	buttonMap.put("f", btnF);
    	buttonMap.put("g", btnG);
    	buttonMap.put("h", btnH);
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
    	
    	
    	// Add listener to selected Instrument, change piano instrument.
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
    	
    	
    	// Add listener to VolumeSlider, update the piano volume
    	VolumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				piano.setVolume(arg2.intValue());
			}
		});
    	
//    	piano.addRecord("NoName", "Cq D#hhhhhhhh E F");									// DEFAULT RECORD OF PIANO
    	
    	
    	// Set items from Records list of piano to recordCombobox
    	recordCombobox.setItems(piano.getRecords());
    	
    	// Add listener to the selection item of recordCombobox
    	recordCombobox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Record>() {
			@Override
			public void changed(ObservableValue<? extends Record> arg0, Record arg1, Record arg2) {
				updateRecordBox(arg2);
			}
		});
    	
    	
    	/*  
    	 * set default focus for btn1
    	 */
    	Platform.runLater(() -> btn1.requestFocus());						
    }
    
    
    void updateRecordBox(Record rec) {	
    	/*
    	 * This method updates Combobox which contains list of Records.
    	 * If Record is not null,
    	 * 		If Record length is less than 3, the Play button will be disable
    	 * 		else, Play button and Remove button will able to be pressed.
    	 * else, disable both play button and remove button 	
    	 * 		
    	 */
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
    		recordCombobox.getSelectionModel().clearSelection();
    		btnRemoveRecord.setDisable(true);
    		btnPlayRecord.setDisable(true);
    	}
    }
    
    void updateKeyLabel(String text) {	
    	/*
    	 * This method update Key Label, as soon as any piano note is played.
    	 */
    	keyLabel.setText(keyLabel.getText() + " " + text);
    }
    void updateNoteDisplay() {		
    	/*
    	 * This method update Label in every piano note when user change note octave.
    	 */
    	if (!assistantOn) {
    		for (Button btn: buttonMap.valueSet()) {
    			PianoNote note = piano.getNotesMap().get(buttonMap.getKey(btn).toUpperCase());
    				btn.setText(note.getOriginalString());
    		}
    	} else {
    		for (Button btn: buttonMap.valueSet()) {
    			PianoNote note = piano.getNotesMap().get(buttonMap.getKey(btn).toUpperCase());
    			btn.setText(note.getOriginalString() + " (" + buttonMap.getKey(btn).toUpperCase() + ")");
    		}
    	}
    }
}
