package draft.controller;

import dsai.piano.model.component.Volume;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class VolumeController {
	Volume volume;
    @FXML
    private Label lblVolume;

    @FXML
    private Slider sldVolume;
    
    public VolumeController(Volume volume) {
    	this.volume = volume;
    }
    
    @FXML
    public void initialize() {
    	sldVolume.valueProperty().addListener( new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				// TODO Auto-generated method stub
//				lblVolume.setText(arg2);
//				updateLabelVolume("" + Integer.parseInt(arg2));
				updateLabelVolume("" + arg2.intValue());
			}
		});
//    	sldVolume.valueProperty().addListener((InvalidationListener) new ChangeListener<Double>() {
//
//			@Override
//			public void changed(ObservableValue<? extends Double> arg0, Double arg1, Double arg2) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
    }
    void updateLabelVolume(String value) {
    	lblVolume.setText("Volume: " + value);
    }
}
