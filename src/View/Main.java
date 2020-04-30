package View;

import javafx.application.Application;
import javafx.stage.Stage;
import models.AppSystem;
import models.Arrow;
import models.Bomb;
import models.Boulder;
import models.CompletionCondition;
import models.CompletionConditionD;
import models.Door;
import models.Exit;
import models.FloorSwitch;
import models.HoverPotion;
import models.Hunter;
import models.InvincibilityPotion;
import models.Key;
import models.Map;
import models.Pit;
import models.Sword;
import models.Treasure;
import models.Wall;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // set the stage height to be 400
        primaryStage.setHeight(600);
        // set the stage width to be 600
        primaryStage.setWidth(600);
        

        StartScreen startScreen = new StartScreen(primaryStage, new AppSystem());
        System.out.println("changing music stat");
        Bgm.changeStat(true);
        System.out.println("playeing music");
        Bgm.play();
        startScreen.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
