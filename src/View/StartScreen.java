package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.AppSystem;

import java.io.IOException;

public class StartScreen {

    private Stage s;
    private String title;
    private FXMLLoader fxmlLoader;
    private AppSystem app;

    public StartScreen(Stage s, AppSystem app) {
        this.s = s;
        this.title = "Start Screen";
        this.fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("View/Start.fxml"));
        this.app = app;
    }

    public void start()  {
        s.setTitle(title);
        // set controller for start.fxml
        fxmlLoader.setController(new StartController(s, app));
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
