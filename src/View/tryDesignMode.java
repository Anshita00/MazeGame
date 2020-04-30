package View;

import javafx.application.Application;
import javafx.stage.Stage;

public class tryDesignMode extends Application {	    

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) throws Exception {
            
            primaryStage.setHeight(600);
            primaryStage.setWidth(600);
           // Scene newScene = new scene(); 
            DesignWindow startScreen = new DesignWindow(primaryStage);
            startScreen.start();
        }
}


