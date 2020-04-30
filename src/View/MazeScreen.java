package View;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import models.AppSystem;
import models.Map;

public class MazeScreen {
	 	private Stage s;
	    private String title;
	    private FXMLLoader fxmlLoader;
	    private Map map;
	    private AppSystem app;

	    public MazeScreen(Stage s, Map m, AppSystem app) {
	        this.s = s;
	        this.title = "Maze Screen";
	        this.fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("View/Maze.fxml"));
	        this.map = m;
	        this.app = app;
	    }

	    public void start()  {
	        s.setTitle(title);
	        // set controller for start.fxml
	        fxmlLoader.setController(new MazeController(s,map, this));
	        try {
	            // load into a Parent node called root
	            Parent root = fxmlLoader.load();
	            Scene sc = new Scene(root, 600, 600);
	        	sc.setOnKeyPressed(new EventHandler<KeyEvent>() {

	    			@Override
	    			public void handle(KeyEvent event) {
	    				int i = 0;
	    				int j = 0;
	    		    	MazeController mazeController = (MazeController) fxmlLoader.getController();
	    				//System.out.println("pressed: " + event.getCode());
	    				switch (event.getCode()) {
	    				case DOWN: map.moveMovable(map.getPlayer(), 's');
	    							break;
	    				case LEFT: map.moveMovable(map.getPlayer(), 'a');
	    							break;
	    				case UP: map.moveMovable(map.getPlayer(), 'w');
	    							break;
	    				case RIGHT: map.moveMovable(map.getPlayer(), 'd');
	    							break;
//	    				case R: map.shootArrow();
//	    						break;
	    				case W: map.shootArrow("w"); break;
	    				
	    				case S: map.shootArrow("s"); break;
	    				
	    				case D: map.shootArrow("d"); break;
	    				
	    				case A: map.shootArrow("a"); break;
	    				
	    				case B: map.moveMovable(map.getPlayer(), 'b');
	    				} 
	    	
    					map.pickupCollectibles();
    					
    					if (map.gameLost()) {
    						
    						System.out.println("YOU LOSE");
    						mazeController.setGrid();
    						GameLostScreen glc = new GameLostScreen(s, app);
    						glc.start();
    					}
    					
	    					//cur.moveMovable(mi, c)
    					if (map.condition().checkCC(map)) {
    						mazeController.setGrid();
    						System.out.println("Congrats!!! You won!!");
    						GameWonScreen gwc = new GameWonScreen(s,app);
    						gwc.start();
    					}
	    				
	    				mazeController.setGrid();
	    			}
	        	});
	            s.setScene(sc);
	            s.show();
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    

 
	 }
	    
}

