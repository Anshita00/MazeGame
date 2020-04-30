package View;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.EventHandler;
 
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import models.*;

import java.util.ArrayList;

import com.sun.javafx.collections.ChangeHelper;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.stage.Stage;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class DesignWindowController{

	@FXML
	public GridPane Board;
	public GridPane ShipsToBePlaced;
	public ImageView[][] water;
	public ImageView[] ships;
	public ImageView[][] ships2d;
	
    @FXML
    private Button backbutton;
    
	
    @FXML
    void backToMenu(ActionEvent event) {
    	StartScreen sc = new StartScreen(currStage,app);
    	sc.start();
    }
    
    private Stage currStage;
	private AppSystem app;
	private Map map;
	
	public DesignWindowController(Stage s, AppSystem app, Map m) {
	    currStage = s;
	    this.app = app;
	    this.map = m;
	    
	}
	
	public ImageView makeNewKey() {
		ImageView Tkey = new ImageView("View/key.png");
		Tkey.setPreserveRatio(true);
	    Tkey.setFitWidth(60);
		return Tkey;
	}
	
	public void initialize() {
	    //Adds water to each cell in grid
	    water = new ImageView[10][10];
	    //ships2d = new ImageView[10][10];
	    for(int i =0; i<10; i++) {
	        for(int j=0; j <10; j++){
	            water[i][j] = new ImageView("View/ground.png");
	            //water[i][j].setPreserveRatio(true);
	            water[i][j].setFitHeight(60);
	            water[i][j].setFitWidth(60);
	            Board.add(water[i][j], i, j);
	            //ships2d[i][j] = new ImageView("Ships/ship2.png");
	            //ships2d[i][j].setPreserveRatio(true);
	            //ships2d[i][j].setFitWidth(49);
	            //Board.add(ships2d[i][j], i, j);
	
	        }
	
    ImageView source = new ImageView ("View/player.png");
    source.setPreserveRatio(true);
    source.setFitHeight(60);
    source.setFitWidth(60);
    ShipsToBePlaced.add(source, 0, 0);

    
    ImageView key = new ImageView ("View/key.png");
    key.setPreserveRatio(true);
    key.setFitHeight(60);
    key.setFitWidth(60);
    ShipsToBePlaced.add(key, 1, 0);
    
    ImageView hunter = new ImageView ("View/hunter.png");
    hunter.setPreserveRatio(true);
    hunter.setFitHeight(60);
    hunter.setFitWidth(60);
    ShipsToBePlaced.add(hunter, 2, 0);
    
    ImageView sword = new ImageView ("View/sword.png");
    sword.setPreserveRatio(true);
    sword.setFitHeight(60);
    sword.setFitWidth(60);
    ShipsToBePlaced.add(sword, 3, 0);
    
    ImageView treasure = new ImageView ("View/treasure.png");
    treasure.setPreserveRatio(true);
    treasure.setFitHeight(60);
    treasure.setFitWidth(60);
    ShipsToBePlaced.add(treasure, 4, 0);
    
    ImageView strategist = new ImageView ("View/strategist.png");
    strategist.setPreserveRatio(true);
    strategist.setFitHeight(60);
    strategist.setFitWidth(60);
    ShipsToBePlaced.add(strategist, 5, 0);
    
    ImageView pit = new ImageView ("View/pit.png");
    pit.setPreserveRatio(true);
    pit.setFitHeight(60);
    pit.setFitWidth(60);
    ShipsToBePlaced.add(pit, 4, 1);
    
    ImageView arrow = new ImageView ("View/arrow.png");
    arrow.setPreserveRatio(true);
    arrow.setFitHeight(60);
    arrow.setFitWidth(60);
    ShipsToBePlaced.add(arrow, 3, 1);
    
    ImageView bomb = new ImageView ("View/bomb.png");
    bomb.setPreserveRatio(true);
    bomb.setFitHeight(60);
    bomb.setFitWidth(60);
    ShipsToBePlaced.add(bomb, 2, 1);
    
    ImageView coward = new ImageView ("View/coward.png");
    coward.setPreserveRatio(true);
    coward.setFitHeight(60);
    coward.setFitWidth(60);
    ShipsToBePlaced.add(coward, 1, 1);
    
    ImageView hound = new ImageView ("View/hound.png");
    hound.setPreserveRatio(true);
    hound.setFitHeight(60);
    hound.setFitWidth(60);
    ShipsToBePlaced.add(hound, 9, 0);
    
    ImageView invincibility = new ImageView ("View/invincPotion.png");
    invincibility.setPreserveRatio(true);
    invincibility.setFitHeight(60);
    invincibility.setFitWidth(60);
    ShipsToBePlaced.add(invincibility, 8, 0);
    
    ImageView hover = new ImageView ("View/hoverPotion.png");
    hover.setPreserveRatio(true);
    hover.setFitHeight(60);
    hover.setFitWidth(60);
    ShipsToBePlaced.add(hover, 7, 0);
    
    ImageView boulder = new ImageView ("View/boulder.png");
    boulder.setPreserveRatio(true);
    boulder.setFitHeight(60);
    boulder.setFitWidth(60);
    ShipsToBePlaced.add(boulder, 6, 0);
    
    ImageView wall = new ImageView ("View/wall.png");
    wall.setPreserveRatio(true);
    wall.setFitHeight(60);
    wall.setFitWidth(60);
    ShipsToBePlaced.add(wall, 0, 1);
    
    ImageView exit = new ImageView ("View/exit.png");
    exit.setPreserveRatio(true);
    exit.setFitHeight(60);
    exit.setFitWidth(60);
    ShipsToBePlaced.add(exit, 5, 1);
    
    ImageView switch1 = new ImageView ("View/floorSwitch.png");
    switch1.setPreserveRatio(true);
    switch1.setFitHeight(60);
    switch1.setFitWidth(60);
    ShipsToBePlaced.add(switch1, 6, 1);
    
    ImageView door = new ImageView ("View/closedDoor.png");
    door.setPreserveRatio(true);
    door.setFitHeight(60);
    door.setFitWidth(60);
    ShipsToBePlaced.add(door, 7, 1);
    
    final GridPane target = Board;

    //Drag detected event handler is used for adding drag functionality to the boat node
    source.setOnDragDetected(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            //Drag was detected, start drap-and-drop gesture
            //Allow any transfer node
            Dragboard db = source.startDragAndDrop(TransferMode.ANY);

            //Put ImageView on dragboard
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(source.getImage());
            //cbContent.put(DataFormat.)
            db.setContent(cbContent);
            source.setVisible(false);
            event.consume();
        }
    });
    
    strategist.setOnDragDetected(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            //Drag was detected, start drap-and-drop gesture
            //Allow any transfer node
            Dragboard db = strategist.startDragAndDrop(TransferMode.ANY);

            //Put ImageView on dragboard
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(strategist.getImage());
            //cbContent.put(DataFormat.)
            db.setContent(cbContent);
            strategist.setVisible(false);
            event.consume();
        }
    });
    hunter.setOnDragDetected(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            //Drag was detected, start drap-and-drop gesture
            //Allow any transfer node
            Dragboard db = hunter.startDragAndDrop(TransferMode.ANY);

            //Put ImageView on dragboard
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(hunter.getImage());
            //cbContent.put(DataFormat.)
            db.setContent(cbContent);
            hunter.setVisible(false);
            event.consume();
        }
    });
    sword.setOnDragDetected(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            //Drag was detected, start drap-and-drop gesture
            //Allow any transfer node
            Dragboard db = sword.startDragAndDrop(TransferMode.ANY);

            //Put ImageView on dragboard
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(sword.getImage());
            //cbContent.put(DataFormat.)
            db.setContent(cbContent);
            sword.setVisible(false);
            event.consume();
        }
    });
    treasure.setOnDragDetected(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            //Drag was detected, start drap-and-drop gesture
            //Allow any transfer node
            Dragboard db = treasure.startDragAndDrop(TransferMode.ANY);

            //Put ImageView on dragboard
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(treasure.getImage());
            //cbContent.put(DataFormat.)
            db.setContent(cbContent);
            treasure.setVisible(false);
            event.consume();
        }
    });
    
    key.setOnDragDetected(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            //Drag was detected, start drap-and-drop gesture
            //Allow any transfer node
            Dragboard db = key.startDragAndDrop(TransferMode.ANY);

            //Put ImageView on dragboard
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(key.getImage());
            //cbContent.put(DataFormat.)
            db.setContent(cbContent);
            key.setVisible(false);
            event.consume();
            //ShipsToBePlaced.add(makeNewKey(), 0, 2);        
        }
    });

    wall.setOnDragDetected(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            //Drag was detected, start drap-and-drop gesture
            //Allow any transfer node
            Dragboard db = wall.startDragAndDrop(TransferMode.ANY);

            //Put ImageView on dragboard
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(wall.getImage());
            //cbContent.put(DataFormat.)
            db.setContent(cbContent);
            wall.setVisible(false);
            event.consume();
            //ShipsToBePlaced.add(makeNewKey(), 0, 2);        
        }
    });
    
    exit.setOnDragDetected(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            //Drag was detected, start drap-and-drop gesture
            //Allow any transfer node
            Dragboard db = exit.startDragAndDrop(TransferMode.ANY);

            //Put ImageView on dragboard
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(exit.getImage());
            //cbContent.put(DataFormat.)
            db.setContent(cbContent);
            exit.setVisible(false);
            event.consume();
            //ShipsToBePlaced.add(makeNewKey(), 0, 2);        
        }
    });
    
    switch1.setOnDragDetected(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            //Drag was detected, start drap-and-drop gesture
            //Allow any transfer node
            Dragboard db = switch1.startDragAndDrop(TransferMode.ANY);

            //Put ImageView on dragboard
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(switch1.getImage());
            //cbContent.put(DataFormat.)
            db.setContent(cbContent);
            switch1.setVisible(false);
            event.consume();
            //ShipsToBePlaced.add(makeNewKey(), 0, 2);        
        }
    });
    boulder.setOnDragDetected(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            //Drag was detected, start drap-and-drop gesture
            //Allow any transfer node
            Dragboard db = boulder.startDragAndDrop(TransferMode.ANY);

            //Put ImageView on dragboard
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(boulder.getImage());
            //cbContent.put(DataFormat.)
            db.setContent(cbContent);
            boulder.setVisible(false);
            event.consume();
            //ShipsToBePlaced.add(makeNewKey(), 0, 2);        
        }
    });
    invincibility.setOnDragDetected(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            //Drag was detected, start drap-and-drop gesture
            //Allow any transfer node
            Dragboard db = invincibility.startDragAndDrop(TransferMode.ANY);

            //Put ImageView on dragboard
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(invincibility.getImage());
            //cbContent.put(DataFormat.)
            db.setContent(cbContent);
            invincibility.setVisible(false);
            event.consume();
            //ShipsToBePlaced.add(makeNewKey(), 0, 2);        
        }
    });
    
    hover.setOnDragDetected(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            //Drag was detected, start drap-and-drop gesture
            //Allow any transfer node
            Dragboard db = hover.startDragAndDrop(TransferMode.ANY);

            //Put ImageView on dragboard
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(hover.getImage());
            //cbContent.put(DataFormat.)
            db.setContent(cbContent);
            hover.setVisible(false);
            event.consume();
            //ShipsToBePlaced.add(makeNewKey(), 0, 2);        
        }
    });
    
    hound.setOnDragDetected(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            //Drag was detected, start drap-and-drop gesture
            //Allow any transfer node
            Dragboard db = hound.startDragAndDrop(TransferMode.ANY);

            //Put ImageView on dragboard
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(hound.getImage());
            //cbContent.put(DataFormat.)
            db.setContent(cbContent);
            hound.setVisible(false);
            event.consume();
            //ShipsToBePlaced.add(makeNewKey(), 0, 2);        
        }
    });
    
    door.setOnDragDetected(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            //Drag was detected, start drap-and-drop gesture
            //Allow any transfer node
            Dragboard db = door.startDragAndDrop(TransferMode.ANY);

            //Put ImageView on dragboard
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(door.getImage());
            //cbContent.put(DataFormat.)
            db.setContent(cbContent);
            door.setVisible(false);
            event.consume();
            //ShipsToBePlaced.add(makeNewKey(), 0, 2);        
        }
    });
    
    arrow.setOnDragDetected(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            //Drag was detected, start drap-and-drop gesture
            //Allow any transfer node
            Dragboard db = arrow.startDragAndDrop(TransferMode.ANY);

            //Put ImageView on dragboard
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(arrow.getImage());
            //cbContent.put(DataFormat.)
            db.setContent(cbContent);
            arrow.setVisible(false);
            event.consume();
            //ShipsToBePlaced.add(makeNewKey(), 0, 2);        
        }
    });
    
    coward.setOnDragDetected(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            //Drag was detected, start drap-and-drop gesture
            //Allow any transfer node
            Dragboard db = coward.startDragAndDrop(TransferMode.ANY);

            //Put ImageView on dragboard
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(coward.getImage());
            //cbContent.put(DataFormat.)
            db.setContent(cbContent);
            coward.setVisible(false);
            event.consume();
            //ShipsToBePlaced.add(makeNewKey(), 0, 2);        
        }
    });
    
    pit.setOnDragDetected(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            //Drag was detected, start drap-and-drop gesture
            //Allow any transfer node
            Dragboard db = pit.startDragAndDrop(TransferMode.ANY);

            //Put ImageView on dragboard
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(pit.getImage());
            //cbContent.put(DataFormat.)
            db.setContent(cbContent);
            pit.setVisible(false);
            event.consume();
            //ShipsToBePlaced.add(makeNewKey(), 0, 2);        
        }
    });
    
    bomb.setOnDragDetected(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            //Drag was detected, start drap-and-drop gesture
            //Allow any transfer node
            Dragboard db = bomb.startDragAndDrop(TransferMode.ANY);

            //Put ImageView on dragboard
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putImage(bomb.getImage());
            //cbContent.put(DataFormat.)
            db.setContent(cbContent);
            bomb.setVisible(false);
            event.consume();
            //ShipsToBePlaced.add(makeNewKey(), 0, 2);        
        }
    });
    
    
    //Drag over event handler is used for the receiving node to allow movement
    target.setOnDragOver(new EventHandler<DragEvent>() {
        public void handle(DragEvent event) {
            //data is dragged over to target
            //accept it only if it is not dragged from the same node
            //and if it has image data
            if(event.getGestureSource() != target && event.getDragboard().hasImage()){
                //allow for moving
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
            //ShipsToBePlaced.add(makeNewKey(), 0, 2);
        }
    });

    
    //Drag entered changes the appearance of the receiving node to indicate to the player that they can place there
    target.setOnDragEntered(new EventHandler<DragEvent>() {
        public void handle(DragEvent event) {
            //The drag-and-drop gesture entered the target
            //show the user that it is an actual gesture target
            if(event.getGestureSource() != target && event.getDragboard().hasImage()){
                source.setVisible(false);
                target.setOpacity(0.7);
                System.out.println("Drag entered");
            }
            event.consume();
            //ShipsToBePlaced.add(makeNewKey(), 0, 2);
        }
    });

    //Drag exited reverts the appearance of the receiving node when the mouse is outside of the node
    target.setOnDragExited(new EventHandler<DragEvent>() {
        public void handle(DragEvent event) {
            //mouse moved away, remove graphical cues
            source.setVisible(true);
            target.setOpacity(1);
            event.consume();
            //ShipsToBePlaced.add(makeNewKey(), 0, 2);
        }
    });

    //Drag dropped draws the image to the receiving node
    target.setOnDragDropped(new EventHandler<DragEvent>() {
    	public void handle(DragEvent event) {
    	    //Data dropped
    	    //If there is an image on the dragboard, read it and use it
    	    Dragboard db = event.getDragboard();
    	    boolean success = false;
    	    Node node = event.getPickResult().getIntersectedNode();
    	    if(node != target && db.hasImage()){

    	        Integer cIndex = GridPane.getColumnIndex(node);
    	        Integer rIndex = GridPane.getRowIndex(node);
    	        int x = cIndex == null ? 0 : cIndex;
    	        int y = rIndex == null ? 0 : rIndex;
    	        //target.setText(db.getImage()); --- must be changed to target.add(source, col, row)
    	        //target.add(source, 5, 5, 1, 1);
    	        //Places at 0,0 - will need to take coordinates once that is implemented
    	        ImageView image = new ImageView(db.getImage());

    	        // TODO: set image size; use correct column/row span
    	        Board.add(image, x, y, 1, 1);
    	        success = true;
    	    }
    	    //let the source know whether the image was successfully transferred and used
    	    event.setDropCompleted(success);

    	    event.consume();
    	    //ShipsToBePlaced.add(makeNewKey(), 0, 2);
    	}
    });

    source.setOnDragDone(new EventHandler<DragEvent>() {
        public void handle(DragEvent event) {
            //the drag and drop gesture has ended
            //if the data was successfully moved, clear it
            if(event.getTransferMode() == TransferMode.MOVE){
                source.setVisible(false);
            }
            event.consume();
            //ShipsToBePlaced.add(makeNewKey(), 0, 2);
        }
    });
}
	}
	}




