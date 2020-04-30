package View;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import models.AppSystem;
import models.Map;

public class GameLostController {
    private Stage currStage;
    private AppSystem app;
    @FXML
    private Button GameLostButton;

    public GameLostController(Stage s, AppSystem app) {
        currStage = s;
        this.app = app;
        
    }

    @FXML
    public void initialize() {
		
		
    }
    
    @FXML
    public void handleButton() {
    	StartScreen sc = new StartScreen(currStage, app);
    	sc.start();
    }
}
