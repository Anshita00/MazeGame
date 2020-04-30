package View;
import models.Player;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import models.Map;
import models.Tile;
import models.CompletionConditionE;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
public class MazeController {

	@FXML
	private GridPane maze;
	
	private Stage currStage;
	private Map map;
	private MazeScreen sc;
    Group gridGroup = new Group();

    public MazeController(Stage s, Map m, MazeScreen sc) {
        currStage = s;
        this.map = m;
        this.sc = sc;
    }

    @FXML
    public void initialize() {
        // This function is for loading initialization of your controller.
        // Since this example doesn't need any initialization, I just leave it empty.
        // I deliberately put this function in every controller in order to let you know
        // that you may(should) need this function in your project.
    	
    	//maze.add(child, columnIndex, rowIndex);
    	setGrid();

    }
    
    public void makePlayer() {
//    	Player p = new Player(0,0);
//    	Image pimg = new Image(new FileInputStream("player.png"));
//    	Image player =
//    	
//    	currStage.
    }
    public void setGrid() {
    	//Map grid = new Map(10,10,"Bloody George's map",c);
    	maze.getChildren().clear();
    	for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
            	System.out.println("Hereee" + " " + x + " " + y);
                // store this gird into gridBoard.
                // add this grid to group
            	//Image img = new Image("File:View/player.png");
//            	System.out.println(map.getTile(x, y).display()+ " " + x + y);
            	ImageView imgView = new ImageView("View/ground.png");
            	imgView.prefHeight(60);
            	imgView.prefWidth(60);
            	maze.add(imgView, y, x);
            	imgView = new ImageView(map.getTile(x, y).display());
            	imgView.prefHeight(60);
            	imgView.prefWidth(60);
            	//System.out.println(maze.getChildren());
            	//maze.add(imgView, 0, 0);
            	maze.add(imgView, y, x);
            	//maze.getChildren().add(x, imgView);
            	//maze.getChildren().remove(y);
                //gridGroup.getChildren().add(grid.getTile(10, 10));
            	
            	
            }
    	}
    }

    @FXML
    public void handleKeyPressed() {
    	
    }

    @FXML
    public void handleKeyReleased() {
    	
    }
}
