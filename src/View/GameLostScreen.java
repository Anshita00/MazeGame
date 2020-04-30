package View;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.AppSystem;

public class GameLostScreen {
	
	private Stage s;
    private String title;
    private FXMLLoader fxmlLoader;
    private AppSystem app;

    public GameLostScreen(Stage s, AppSystem app) {
        this.s = s;
        this.title = "Game Lost";
        this.fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("View/GameLost.fxml"));
        this.app = app;
    }

    public void start()  {
        s.setTitle(title);
        // set controller for start.fxml
        fxmlLoader.setController(new GameLostController(s, app));
        try {
            // load into a Parent node called root
            Parent root = fxmlLoader.load();
            Scene sc = new Scene(root, 600, 600);
            s.setScene(sc);
            s.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
