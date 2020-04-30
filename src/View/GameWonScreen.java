package View;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import models.AppSystem;
import models.Map;

public class GameWonScreen {
 	private Stage s;
 	private AppSystem app;
    private FXMLLoader fxmlLoader;

	public GameWonScreen(Stage s,AppSystem app) {
        this.s = s;
        this.app = app;
        this.fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("View/GameWon.fxml"));
    }

    public void start()  {
        // set controller for start.fxml
        fxmlLoader.setController(new GameWonController(s,app));
        try {
            // load into a Parent node called root
            Parent root = fxmlLoader.load();
            Scene sc = new Scene(root, 500, 300);

            s.setScene(sc);
            s.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    


 }
}
