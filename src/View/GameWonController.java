package View;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import models.AppSystem;
import models.Map;

public class GameWonController {
	private Stage currStage;
	private AppSystem app;
    @FXML
    private Button backMenu;

	public GameWonController(Stage s,AppSystem app) {
		currStage = s;
		this.app = app;
	}
	
    @FXML
    public void initialize() {
        // This function is for loading initialization of your controller.
        // Since this example doesn't need any initialization, I just leave it empty.
        // I deliberately put this function in every controller in order to let you know
        // that you may(should) need this function in your project.
    	
    	//maze.add(child, columnIndex, rowIndex);

    }


    @FXML
    void backToMenu() {
    	StartScreen sc = new StartScreen(currStage,app);
    	sc.start();
    }

}