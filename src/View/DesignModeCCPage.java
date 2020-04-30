package View;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import models.AppSystem;

public class DesignModeCCPage {

	 private Stage s;
	 private String title;
	 private FXMLLoader fxmlLoader;
	 private AppSystem app;
	    
	 public DesignModeCCPage(Stage s, AppSystem app) {
		 this.s = s;
		 this.title = "DesignModeCCSelection";
		 this.fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("View/DesignModeCCPage.fxml"));
		 this.app = app;
	 }
	 
	 public void start() {
	        s.setTitle(title);
	        fxmlLoader.setController(new DesignModeCCController(s, app));
	        try {
	            Parent root = fxmlLoader.load();
	            Scene sc = new Scene(root, 500, 300);
	            s.setScene(sc);
	            s.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}