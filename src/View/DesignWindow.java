package View;


import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import models.AppSystem;
import models.Map;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class DesignWindow {

        private Stage s;
        private String title;
        private FXMLLoader fxmlLoader;
       // private Map newMap;

        private Node player;


        private Node player1;
        private Node player2;

        private DraggableNode node;
        private AppSystem app;
		private Map map;

        public DesignWindow(Stage s, AppSystem app, Map m) {
            this.s = s;
            this.title = "Design Mode";
            this.fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("View/DesignWindow.fxml"));

            this.app = app;
            this.map = m;
            //this.newMap = m;
        }

        
        public void start()  {
            s.setTitle(title);
            // set controller for start.fxml
            fxmlLoader.setController(new DesignWindowController(s, app, map));
            try {
                // load into a Parent node called root
                Parent root = fxmlLoader.load();
               
                //player1 = new ImageView("PlayerImage.png");

                player2 = new ImageView("View/invincPotion.png");
                //player1.prefHeight(60);
                //player1.prefWidth(60);
                
                //final double spacing = 30;
                //node = new DraggableNode(player2);
                //node.setPrefSize(98, 80);
                // define the style via css
                
                // position the node
                //node.setLayoutX(spacing*(1) + node.getPrefWidth()*1);
                //node.setLayoutY(spacing);
                // add the node to the root pane 
                
                
                //MouseControlUtil.makeDraggable(Player1);
                Group newGroup = new Group(root);
                //newGroup.getChildren().add(player1);
                //newGroup.getChildren().add(player2);
                //newGroup.getChildren().add(node);
                Scene sc = new Scene(newGroup, 600, 600);

                s.setScene(sc);
                s.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
        
    	public Group addPlayer(Parent root) {
            DesignWindowController newController = (DesignWindowController) fxmlLoader.getController();
    		player = new ImageView("View/player.png");
            //player1.prefHeight(60);
            //player1.prefWidth(60);
            
            final double spacing = 30;
            node = new DraggableNode(player);
            node.setPrefSize(98, 80);
            // define the style via css
            
            // position the node
            //double x = newController.getGridWithObjects().getChi
            //double y = newController.getGridWithObjects().getLayoutX();
            
            double x = 5;
            double y = 15;
            System.out.println("" + x + " " + y);
            node.setLayoutX(0);
            node.setLayoutY(550);
            // add the node to the root pane 
            
            
            //MouseControlUtil.makeDraggable(Player1);
            Group newGroup = new Group(root);
            //newGroup.getChildren().add(player1);
            //newGroup.getChildren().add(player2);
            newGroup.getChildren().add(node);
            
            return newGroup;
    	}
    	
	}



