package models;

import java.util.ArrayList;



public class AppSystem {
	
	// The 3 states corresponding to the app
	private State mainMenu;
	private State playMode;
	private State designMode;
	private State state;
	
	private ArrayList<Map> maps;
	
	// Constructor
	public AppSystem() {
		this.mainMenu = new MainMenu(this);
		this.playMode = new PlayMode(this);
		this.designMode = new DesignMode(this);
		this.state = mainMenu;
		this.maps = new ArrayList<Map>();
		CompletionCondition c = new CompletionConditionE();
		Map newMap = new Map(10,10, "default", c);
		newMap.addPlayer(0,0);
		
		newMap.addEntity(new Exit(9,9), 9, 9);
		
		newMap.addEntity(new Wall(1,1), 1, 1);
		newMap.addEntity(new Pit(1,2), 1, 2);
		Key k = new Key(3,3);
		newMap.addEntity(k,3,3);
		newMap.addEntity(new Door(3,2,k),3,2);	
		Key k2 = new Key(6,6);
		newMap.addEntity(k2, 6,6);
		newMap.addEntity(new Door(6,5,k2),6, 5);
		Treasure t = new Treasure(4,4);
		newMap.addEntity(t, 4, 4);
		Bomb b = new Bomb(5,5);
		newMap.addEntity(b,5, 5);
		newMap.addEntity(new HoverPotion(5,1),5, 1);
		newMap.addEntity(new InvincibilityPotion(7,8), 7, 8);
		newMap.addEntity(new Sword(8,1),8, 1);
		//newMap.addEntity(new Hunter(8, 8,0,0), 8, 8);
		//newMap.addEntity(new Hunter(2, 6,0,0), 2, 6);
		Hunter h = new Hunter(2,6,0,0);
		newMap.addEntity(h, 2, 6);
		Hound hound = new Hound(8,8,0,0,h);
		newMap.addEntity(hound, 8, 8);
		h.addHound(hound);
		newMap.addEntity(new Arrow(0, 6), 0, 6);
		//newMap.addEntity(new Coward(0,4,0,0), 0,4);
		newMap.addEntity(new FloorSwitch(6,7), 6,7);		
		newMap.addEntity(new Boulder(3,4), 3, 4);
		newMap.addEntity(new Boulder(5,9), 5, 9);
		newMap.addEntity(new Strategist(6,8,0,0), 6, 8);
		this.maps.add(newMap);
		
		c = new CompletionConditionB();
		newMap = new Map(10,10, "BoulderOnSwitch", c);
		newMap.addPlayer(0,0);
		
		newMap.addEntity(new Exit(9,9), 9, 9);
		
		newMap.addEntity(new Wall(1,1), 1, 1);
		newMap.addEntity(new Pit(1,2), 1, 2);
		k = new Key(3,3);
		newMap.addEntity(k,3,3);
		newMap.addEntity(new Door(3,2,k),3,2);	
		k2 = new Key(6,6);
		newMap.addEntity(k2, 6,6);
		newMap.addEntity(new Door(6,5,k2),6, 5);
		t = new Treasure(4,4);
		newMap.addEntity(t, 4, 4);
		b = new Bomb(5,5);
		newMap.addEntity(b,5, 5);
		newMap.addEntity(new HoverPotion(5,1),5, 1);
		newMap.addEntity(new InvincibilityPotion(7,8), 7, 8);
		newMap.addEntity(new Sword(8,1),8, 1);
		//newMap.addEntity(new Hunter(8, 8,0,0), 8, 8);
		//newMap.addEntity(new Hunter(2, 6,0,0), 2, 6);
		h = new Hunter(2,6,0,0);
		newMap.addEntity(h, 2, 6);
		hound = new Hound(8,8,0,0,h);
		newMap.addEntity(hound, 8, 8);
		h.addHound(hound);
		newMap.addEntity(new Arrow(0, 6), 0, 6);
		//newMap.addEntity(new Coward(0,4,0,0), 0,4);
		newMap.addEntity(new FloorSwitch(6,7), 6,7);		
		newMap.addEntity(new Boulder(3,4), 3, 4);
		newMap.addEntity(new Boulder(5,9), 5, 9);
		this.maps.add(newMap);
		
		
		c = new CompletionConditionT();
		newMap = new Map(10,10, "Treasure", c);
		newMap.addPlayer(0,0);
		
		newMap.addEntity(new Exit(9,9), 9, 9);
		
		newMap.addEntity(new Wall(1,1), 1, 1);
		newMap.addEntity(new Pit(1,2), 1, 2);
		k = new Key(3,3);
		newMap.addEntity(k,3,3);
		newMap.addEntity(new Door(3,2,k),3,2);	
		k2 = new Key(6,6);
		newMap.addEntity(k2, 6,6);
		newMap.addEntity(new Door(6,5,k2),6, 5);
		t = new Treasure(4,4);
		newMap.addEntity(t, 4, 4);
		b = new Bomb(5,5);
		newMap.addEntity(b,5, 5);
		newMap.addEntity(new HoverPotion(5,1),5, 1);
		newMap.addEntity(new InvincibilityPotion(7,8), 7, 8);
		newMap.addEntity(new Sword(8,1),8, 1);
		//newMap.addEntity(new Hunter(8, 8,0,0), 8, 8);
		//newMap.addEntity(new Hunter(2, 6,0,0), 2, 6);
		h = new Hunter(2,6,0,0);
		newMap.addEntity(h, 2, 6);
		hound = new Hound(8,8,0,0,h);
		newMap.addEntity(hound, 8, 8);
		h.addHound(hound);
		newMap.addEntity(new Arrow(0, 6), 0, 6);
		//newMap.addEntity(new Coward(0,4,0,0), 0,4);
		newMap.addEntity(new FloorSwitch(6,7), 6,7);		
		newMap.addEntity(new Boulder(3,4), 3, 4);
		newMap.addEntity(new Boulder(5,9), 5, 9);
		this.maps.add(newMap);
		
		
		c = new CompletionConditionD();
		newMap = new Map(10,10, "EnemiesKill", c);
		newMap.addPlayer(0,0);
		
		newMap.addEntity(new Exit(9,9), 9, 9);
		
		newMap.addEntity(new Wall(1,1), 1, 1);
		newMap.addEntity(new Pit(1,2), 1, 2);
		k = new Key(3,3);
		newMap.addEntity(k,3,3);
		newMap.addEntity(new Door(3,2,k),3,2);	
		k2 = new Key(6,6);
		newMap.addEntity(k2, 6,6);
		newMap.addEntity(new Door(6,5,k2),6, 5);
		t = new Treasure(4,4);
		newMap.addEntity(t, 4, 4);
		b = new Bomb(5,5);
		newMap.addEntity(b,5, 5);
		newMap.addEntity(new HoverPotion(5,1),5, 1);
		newMap.addEntity(new InvincibilityPotion(7,8), 7, 8);
		newMap.addEntity(new Sword(8,1),8, 1);
		//newMap.addEntity(new Hunter(8, 8,0,0), 8, 8);
		//newMap.addEntity(new Hunter(2, 6,0,0), 2, 6);
		h = new Hunter(2,6,0,0);
		newMap.addEntity(h, 2, 6);
		hound = new Hound(8,8,0,0,h);
		newMap.addEntity(hound, 8, 8);
		h.addHound(hound);
		newMap.addEntity(new Arrow(0, 6), 0, 6);
		//newMap.addEntity(new Coward(0,4,0,0), 0,4);
		newMap.addEntity(new FloorSwitch(6,7), 6,7);		
		newMap.addEntity(new Boulder(3,4), 3, 4);
		newMap.addEntity(new Boulder(5,9), 5, 9);
		this.maps.add(newMap);
		
		
		c = new CompletionConditionDT();
		newMap = new Map(10,10, "TreasureEnemies", c);
		newMap.addPlayer(0,0);
		
		newMap.addEntity(new Exit(9,9), 9, 9);
		
		newMap.addEntity(new Wall(1,1), 1, 1);
		newMap.addEntity(new Pit(1,2), 1, 2);
		k = new Key(3,3);
		newMap.addEntity(k,3,3);
		newMap.addEntity(new Door(3,2,k),3,2);	
		k2 = new Key(6,6);
		newMap.addEntity(k2, 6,6);
		newMap.addEntity(new Door(6,5,k2),6, 5);
		t = new Treasure(4,4);
		newMap.addEntity(t, 4, 4);
		b = new Bomb(5,5);
		newMap.addEntity(b,5, 5);
		newMap.addEntity(new HoverPotion(5,1),5, 1);
		newMap.addEntity(new InvincibilityPotion(7,8), 7, 8);
		newMap.addEntity(new Sword(8,1),8, 1);
		//newMap.addEntity(new Hunter(8, 8,0,0), 8, 8);
		//newMap.addEntity(new Hunter(2, 6,0,0), 2, 6);
		h = new Hunter(2,6,0,0);
		newMap.addEntity(h, 2, 6);
		hound = new Hound(8,8,0,0,h);
		newMap.addEntity(hound, 8, 8);
		h.addHound(hound);
		newMap.addEntity(new Arrow(0, 6), 0, 6);
		//newMap.addEntity(new Coward(0,4,0,0), 0,4);
		newMap.addEntity(new FloorSwitch(6,7), 6,7);		
		newMap.addEntity(new Boulder(3,4), 3, 4);
		newMap.addEntity(new Boulder(5,9), 5, 9);
		this.maps.add(newMap);
	}
	
	
	// Methods
	public void changeState(State state) {
		this.state = state;
	}
	
	public void enterMainMenu() {
		state.execute();
	}

	public void enterPlayMode() {
		state.execute();
	}
	
	public void enterDesignMode() {
		state.execute();
	}
	
	public void addMap(Map map) {
		this.maps.add(map);
	}
	
//	public void execute() {
//		state.execute();
//	}
	
	public State getState() {
		return state;
	}

	public ArrayList<Map> getMaps() {
		return maps;
	}
	
	
	// Getters
	public State getMainMenu() { 
		return this.mainMenu; 
	}
	public State getPlayMode() { 
		return this.playMode; 
	}
	public State getDesignMode() { 
		return this.designMode; 
	}
	
	
	public static void main(String[] args) {
		AppSystem as = new AppSystem();
		as.state.execute();
		
	}

	public void setState(State state) {
		this.state = state;
	}


}

