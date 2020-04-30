package View;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import models.*;
public class DesignModeCCController {




    @FXML
    private RadioButton killEnemiesCC;
    @FXML
    private RadioButton boulderCC;    
    @FXML
    private RadioButton treasureCC;
    @FXML
    private RadioButton exitCC;
    @FXML
    private TextField map;
    
    private Stage currStage;
    
    private AppSystem app;
    
    
    public DesignModeCCController(Stage s, AppSystem app) {
        currStage = s;
        this.app = app;
        
    }
    

    
    @FXML
    public void handleKillEnemies() {
    	if (exitCC.isSelected()) {
    		exitCC.setSelected(false);
    	}
    }
    @FXML
    public void handleBoulder() {
    	if (exitCC.isSelected()) {
    		exitCC.setSelected(false);
    	}
    }
    @FXML
    public void handleTreasure() {
    	if (exitCC.isSelected()) {
    		exitCC.setSelected(false);
    	}
    }
    
    @FXML
    public void handleExit() {
    	
    	if (treasureCC.isSelected()) {
    		treasureCC.setSelected(false);
    	}
    	if (killEnemiesCC.isSelected()) {
    		killEnemiesCC.setSelected(false);
    	}
    	if (boulderCC.isSelected()) {
    		boulderCC.setSelected(false);
    	}
    	
    }
    
    @FXML
    public void handleFinish() {
    	
    	System.out.println(map);
    	if (map.getText().equals("")) {
    		return;
    	}
    	CompletionCondition c = getCompletionCondition();
    	Map m = new Map(10,10,map.getText(), c);
    	DesignWindow dw = new DesignWindow(currStage, app, m);
    	dw.start();
    }
    //need to select the completion condition in main?
    
    CompletionCondition getCompletionCondition() {
    	
    	if(killEnemiesCC.isSelected() && treasureCC.isSelected() && boulderCC.isSelected()) {
    		CompletionCondition c = new CompletionConditionBDT();
        	return c;
    	}
    	else if(treasureCC.isSelected() && boulderCC.isSelected()) {
    		CompletionCondition c = new CompletionConditionBT();
        	return c;
    	}
    	else if(boulderCC.isSelected() && killEnemiesCC.isSelected()) {
    		CompletionCondition c = new CompletionConditionBD();
        	return c;
    	}
    	else if(boulderCC.isSelected() && treasureCC.isSelected()) {
    		CompletionCondition c = new CompletionConditionDT();
        	return c;
    	}
    	else if(exitCC.isSelected()) {
    		CompletionCondition c = new CompletionConditionE();
        	return c;
    	}
    	else if(treasureCC.isSelected()){
    		CompletionCondition c = new CompletionConditionT();
        	return c;
    	}else if(killEnemiesCC.isSelected()) {
    		CompletionCondition c = new CompletionConditionB();
        	return c;
    	}else if(boulderCC.isSelected()) {
    		CompletionCondition c = new CompletionConditionB();
        	return c;
    	}

    	CompletionCondition c = new CompletionConditionE();
    	return c;
    }
    
}
