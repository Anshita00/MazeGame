package models;

import java.util.Scanner;

public class DesignMode implements State {
	
private AppSystem app;
	
	// Constructor
	public DesignMode(AppSystem app) {
		this.app = app;
	}
	
	@Override
	public void enterMainMenu() {
		app.changeState(app.getMainMenu());
		app.enterMainMenu();
	}

	@Override
	public void enterPlayMode() {
		app.enterPlayMode();
	}

	@Override
	public void enterDesignMode() {
		System.out.println("You are already in DesignMode!");
	}
	
	public void designGame() {
			
	}

	@Override
	public void execute() {
		System.out.println("Welcome to DesignMode!");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please type the name of your new map and press Enter ");
		String name = sc.nextLine(); 
		System.out.println("Enter the number of rows you want to have: ");
		int rows = Integer.parseInt(sc.nextLine()); 
		System.out.println("Enter the number of columns you want to have: ");
		int cols = Integer.parseInt(sc.nextLine());
		int correctInput = 0;
		CompletionCondition c = null;
		while (correctInput == 0) {
			System.out.println("Press 1 to have only the EXIT completion condition for your map");
			System.out.println("Press 2 to have only the BOULDER ON ALL SWITCHES (B) completion condition for your map");
			System.out.println("Press 3 to have only the DESTORY ALL ENEMIES (D) completion condition for your map");
			System.out.println("Press 4 to have only the COLLECT ALL TREASURE (T) completion condition for your map");
			System.out.println("Press 5 for the BD combination");
			System.out.println("Press 6 for the BT combination");
			System.out.println("Press 7 for the DT combination");
			System.out.println("Press 8 for the BDT combination");
			String condition = sc.nextLine();
			if (condition.equals("1")) {
				c = new CompletionConditionE(); correctInput = 1;
			} else if (condition.equals("2")) {
				c = new CompletionConditionB(); correctInput = 1;
			} else if (condition.equals("3")) {
				c = new CompletionConditionD(); correctInput = 1;
			} else if (condition.equals("4")) {
				c = new CompletionConditionT(); correctInput = 1;
			} else if (condition.equals("5")) {
				c = new CompletionConditionBD(); correctInput = 1;
			} else if (condition.equals("6")) {
				c = new CompletionConditionBT(); correctInput = 1;
			} else if (condition.equals("7")) {
				c = new CompletionConditionDT(); correctInput = 1;
			} else if (condition.equals("8")) {
				c = new CompletionConditionBDT(); correctInput = 1;
			} else { continue; }
		}
		Map newMap = new Map(rows, cols, name, c);
		System.out.println("This is the empty map");
		newMap.display();
		System.out.println("Enter the row of the Player (index starting from 0)");
		int prow = Integer.parseInt(sc.nextLine());
		System.out.println("Enter the columnn of the Player (index starting from 0)");
		int pcol = Integer.parseInt(sc.nextLine());
		newMap.addPlayer(prow, pcol);
		while(true) {
			System.out.println("Press a to add an ARROW to the map");
			System.out.println("Press b to add an BOULDER to the map");
			System.out.println("Press c to add an COWARD to the map");
			System.out.println("Press e to add an EXIT to the map");
			System.out.println("Press f to add a FLOOR SWITCH to the map");
			System.out.println("Press g to add a STRATEGIST to the map");
			System.out.println("Press h to add a HUNTER-HOUND combo to the map");
			System.out.println("Press i to add an INVINCIBILITY POTION to the map");
			System.out.println("Press j to add a HOVER POTION to the map");
			System.out.println("Press k to add a KEY-DOOR combination to the map");
			System.out.println("Press n to add a HUNTER to the map");
			System.out.println("***Press p to add a PLAYER to the map***");
			System.out.println("Press q to add a PIT to the map");
			System.out.println("Press r to add a SWORD to the map");
			System.out.println("Press t to add a TREASURE to the map");
			System.out.println("Press u to add an UNLIT BOMB to the map");
			System.out.println("Press w to add a WALL to the map");
			System.out.println("***Press s to SAVE, and get back to the main menu***");

			String result = sc.nextLine();
			if (result.equals("s")) { 
				app.addMap(newMap);
				enterMainMenu();
				break; 
			}  else if (result.equals("a")) {
				System.out.println("Enter the row of the Arrow (index starting from 0)");
				int row = Integer.parseInt(sc.nextLine());
				System.out.println("Enter the columnn of the Arrow (index starting from 0)");
				int col = Integer.parseInt(sc.nextLine());
				Arrow a = new Arrow(row, col);
				newMap.addEntity(a, row, col);
			} else if (result.equals("b")) {
				System.out.println("Enter the row of the Boulder (index starting from 0)");
				int row = Integer.parseInt(sc.nextLine());
				System.out.println("Enter the columnn of the Boulder (index starting from 0)");
				int col = Integer.parseInt(sc.nextLine());
				Boulder b = new Boulder(row, col);
				newMap.addEntity(b, row, col);
			} else if (result.equals("c")) {
				System.out.println("Enter the row of the Coward (index starting from 0)");
				int row = Integer.parseInt(sc.nextLine());
				System.out.println("Enter the columnn of the Coward (index starting from 0)");
				int col = Integer.parseInt(sc.nextLine());
				Player p = newMap.getPlayer();
				Coward coward = new Coward(row, col, p.getRow(), p.getColumn());
				newMap.addEntity(coward, row, col);
			}  else if (result.equals("e")) {
				System.out.println("Enter the row of the exit (index starting from 0)");
				int erow = Integer.parseInt(sc.nextLine());
				System.out.println("Enter the columnn of the exit (index starting from 0)");
				int ecol = Integer.parseInt(sc.nextLine());
				Exit e = new Exit(erow, ecol);
				newMap.addExit(erow, ecol);
			} else if (result.equals("f")) {
				System.out.println("Enter the row of the Floor Switch (index starting from 0)");
				int row = Integer.parseInt(sc.nextLine());
				System.out.println("Enter the columnn of the exit (index starting from 0)");
				int col = Integer.parseInt(sc.nextLine());
				FloorSwitch f = new FloorSwitch(row, col);
				newMap.addEntity(f, row, col);
			} else if (result.equals("g")) {
				System.out.println("Enter the row of the Strategist (index starting from 0)");
				int row = Integer.parseInt(sc.nextLine());
				System.out.println("Enter the columnn of the Strategist (index starting from 0)");
				int col = Integer.parseInt(sc.nextLine());
				Strategist s = new Strategist(row, col, newMap.getPlayer().getRow(), newMap.getPlayer().getColumn());
				newMap.addEntity(s, row, col);
			} else if (result.equals("h")) {
				System.out.println("Enter the row of the Hunter (index starting from 0)");
				int row = Integer.parseInt(sc.nextLine());
				System.out.println("Enter the columnn of the Hunter (index starting from 0)");
				int col = Integer.parseInt(sc.nextLine());
				Hunter h = new Hunter(row, col, newMap.getPlayer().getRow(), newMap.getPlayer().getColumn());
				newMap.addEntity(h, row, col);
				System.out.println("Do you want to enter a Hound? (Y/N)");
				char choice = sc.nextLine().charAt(0);
				if (choice == 'Y' || choice == 'y') {
					System.out.println("Enter the row of the Hound (index starting from 0)");
					row = Integer.parseInt(sc.nextLine());
					System.out.println("Enter the columnn of the Hound (index starting from 0)");
					col = Integer.parseInt(sc.nextLine());
					Hound newHound = new Hound(row, col,newMap.getPlayer().getRow(), newMap.getPlayer().getColumn(), h);
					newMap.addEntity(newHound, row, col);
					h.addHound(newHound);
				}
			} else if (result.equals("i")) {
				System.out.println("Enter the row of the Invincibility Potion (index starting from 0)");
				int row = Integer.parseInt(sc.nextLine());
				System.out.println("Enter the columnn of the Invincibility Potion (index starting from 0)");
				int col = Integer.parseInt(sc.nextLine());
				InvincibilityPotion i = new InvincibilityPotion(row, col);
				newMap.addEntity(i, row, col);
			} else if (result.equals("j")) {
				System.out.println("Enter the row of the Hover Potion (index starting from 0)");
				int row = Integer.parseInt(sc.nextLine());
				System.out.println("Enter the columnn of the Hover Potion (index starting from 0)");
				int col = Integer.parseInt(sc.nextLine());
				HoverPotion hp = new HoverPotion(row, col);
				newMap.addEntity(hp, row, col);
			} else if (result.equals("k")) {
				System.out.println("Enter the row of the Key (index starting from 0)");
				int row = Integer.parseInt(sc.nextLine());
				System.out.println("Enter the columnn of the Key (index starting from 0)");
				int col = Integer.parseInt(sc.nextLine());
				Key k = new Key(row, col);
				newMap.addEntity(k, row, col);
				System.out.println("Enter the row of the Door (index starting from 0)");
				row = Integer.parseInt(sc.nextLine());
				System.out.println("Enter the columnn of the Door (index starting from 0)");
				col = Integer.parseInt(sc.nextLine());
				Door d = new Door(row, col, k);
				newMap.addEntity(d, row, col);
			} else if (result.equals("q")) {
				System.out.println("Enter the row of the Pit (index starting from 0)");
				int row = Integer.parseInt(sc.nextLine());
				System.out.println("Enter the columnn of the Pit (index starting from 0)");
				int col = Integer.parseInt(sc.nextLine());
				Pit p = new Pit(row, col);
				newMap.addEntity(p, row, col);
			} else if (result.equals("r")) {
				System.out.println("Enter the row of the Sword (index starting from 0)");
				int row = Integer.parseInt(sc.nextLine());
				System.out.println("Enter the columnn of the Sword (index starting from 0)");
				int col = Integer.parseInt(sc.nextLine());
				Sword r = new Sword(row, col);
				newMap.addEntity(r, row, col);
			} else if (result.equals("t")) {
				System.out.println("Enter the row of the Treasure (index starting from 0)");
				int row = Integer.parseInt(sc.nextLine());
				System.out.println("Enter the columnn of the Treasure (index starting from 0)");
				int col = Integer.parseInt(sc.nextLine());
				Treasure t = new Treasure(row, col);
				newMap.addEntity(t, row, col);
			} else if (result.equals("u")) {
				System.out.println("Enter the row of the Unlit Bomb (index starting from 0)");
				int row = Integer.parseInt(sc.nextLine());
				System.out.println("Enter the columnn of the Unlit Bomb (index starting from 0)");
				int col = Integer.parseInt(sc.nextLine());
				Bomb b = new Bomb(row, col);
				newMap.addEntity(b, row, col);
			} else if (result.equals("w")) {
				System.out.println("Enter the row of the Wall (index starting from 0)");
				int row = Integer.parseInt(sc.nextLine());
				System.out.println("Enter the columnn of the Wall (index starting from 0)");
				int col = Integer.parseInt(sc.nextLine());
				Wall w = new Wall(row, col);
				newMap.addEntity(w, row, col);
			} else {
				System.out.println("YOU HAVE ENTERED INVALID INPUT! so nothing happened.");
				System.out.println("YOU CAN TRY AGAIN TO ATTEMPT A VALID INPUT");
			}
			System.out.println("Your map now looks like this!");
			newMap.display();
		}
		
	}
	
//	void placeEntity(String name) {
//		
//	}

}
