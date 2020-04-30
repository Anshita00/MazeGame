package View;
 
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import models.*;

import java.util.ArrayList;

import com.sun.javafx.collections.ChangeHelper;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.stage.Stage;


public class PlayController {

	@FXML
	private ChoiceBox chooseGame;
	
    private Stage currStage;
    private AppSystem app;

    public PlayController(Stage s, AppSystem app) {
        currStage = s;
        this.app = app;
        
    }

    @FXML
    public void initialize() {
		int i = 1;
		for (Map m : app.getMaps()) {
			chooseGame.getItems().add(m.getName());
		}
		//chooseGame.setValue(app.getMaps().get(0).getName());
		
    }
    
    @FXML
    public void getChoice() {
    	String mapName = (String)chooseGame.getValue();
    	for (Map m : app.getMaps()) {
    		if (m.getName().equals(mapName)) {
    			MazeScreen ms;
				try {
					ms = new MazeScreen(currStage, (Map)m.clone(), app);
					ms.start();
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
    		}
    	}
    }

}