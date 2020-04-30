package View;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import models.AppSystem;

public class StartController {

    //startButton is unused.
    @FXML
    private Button startButton;
	private static final long serialVersionUID = 1L;
	
	@FXML
	Button musicControll;


    private Stage currStage;
    private AppSystem app;

    public StartController(Stage s, AppSystem app) {
        currStage = s;
        this.app = app;
    }

    @FXML
    public void initialize() {
        // This function is for loading initialization of your controller.
        // Since this example doesn't need any initialization, I just leave it empty.
        // I deliberately put this function in every controller in order to let you know
        // that you may(should) need this function in your project.
//    	if(Bgm.getStat()) {
//    		System.out.println("true");
//    		musicControll.setText("Music: On");
//    	}
//    	else musicControll.setText("Music: Off");
    }

    @FXML
    public void handlePlayGameButton() {
    	PlayScreen ps = new PlayScreen(currStage, app);
    	ps.start();
        // CountScreen cs = new CountScreen(currStage);
        //cs.start();
    }
    @FXML
    public void handleDesignGameButton() {
    	DesignModeCCPage ds = new DesignModeCCPage(currStage, app);
    	ds.start();
        // CountScreen cs = new CountScreen(currStage);
        //cs.start();
    }
    
    /**
	 * Change whether user want to play bgm.
	 * @param actionEvent The source trigger this event.
	 */
	@FXML
    private void changeBgm(ActionEvent actionEvent) {
    	if(musicControll.getText().equals("Music: On")) {
    		Bgm.changeStat(false);
    		musicControll.setText("Music: Off");
    	}
    	else{
    		Bgm.changeStat(true);
    		musicControll.setText("Music: On");
    	}
    }
}
