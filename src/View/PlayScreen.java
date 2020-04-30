package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.AppSystem;

import java.io.IOException;

public class PlayScreen {

    private Stage s;
    private String title;
    private FXMLLoader fxmlLoader;
    AppSystem app;

    public PlayScreen(Stage s, AppSystem app) {
        this.s = s;
        this.title = "Play Screen";
        this.fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("View/play.fxml"));
        this.app = app;
    }

    public void start()  {
        s.setTitle(title);
        // set controller for start.fxml
        fxmlLoader.setController(new PlayController(s,app));
        try {
            // load into a Parent node called root
            Parent root = fxmlLoader.load();
            System.out.println("In play screen");
            Scene sc = new Scene(root, 500, 300);
            s.setScene(sc);
            s.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
