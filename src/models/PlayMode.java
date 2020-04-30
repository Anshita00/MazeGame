package models;


import java.util.*;
//import java.io.File;

import com.sun.glass.events.KeyEvent;

public class PlayMode implements State{
	
	private AppSystem app;
	public PlayMode(AppSystem app) {
		this.app = app;
	}
	
	@Override
	public void execute () {
		
		int i = 1;
		for (Map o : app.getMaps()) {
			System.out.print(o.getName() + " : ");
			System.out.println("Press " + i + " to choose this map");
			i++;
		}
		
		System.out.println("Please choose a map:");
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		try {
			if (sc.hasNextInt()) {
				choice = sc.nextInt();
			} else {
				throw new IncorrectInputException("Please enter a number");
			}
		} catch (IncorrectInputException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
			

		Map cur = null;
		try {
			cur = (Map)(app.getMaps().get(choice -1).clone());
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		}

		//cur.display();
		
		try {
			while(true) {
				System.out.print("Enter move: ");
				//key.setGame();
				char c = sc.next().charAt(0);
				if (c == 'r') {
					//cur.shootArrow();
				} else {
					cur.moveMovable(cur.getPlayer(), c);
	
					cur.pickupCollectibles();
					if (cur.gameLost()) {
						//cur.display();
						System.out.println("YOU LOSE");
						enterMainMenu();
					}
					//cur.moveMovable(mi, c)
					if (cur.condition().checkCC(cur)) {
						//cur.display();
						System.out.println("Congrats!!! You won!!");
						enterMainMenu();
					}
					//cur.display(); 
					System.out.println(cur.getPlayer().getItems());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (sc != null) sc.close();
		}		
		System.out.println();
		
	}
		//char newKey;

	@Override
	public void enterMainMenu() {
		app.changeState(app.getMainMenu());
		app.getState().execute();
		
	}

	@Override
	public void enterPlayMode() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterDesignMode() {
		// TODO Auto-generated method stub
		
	}

		/*
		key.setGame();
		key.showMaze();
		canner in = new Scanner(System.in);
		
		
		try {
		
			while(1==1) {
			in = new Scanner(System.in);
			System.out.print("Enter move: ");
			//key.setGame();
			key.setKey(in.next().charAt(0));
			System.out.println();
			key.showMaze();
			
		//	in.close();	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (in != null) in.close();
		}		
		System.out.println();
	}
	*/
	
}
