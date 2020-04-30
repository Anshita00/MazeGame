package models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestGame {
	
	@Test
	public void testWall() {
		
		//Check that player does not cross walls.
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionE();
		Map newMap = new Map(10,10, "default", c);
	
		Player p1 = new Player(0,0);
		
		newMap.addPlayer(0, 0);
		newMap.addEntity(new Exit(9,9), 9, 9);
		newMap.addEntity(new Wall(1,1), 1, 1);
		newMap.addEntity(new Wall(2,2), 2, 2);
		newMap.addEntity(new Wall(3,1), 3, 1);
		newMap.addEntity(new Wall(4,1), 4, 1);
		newMap.addEntity(new Wall(5,1), 5, 1);
		newMap.addEntity(new Wall(5,2), 5, 2);
		newMap.addEntity(new Wall(5,3), 5, 3);
		
	
		//checking position of player
		assertTrue(newMap.getGrid(0,0).checkEntity(p1));
		newMap.moveMovable(p1, 's');
		newMap.moveMovable(p1, 'd');
		newMap.display();
		System.out.println();
		
		//check that player doesn't cross the wall
		assertTrue(newMap.getGrid(1,0).checkEntity(p1));
		
		newMap.moveMovable(p1, 'w');
		newMap.moveMovable(p1, 'd');
		newMap.moveMovable(p1, 'd');
		newMap.moveMovable(p1, 's');
		
		
		//checking the wall from the other side
		assertTrue(newMap.getGrid(1,2).checkEntity(p1));
		
		as.getMaps().add(newMap);
		newMap.display();
		
		//as.getMaps().remove(0);
		//assertEquals(as.getMaps().size(), 0);
		
	}	
	
	@Test
	public void testExit() {
		
		//Check completion condition Reach the Exit.
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionE();
		Map newMap = new Map(10,10, "default", c);
		
		newMap.addPlayer(0, 0);
		newMap.addEntity(new Exit(9,9), 9, 9);
		Player p1 = newMap.getPlayer();
		
		System.out.println();

		
		int i = 8;
		while(i >= 0) {
			newMap.moveMovable(p1, 'd');
			i--;
		}
		
		newMap.display();
		System.out.println();

		i = 8;
		while(i >= 0) {
			newMap.moveMovable(p1, 's');
			i--;
		}
		
		newMap.display();
		System.out.println();
		
		assertTrue(newMap.condition().checkCC(newMap));
		
		
		//assertTrue(newMap.gameWon());
		as.getMaps().add(newMap);
		//as.getState().execute();
	}
	
	@Test
	public void testInvincibility() {
		
		//Check that it kills all the enemies and the completion condition 
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionD();
		Map newMap = new Map(10,10, "default", c);
		
		newMap.addPlayer(0, 0);
		newMap.addEntity(new Sword(1,1), 1, 1);
		newMap.addEntity(new Hunter(5,6, 0, 0), 5, 6);
		newMap.addEntity(new Hunter(7,4, 0, 0), 7, 4);
		newMap.addEntity(new Hunter(1,4, 0, 0), 1, 4);
		newMap.addEntity(new Hunter(7,7, 0, 0), 7, 7);
		newMap.addEntity(new Hunter(7,5, 0, 0), 7, 5);
		newMap.addEntity(new Hunter(3,6, 0, 0), 3, 6);
		newMap.addEntity(new InvincibilityPotion(3,3), 3, 3);
		
		
		Player p1 = newMap.getPlayer();
		
		
		newMap.moveMovable(p1, 'd');
		newMap.moveMovable(p1, 's');
		//picks up sword
		newMap.pickupCollectibles();
		newMap.moveMovable(p1, 's');
		newMap.moveMovable(p1, 's');
		newMap.moveMovable(p1, 'd');
		newMap.moveMovable(p1, 'd');
		
		//pickup collectible invincibility Potion
		newMap.pickupCollectibles();
		
		//check that invincibility potion is picked up and the tile is empty now
		assertNotEquals(newMap.getGrid(3, 3), new InvincibilityPotion(3,3));
		assertTrue(p1.invincible());
		assertTrue(p1.hasSword());
		
		newMap.moveMovable(p1, 'd');
		newMap.moveMovable(p1, 'w');
		newMap.moveMovable(p1, 'w');
		
		//try to kill hunter
		assertFalse(newMap.gameLost());
		
		//check Invincibilty potion is not at the tile where it was placed before
		assertNotEquals(newMap.getGrid(3, 3), new InvincibilityPotion(3,3));
		
		//newMap.display();
		
		newMap.moveMovable(p1, 'd');
		newMap.moveMovable(p1, 'd');
		newMap.moveMovable(p1, 's');
		newMap.moveMovable(p1, 's');
		
		//try to kill hunter
		assertFalse(newMap.gameLost());

		newMap.moveMovable(p1, 's');
		//newMap.display();
		newMap.moveMovable(p1, 's');
		//newMap.display();
		
		
		//try to kill hunter
		assertFalse(newMap.gameLost());
		assertNotEquals(newMap.getGrid(5, 6), new Hunter(5, 6, 0, 0));
		
		newMap.moveMovable(p1, 's');
		newMap.moveMovable(p1, 's');
		newMap.moveMovable(p1, 'a');
		assertFalse(newMap.gameLost());
		
		newMap.moveMovable(p1, 'a');
		
		assertFalse(newMap.gameLost());
		
		newMap.moveMovable(p1, 'd');
		newMap.moveMovable(p1, 'd');
		newMap.moveMovable(p1, 'd');
		assertTrue(newMap.gameLost());
		
		newMap.display();
		
		assertFalse(newMap.condition().checkCC(newMap));
		
		
		newMap.display();
		System.out.println();
		
		//check if he won the game and game condition is satisfied..(should not be true)
		assertFalse(newMap.condition().checkCC(newMap));
		
		//add and display map
		as.getMaps().add(newMap);
		//as.getState().execute();
	}
	
	
	@Test
	void testPlayerDeadInPit1() {
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionE();
		Map newMap = new Map(10,10, "default", c);
		newMap.addPlayer(0,0);
		newMap.addEntity(new Exit(9,9), 9, 9);
		newMap.addEntity(new Pit(1,0), 1, 0);
		as.addMap(newMap);
		//as.getState().execute();
		//as.getPlayMode().enterPlayMode();
		
		newMap.moveMovable(newMap.getPlayer(), 's');
		assertTrue(newMap.checkPlayerDead());
	}
	@Test
	void testPlayerDeadInPit2() {
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionE();
		Map newMap = new Map(10,10, "default", c);
		newMap.addPlayer(1,0);
		newMap.addEntity(new Exit(9,9), 9, 9);
		newMap.addEntity(new Pit(1,1), 1, 1);
		as.addMap(newMap);
		//as.getState().execute();
		//as.getPlayMode().enterPlayMode();
		
		newMap.moveMovable(newMap.getPlayer(), 'd');
		assertTrue(newMap.checkPlayerDead());
	}
	@Test
	void testPlayerDeadInPit3() {
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionE();
		Map newMap = new Map(10,10, "default", c);
		newMap.addPlayer(0,1);
		newMap.addEntity(new Exit(9,9), 9, 9);
		newMap.addEntity(new Pit(0,0), 0, 0);
		as.addMap(newMap);
		//as.getState().execute();
		//as.getPlayMode().enterPlayMode();
		
		newMap.moveMovable(newMap.getPlayer(), 'a');
		assertTrue(newMap.checkPlayerDead());
	}
	@Test
	void testPlayerDeadInPit4() {
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionE();
		Map newMap = new Map(10,10, "default", c);
		newMap.addPlayer(1,0);
		newMap.addEntity(new Exit(9,9), 9, 9);
		newMap.addEntity(new Pit(0,0), 0, 0);
		as.addMap(newMap);
		//as.getState().execute();
		//as.getPlayMode().enterPlayMode();
		
		newMap.moveMovable(newMap.getPlayer(), 'w');
		assertTrue(newMap.checkPlayerDead());
	}

	@Test
	void testBoulderDisapperInPit1() {
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionE();
		Map newMap = new Map(10,10, "default", c);
		newMap.addPlayer(0,0);
		newMap.addEntity(new Exit(9,9), 9, 9);
		newMap.addEntity(new Pit(2,0), 2, 0);
		Boulder b = new Boulder(1,0);
		newMap.addEntity(b, 1, 0);
		as.addMap(newMap);
		//as.getState().execute();
		//as.getPlayMode().enterPlayMode();
		
		newMap.moveMovable(newMap.getPlayer(), 's');
		assertFalse(newMap.getTile(2, 0).checkEntity(b));
	}
	
	@Test
	void testBoulderDisapperInPit2() {
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionE();
		Map newMap = new Map(10,10, "default", c);
		newMap.addPlayer(2,0);
		newMap.addEntity(new Exit(9,9), 9, 9);
		newMap.addEntity(new Pit(2,2), 2, 2);
		Boulder b = new Boulder(2,1);
		newMap.addEntity(b, 2, 1);
		as.addMap(newMap);
		//as.getState().execute();
		//as.getPlayMode().enterPlayMode();
		
		newMap.moveMovable(newMap.getPlayer(), 'd');
		assertFalse(newMap.getTile(2, 0).checkEntity(b));
	}
	
	@Test
	void testBoulderDisapperInPit3() {
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionE();
		Map newMap = new Map(10,10, "default", c);
		newMap.addPlayer(2,4);
		newMap.addEntity(new Exit(9,9), 9, 9);
		newMap.addEntity(new Pit(2,2), 2, 2);
		Boulder b = new Boulder(2,3);
		newMap.addEntity(b, 2, 3);
		as.addMap(newMap);
		//as.getState().execute();
		//as.getPlayMode().enterPlayMode();
		
		newMap.moveMovable(newMap.getPlayer(), 'a');
		assertFalse(newMap.getTile(2, 2).checkEntity(b));
	}
	
	
	@Test
	void testBoulderDisapperInPit4() {
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionE();
		Map newMap = new Map(10,10, "default", c);
		newMap.addPlayer(4,0);
		newMap.addEntity(new Exit(9,9), 9, 9);
		newMap.addEntity(new Pit(2,0), 2, 0);
		Boulder b = new Boulder(3,0);
		newMap.addEntity(b, 3, 0);
		as.addMap(newMap);
		//as.getState().execute();
		//as.getPlayMode().enterPlayMode();
		
		newMap.moveMovable(newMap.getPlayer(), 'w');
		assertFalse(newMap.getTile(2, 0).checkEntity(b));
	}
	
	@Test
	void testMaxOneKeyPickup() {
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionE();
		Map newMap = new Map(10,10, "default", c);
		newMap.addPlayer(3,3);
		newMap.addEntity(new Exit(9,9), 9, 9);
		
		Key key1 = new Key(3,4);
		Key key2 = new Key(3,5);
		
		
		newMap.addEntity(key1, 3, 4);
		newMap.addEntity(key2, 3, 5);
		
		as.addMap(newMap);
		newMap.moveMovable(newMap.getPlayer(), 'd');
		newMap.pickupCollectibles();
		assertTrue(newMap.getPlayer().hasItem(key1));
		assertFalse(newMap.getTile(3, 4).checkEntity(key1));
		
		newMap.moveMovable(newMap.getPlayer(), 'd');
		newMap.pickupCollectibles();
		assertTrue(newMap.getTile(3, 5).checkEntity(key2));
	}
	
	@Test
	void testOpenDoor() {
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionE();
		Map newMap = new Map(10,10, "default", c);
		newMap.addPlayer(4,3);
		newMap.addEntity(new Exit(9,9), 9, 9);
		
		Key key = new Key(4,4);
		Door door = new Door(4,5,key);
		
	
		newMap.addEntity(key, 4, 4);
		newMap.addEntity(door, 4, 5);
		as.addMap(newMap);
		// pick up key
		newMap.moveMovable(newMap.getPlayer(), 'd');
		newMap.pickupCollectibles();
		assertTrue(newMap.getPlayer().hasItem(key));
		
		// open the door
		newMap.moveMovable(newMap.getPlayer(), 'd');
		
		assertTrue(door.closed==false);
		
		// go through the door
		newMap.moveMovable(newMap.getPlayer(), 'd');
		assertTrue(newMap.getPlayer().getRow()==4);
		assertTrue(newMap.getPlayer().getColumn()==6);
		
	}
	
	@Test
	void testWrongKeysOpenDoor() {
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionE();
		Map newMap = new Map(10,10, "default", c);
		newMap.addPlayer(4,3);
		newMap.addEntity(new Exit(9,9), 9, 9);
		
		Key key1 = new Key(4,2);
		Key key2 = new Key(4,4);
		Door door = new Door(4,5,key1);
		
	
		newMap.addEntity(key1, 4, 2);
		newMap.addEntity(key2, 4, 4);
		newMap.addEntity(door, 4, 5);
		as.addMap(newMap);
		// pick up key
		newMap.moveMovable(newMap.getPlayer(), 'd');
		newMap.pickupCollectibles();
		assertTrue(newMap.getPlayer().hasItem(key2));
		
		// try to open the door with wrong key
		newMap.moveMovable(newMap.getPlayer(), 'd');
		
		assertTrue(door.closed==true);
		
		// try to go through the door
		newMap.moveMovable(newMap.getPlayer(), 'd');
		assertTrue(newMap.getPlayer().getRow()==4);
		assertTrue(newMap.getPlayer().getColumn()==4);
		
	}

	// Testing pushing all boulders to floor switches works
	@Test
	void testBoulderFloorSwitches() {
		CompletionCondition c = new CompletionConditionB();
		Map newMap = new Map(10,10, "default", c);
		newMap.addPlayer(0, 0);
		newMap.addEntity(new Boulder(1,0), 1, 0);
		newMap.addEntity(new Boulder(0,1), 0, 1);
		newMap.addEntity(new FloorSwitch(2,0), 2, 0);
		newMap.addEntity(new FloorSwitch(0,2), 0, 2);
		Player p = newMap.getPlayer();
		newMap.moveMovable(p, 'd');
		assertFalse(c.checkCC(newMap));
		newMap.moveMovable(p, 'a');
		assertFalse(c.checkCC(newMap));
		newMap.moveMovable(p, 's');
		assertTrue(c.checkCC(newMap));
	}
	
	@Test
	void testHoverPotionWorks() {
		CompletionCondition c = new CompletionConditionB();
		Map newMap = new Map(10,10, "default", c);
		newMap.addPlayer(0, 0);
		newMap.addEntity(new Pit(0,2), 0, 2);
		newMap.addEntity(new HoverPotion(0,1),0, 1);
		Player p = newMap.getPlayer();
		newMap.moveMovable(p,'d');
		assertFalse(newMap.gameLost());
		newMap.pickupCollectibles();
		newMap.moveMovable(p, 'd');
		assertFalse(newMap.gameLost());
	}
	
	@Test
	void testDestroyingHunter() {
		CompletionCondition c = new CompletionConditionD();
		Map newMap = new Map(10,10, "default", c);
		newMap.addPlayer(0, 0);
		Hunter h = new Hunter(0,3, 0, 0);
		newMap.addEntity(h, 0, 3);
		newMap.addEntity(new Sword(0,1), 0, 1);
		Player p = newMap.getPlayer();
		newMap.moveMovable(p, 'd');
		newMap.pickupCollectibles();
		newMap.moveMovable(p, 'd');
		assertFalse(newMap.gameLost());
		assertFalse(newMap.containsEnemy());
		assertTrue(c.checkCC(newMap));
	}
	
	@Test
	void testDestroyingCoward() {
		CompletionCondition c = new CompletionConditionD();
		Map newMap = new Map(10,10, "default", c);
		newMap.addPlayer(0, 0);
		Coward coward = new Coward(0,3, 0, 0);
		newMap.addEntity(coward, 0, 3);
		newMap.addEntity(new Sword(0,1), 0, 1);
		Player p = newMap.getPlayer();
		newMap.moveMovable(p, 'd');
		newMap.pickupCollectibles();
		newMap.moveMovable(p, 'd');
		newMap.moveMovable(p, 'd');
		newMap.moveMovable(p, 'd');
		newMap.moveMovable(p, 'd'); 
		newMap.moveMovable(p, 'd'); 
		newMap.moveMovable(p, 'd'); 
		newMap.moveMovable(p, 'd');
		newMap.moveMovable(p, 'd'); 
		assertFalse(newMap.gameLost());
		assertFalse(newMap.containsEnemy());
		assertTrue(c.checkCC(newMap));
	}
	
	@Test
	void testDestroyingHoundAndHunter()  {
		CompletionCondition c = new CompletionConditionD();
		Map newMap = new Map(10,10, "default", c);
		newMap.addPlayer(0, 0);
		Hunter h = new Hunter(0,4, 0, 0);
		Hound h1 = new Hound(0,3,0,0,h);
		assertTrue(newMap.addEntity(h, 0, 4));
		assertTrue(newMap.addEntity(h1, 0, 3));
		newMap.addEntity(new Sword(0,1), 0, 1);
		Player p = newMap.getPlayer();
		newMap.moveMovable(p, 'd');
		newMap.pickupCollectibles();
		newMap.moveMovable(p, 'd');
		newMap.moveMovable(p, 'd');
		assertFalse(newMap.checkPlayerDead());
		newMap.moveMovable(p, 'd');
		assertFalse(newMap.checkPlayerDead());
		newMap.moveMovable(p, 'd');
		newMap.moveMovable(p, 'd');
		newMap.moveMovable(p, 'a');
		newMap.moveMovable(p, 'a');
		newMap.moveMovable(p, 'a');
		newMap.moveMovable(p, 'a');
		newMap.moveMovable(p, 'a');
		newMap.moveMovable(p, 'a');
		assertFalse(newMap.checkPlayerDead());
		assertFalse(newMap.checkPlayerDead());
		assertFalse(newMap.containsEnemy());
		assertTrue(c.checkCC(newMap));
	}
	
	@Test
	void testDestroyingStrategist() {
		CompletionCondition c = new CompletionConditionD();
		Map newMap = new Map(10,10, "default", c);
		newMap.addPlayer(0, 0);
		Strategist s = new Strategist(0,2, 0, 0);
		assertTrue(newMap.addEntity(s, 0, 2));
		newMap.addEntity(new Sword(0,1), 0, 1);
		Player p = newMap.getPlayer();
		newMap.moveMovable(p, 'd');
		newMap.pickupCollectibles();
		newMap.moveMovable(p, 'd');
		assertFalse(newMap.checkPlayerDead());
		assertFalse(newMap.containsEnemy());
		assertTrue(c.checkCC(newMap));
		
	}
	
	@Test
	void testStrategist() {
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionE();
		Map newMap = new Map(10,10, "default", c);
		newMap.addPlayer(0,0);
		newMap.addEntity(new Exit(9,9), 9, 9);
		
		Strategist s = new Strategist(7,8,0,0);
		
		newMap.addEntity(s, 7, 8);
		
		as.addMap(newMap);
		char[] move = {'a','s','d','w','s','d','w','a','s','d','a'};
		int i = 0;
		while (!newMap.checkPlayerDead()) {
			newMap.moveMovable(newMap.getPlayer(), move[i % 10]);
			newMap.moveEnemies();
			i++;
		}
		
		assertTrue(newMap.checkPlayerDead());
		assertTrue(s.getRow()==newMap.getPlayer().getRow());
		assertTrue(s.getColumn()==newMap.getPlayer().getColumn());
	}
	
	// Test containsEnemy method in Map class
	@Test
	void test_containsEnemy() {
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionD();
		Map newMap = new Map(10,10, "ArrowMap", c);
		newMap.addPlayer(0,0);
		newMap.addEntity(new Hunter(0, 7,0,0), 0, 7);
		assertTrue(newMap.containsEnemy());
	}
	
	// Test shooting an arrow in the right direction
	@Test
	void test_arrow_right() {
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionD();
		Map newMap = new Map(10,10, "ArrowMap", c);
		newMap.addPlayer(0,0);
		assertFalse(newMap.containsEnemy());
		newMap.addEntity(new Hunter(0, 7,0,0), 0, 7);
		assertTrue(newMap.containsEnemy());
		newMap.ArrowRight();
		assertFalse(newMap.containsEnemy());
	}
	
	// Test shooting an arrow in the left direction
	@Test
	void test_arrow_left() {
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionD();
		Map newMap = new Map(10,10, "ArrowMap", c);
		newMap.addPlayer(0,8);
		assertFalse(newMap.containsEnemy());
		newMap.addEntity(new Hunter(0,1,0,8), 0, 1);
		assertTrue(newMap.containsEnemy());
		newMap.ArrowLeft();
		assertFalse(newMap.containsEnemy());
	}
	
	// Test shooting an arrow in the up direction
	@Test
	void test_arrow_up() {
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionD();
		Map newMap = new Map(10,10, "ArrowMap", c);
		newMap.addPlayer(5,5);
		assertFalse(newMap.containsEnemy());
		newMap.addEntity(new Hunter(0,5,5,5), 0, 5);
		assertTrue(newMap.containsEnemy());
		newMap.ArrowUp();
		assertFalse(newMap.containsEnemy());
	}
	
	// Test shooting an arrow in the down direction
	@Test
	void test_arrow_down() {
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionD();
		Map newMap = new Map(10,10, "ArrowMap", c);
		newMap.addPlayer(0,5);
		assertFalse(newMap.containsEnemy());
		newMap.addEntity(new Hunter(5,5,0,5), 5, 5);
		assertTrue(newMap.containsEnemy());
		newMap.ArrowDown();
		assertFalse(newMap.containsEnemy());
	}
	
	// Test hasArrow method in Player class and pickupCollectibles method in Map class
	@Test
	void test_arrow_pick_up() {
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionD();
		Map newMap = new Map(10,10, "ArrowMap", c);
		newMap.addPlayer(0,0);
		Arrow a = newMap.getPlayer().hasArrow();
		assertTrue(a == null);
		newMap.addEntity(new Arrow(0,1), 0, 1);
		newMap.moveMovable(newMap.getPlayer(), 'd');
		newMap.pickupCollectibles();
		a = newMap.getPlayer().hasArrow();
		assertTrue(a != null);
	}
	
	// Test removeArrow method in Player class
	void test_remove_arrow() {
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionD();
		Map newMap = new Map(10,10, "ArrowMap", c);
		newMap.addPlayer(0,0);
		Arrow a = newMap.getPlayer().hasArrow();
		assertTrue(a == null);
		newMap.addEntity(new Arrow(0,1), 0, 1);
		newMap.moveMovable(newMap.getPlayer(), 'd');
		newMap.pickupCollectibles();
		a = newMap.getPlayer().hasArrow();
		assertTrue(a != null);
		newMap.getPlayer().removeArrow(a);
		a = newMap.getPlayer().hasArrow();
		assertTrue(a == null);
	}
	
	// Test picking up one treasure
	@Test
	void test_treasure_pick_up() {
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionD();
		Map newMap = new Map(10,10, "TreasureMap", c);
		newMap.addPlayer(0,0);
		newMap.addEntity(new Treasure(0,2), 0, 2);
		int i = 0;
		for(Collectibles a: newMap.getPlayer().getItems()) {
			if (a instanceof Treasure) { i++; }
		}
		assertTrue(i == 0);
		newMap.moveMovable(newMap.getPlayer(), 'd');
		newMap.moveMovable(newMap.getPlayer(), 'd');
		newMap.pickupCollectibles();
		i = 0;
		for(Collectibles a: newMap.getPlayer().getItems()) {
			if (a instanceof Treasure) { i++; }
		}
		assertTrue(i == 1);
	}
	
	// Test picking up three treasures
	@Test
	void test_multiple_pick_up() {
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionD();
		Map newMap = new Map(10,10, "TreasureMap", c);
		newMap.addPlayer(0,0);
		newMap.addEntity(new Treasure(0,2), 0, 2);
		newMap.addEntity(new Treasure(0,3), 0, 3);
		newMap.addEntity(new Treasure(0,4), 0, 4);
		int i = 0;
		newMap.moveMovable(newMap.getPlayer(), 'd');
		newMap.pickupCollectibles();
		newMap.moveMovable(newMap.getPlayer(), 'd');
		newMap.pickupCollectibles();
		newMap.moveMovable(newMap.getPlayer(), 'd');
		newMap.pickupCollectibles();
		newMap.moveMovable(newMap.getPlayer(), 'd');
		newMap.pickupCollectibles();
		i = 0;
		for(Collectibles a: newMap.getPlayer().getItems()) {
			if (a instanceof Treasure) { i++; }
		}
		assertTrue(i == 3);
	}
	
	// Test completion condition for treasures
	@Test
	void test_completion_treasure() {
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionT();
		Map newMap = new Map(10,10, "TreasureMap", c);
		newMap.addPlayer(0,0);
		newMap.addEntity(new Treasure(0,2), 0, 2);
		newMap.addEntity(new Treasure(0,3), 0, 3);
		newMap.addEntity(new Treasure(0,4), 0, 4);
		assertFalse(newMap.condition().checkCC(newMap));
		int i = 0;
		newMap.moveMovable(newMap.getPlayer(), 'd');
		newMap.pickupCollectibles();
		newMap.moveMovable(newMap.getPlayer(), 'd');
		newMap.pickupCollectibles();
		newMap.moveMovable(newMap.getPlayer(), 'd');
		newMap.pickupCollectibles();
		newMap.moveMovable(newMap.getPlayer(), 'd');
		newMap.pickupCollectibles();
		i = 0;
		for(Collectibles a: newMap.getPlayer().getItems()) {
			if (a instanceof Treasure) { i++; }
		}
		assertTrue(i == 3);
		assertTrue(newMap.condition().checkCC(newMap));
	}
	
	@Test
	void testBombDestroyEnemy() {
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionE();
		Map newMap = new Map(10,10, "default", c);
		newMap.addPlayer(0,0);
		newMap.addEntity(new Exit(9,9), 9, 9);
		
		Hunter h = new Hunter(5,4,0,0);
		Hound ho = new Hound(4,5,0,0,h);
		Coward co = new Coward(4,3,0,0);
		Strategist s = new Strategist(3,4,0,0);
		
		Bomb b = new Bomb(4,4);
		
		newMap.addEntity(h, 5, 4);
		newMap.addEntity(ho, 4, 5);
		newMap.addEntity(co, 4, 3);
		newMap.addEntity(s, 3, 4);
		newMap.addEntity(b, 4, 4);
		as.addMap(newMap);
		for (int i = 0;i < 4;i++) b.useBomb();
		
		assertTrue(b.canExplode());
		
		newMap.checkBomb();

		assertFalse(newMap.containsEnemy());
	}

	@Test
	void testBombDestroyPlayer() {
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionE();
		Map newMap = new Map(10,10, "default", c);
		newMap.addPlayer(4,3);
		newMap.addEntity(new Exit(9,9), 9, 9);
		
		
		Bomb b = new Bomb(4,4);
		
		newMap.addEntity(b, 4, 4);
		as.addMap(newMap);
		for (int i = 0;i < 4;i++) b.useBomb();
		
		assertTrue(b.canExplode());
		
		newMap.checkBomb();

	
		
	
		assertTrue(newMap.playerGone());
	}
	
	@Test
	void testBombDestroyBoulder() {
		AppSystem as = new AppSystem();
		CompletionCondition c = new CompletionConditionE();
		Map newMap = new Map(10,10, "default", c);
		newMap.addPlayer(0,0);
		newMap.addEntity(new Exit(9,9), 9, 9);
		
		Boulder bo = new Boulder(4,3);
		Bomb b = new Bomb(4,4);
		
		newMap.addEntity(b, 4, 4);
		newMap.addEntity(bo, 4, 3);
		as.addMap(newMap);
		for (int i = 0;i < 4;i++) b.useBomb();
		
		assertTrue(b.canExplode());
		
		newMap.checkBomb();
		
		assertFalse(newMap.getTile(4, 3).checkEntity(bo));
	}
	

	
}
