package models;

import java.util.*;
public class Map implements  Cloneable {
	
	private String name;
	private Tile[][] grid;
	private int rows;
	private int columns;
	private Player player;
	private CompletionCondition cCondition;
	private boolean isQuit = false;
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public String getName() {
		return name;
	}

	public CompletionCondition condition() {
		return this.cCondition;
	}
	
	public Tile getGrid(int row, int col) {
		//System.out.println(row+""+column);
		return this.grid[row][col];
	}
	
	public Map(Map m) {
		try {
			Map my = (Map)m.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Map newMap = new Map(rows, columns, name, cCondition);
		for (int i = 0; i < rows; i++) {
			for (int j =0; j < columns; j++) {
				//grid[i][j].display();
				
				newMap.grid[i][j] = (Tile) grid[i][j].clone();
				//newMap.grid[i][j].display();
				if (grid[i][j].checkEntity(player)) {
					newMap.grid[i][j].removeEntity(player);
					Player p = new Player(player);
					try {
						newMap.grid[i][j].changeBase(p);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					newMap.player = p;
				}
			}
		}
		return newMap;
	}

//	public void setEndCondition(String endCondition) {
//		this.endCondition = endCondition;
//	}

	public void setName(String name) {
		this.name = name;
	}

	public Map(int rows, int columns, String name, CompletionCondition cCondition) {

		this.name = name;
		this.rows = rows;
		this.columns = columns;
		this.grid = new Tile[rows][columns];
		
		for (int i = 0; i < rows; i++) {
			for (int j =0; j < columns; j++) {
				grid[i][j] = new Tile(i, j);
			}
		}
		this.cCondition = cCondition;
		
//		this.player = new Player("", playerRow, playerColumn);
//		grid[playerRow][playerColumn].changeBase(this.player);
//		grid[endPosRow][endPosCol].changeBase(new Exit());
		
	}

	public boolean addPlayer(int row, int column) {
		if (row >= this.rows || column >= this.columns) { 
			System.out.println("You entered an invalid row-column pair. Nothing happened. You can try again.");
			return false; 
		}
		Player p = new Player (row, column);
		if(!grid[row][column].changeBase(p)) {
			return false;
		}
		this.player = p;
		return true;
	}
	
	public boolean addExit(int row, int column) {
		if (row >= this.rows || column >= this.columns) { 
			System.out.println("You entered an invalid row-column pair. Nothing happened. You can try again.");
			return false; 
		}

		Exit p = new Exit(row, column);

		if(!grid[row][column].changeBase(p)) {
			return false;
		}
		return true;
	}
	/**
	 * according to the input key to move the player
	 * @param move
	 * @throws Exception 
	 */	
	public boolean moveMovable(MovableItems mi, char c) {
			boolean retType = false;
			switch (c) {
			case 'w':
				if (this.moveMovableUp(mi)) {
					mi.moveUp();
					retType = true;
				}
				break;
			case 's':
				if (this.moveMovableDown(mi)) {
					mi.moveDown();
					retType = true;
				}
				break;
			case 'a':
				if (this.moveMovableLeft(mi)) {
					mi.moveLeft();
					retType = true;
				}
				break;
			case 'd':
				if (this.moveMovableRight(mi)) {
					mi.moveRight();
					retType = true;
				}
				break;
			case 'b':
				if (!(mi instanceof Player)) return false;
				Player thisp = (Player)mi;
				if (!(thisp.hasItem(new Bomb(0,0)))) return false;
				Bomb b = (Bomb)thisp.getItem(new Bomb(0,0));
				thisp.dropBomb();
				Tile curTile = grid[player.getRow()][player.getColumn()];
				curTile.changeBase(b);
				retType = true;
				break;
			case 'q':
				isQuit = true;
				break;
			default :
				return false;
			}
			if (retType == true && mi instanceof Player) {
				checkBomb();
				moveEnemies();
			}
		return retType;
	}
	
	public void moveEnemies() {
		for (Enemy e: player.getEnemies()) {
			char direction = e.makeMove(rows, columns);
			moveMovable(e,direction);
		}
	}
	public void checkBomb() {
		for (int i = 0; i < rows; i++) {
			for (int j =0; j < columns; j++) {
				if (grid[i][j].checkEntity(new Bomb(0,0))) {
					Bomb b = (Bomb) grid[i][j].getEntity(new Bomb(0,0));
					if (b.numUses() == 0) {
						b.useBomb();
						System.out.println("The bomb is being used");
					}
					if (b.canExplode()) {
						System.out.println("The bomb is exploding");
						detonate(grid[i][j]);
					}
				}
			}
		}
	}
	
	public void detonate(Tile now) {
		if (now.getColumn() != 0) {
			Tile leftTile = grid[now.getRow()][now.getColumn() - 1];
			leftTile.destroy();
		}
		if (now.getColumn() != columns -1) {
			Tile rightTile = grid[now.getRow()][now.getColumn()+1];
			rightTile.destroy();
		}
		if (now.getRow() != 0) {
			Tile upTile = grid[now.getRow() - 1][now.getColumn()];
			upTile.destroy();
		}
		if (now.getRow() != rows -1) {
			Tile downTile = grid[now.getRow() + 1][now.getColumn()];
			downTile.destroy();
		}
		
	}

	
	public boolean moveMovableUp(MovableItems mi) {
		
		Tile curTile = grid[mi.getRow()][mi.getColumn()];
		if (mi.getRow() == 0) return false;
		Tile upTile = grid[curTile.getRow()-1][curTile.getColumn()];
		
		if (upTile.moveTo()) {
			
			curTile.removeEntity(mi);
			return upTile.changeBase(mi);
			
		} else if (upTile.checkEntity(new Door(mi.getRow()-1, mi.getColumn(), new Key(0,0)))) {
			if (mi instanceof Player) {
				
				Player thisp = (Player)mi;
				Key pKey = (Key)thisp.getItem((new Key(0,0)));
				
				if (pKey == null) return false;
				Door thisDoor = (Door) upTile.getEntity(new Door(mi.getRow()-1, mi.getColumn(), new Key(0,0)));
				
				if (thisDoor.openDoor(pKey)) {
					curTile.removeEntity(mi);
					return upTile.changeBase(mi);
				}
			}
		} else {
			//System.out.println(upTile.checkEntity(new Boulder(curTile.getRow()-1,curTile.getColumn())));
			Entity b = upTile.getBoulder('B');
			if (upTile.containsBoulder()) {
				
				if (upTile.getRow()==0) return false;
				Tile uppTile = grid[upTile.getRow()-1][upTile.getColumn()];
				if (uppTile.moveTo()) {
					
					if (upTile.removeEntity(b)) {
					}
					if (curTile.removeEntity(mi)) {
					}
					if (uppTile.checkEntity(new Pit(uppTile.getRow(), uppTile.getColumn()))) {
						return upTile.changeBase(mi);
					}
					return upTile.changeBase(mi) && uppTile.changeBase(b);
				}
			}
		}
		
		return false;
	}
	public boolean moveMovableDown(MovableItems mi) {
		System.out.println(mi.getRow());
		System.out.println(mi.getColumn());
		Tile curTile = grid[mi.getRow()][mi.getColumn()];
		if (mi.getRow() == rows -1) return false;
		Tile downTile = grid[curTile.getRow() + 1][curTile.getColumn()];
		if (downTile.moveTo()) {
			curTile.removeEntity(mi);
			return downTile.changeBase(mi);
		}else if (downTile.checkEntity(new Door(mi.getRow()+1, mi.getColumn(), new Key(0,0)))) {
			if (mi instanceof Player) {
				Player thisp = (Player)mi;
				Key pKey = (Key)thisp.getItem((new Key(0,0)));
				if (pKey == null) return false;
				Door thisDoor = (Door) downTile.getEntity(new Door(mi.getRow(), mi.getColumn(), new Key(0,0)));
				if (thisDoor.openDoor(pKey)) {
					curTile.removeEntity(mi);
					return downTile.changeBase(mi);
				}
			}
		} else {
			//System.out.println(upTile.checkEntity(new Boulder(curTile.getRow()-1,curTile.getColumn())));
			Entity b = downTile.getBoulder('B');
			if (downTile.containsBoulder()) {
				if (downTile.getRow()==rows-1) return false;
				Tile dwwTile = grid[downTile.getRow()+1][downTile.getColumn()];
				if (dwwTile.moveTo()) {
					if (downTile.removeEntity(b)) {
					}
					if (curTile.removeEntity(mi)) {
					}
					if (dwwTile.checkEntity(new Pit(dwwTile.getRow(), dwwTile.getColumn()))) {
						return downTile.changeBase(mi);
					}
					return downTile.changeBase(mi) && dwwTile.changeBase(b);
				}
			}
		}
		
		return false;
	}
	public boolean playerGone() {
		Tile curTile = grid[player.getRow()][player.getColumn()];
		if (!curTile.checkEntity(player)) {
			System.out.println("Here in player gone");
			return true;
		}
		return false;
	}
	
	public boolean gameWon() {
		return (playerAtExit());
	}
  
	public boolean gameLost() {
		return (checkPlayerDead() || playerGone());
	}

	public boolean playerAtExit () {
		int row = player.getRow();
		int column = player.getColumn();
		Tile curTile = grid[row][column];
		
		return curTile.checkEntity(new Exit(row, column));
	}
	
	public boolean playerInPit() {
		int row = player.getRow();
		int column = player.getColumn();
		Tile curTile = grid[row][column];
		
		return curTile.checkEntity(new Pit(row, column));
	}
	
	
  
	public boolean checkPlayerDead() {
		int row = player.getRow();
		int column = player.getColumn();
		System.out.println("player:"+column+row);
		Tile curTile = grid[row][column];
		if (isQuit) {
			System.out.println("isQuit");
			isQuit = false;
			return true;
		}

		if(curTile.containsEnemy() == true){
			System.out.println(curTile.containsEnemy());
			System.out.println("Here in enemy" + curTile.getColumn() + curTile.getRow()+curTile.display());
			if(player.hasSword() == true || player.invincible() == true) {
				if(player.hasSword() == true) {
					player.swordUse();
					//killEnemies();
					grid[row][column].KillEnemy();
					grid[row][column].removeEnemies();
					//player.swordUse();
				}
				else if(player.invincible() == true) {
					grid[row][column].KillEnemy();
					grid[row][column].removeEnemies();
				}
				return false;
			}
			else {
				return true;
			}
		} 
		else if(curTile.checkEntity(new Pit(row, column)) == true) {
			System.out.println("Here in pit");
			if (player.hover() == true) {
				return false;
			}
			else {
				return true;
			}
				
		}
		return false;
		
	}
	

	//makes changes to present tile when making it move to other tile (display)

	public boolean moveMovableLeft(MovableItems mi) {
		Tile curTile = grid[mi.getRow()][mi.getColumn()];
		if (mi.getColumn() == 0) return false;
		Tile leftTile = grid[curTile.getRow()][curTile.getColumn() - 1];
		if (leftTile.moveTo()) {
			curTile.removeEntity(mi);
			return leftTile.changeBase(mi);
		} else if (leftTile.checkEntity(new Door(mi.getRow(), mi.getColumn()-1, new Key(0,0)))) {
			if (mi instanceof Player) {
				Player thisp = (Player)mi;
				Key pKey = (Key)thisp.getItem((new Key(0,0)));
				if (pKey == null) return false;
				System.out.println(pKey);
				Door thisDoor = (Door) leftTile.getEntity(new Door(mi.getRow(), mi.getColumn() - 1, new Key(0,0)));
				if (thisDoor.openDoor(pKey)) {
					curTile.removeEntity(mi);
					return leftTile.changeBase(mi);
				}
			}
		} else {
			//System.out.println(upTile.checkEntity(new Boulder(curTile.getRow()-1,curTile.getColumn())));
			Entity b = leftTile.getBoulder('B');
			if (leftTile.containsBoulder()) {
				if (leftTile.getColumn()==0) return false;
				Tile lffTile = grid[leftTile.getRow()][leftTile.getColumn()-1];
				if (lffTile.moveTo()) {
					if (leftTile.removeEntity(b)) {
					}
					if (curTile.removeEntity(mi)) {
					}
					if (lffTile.checkEntity(new Pit(lffTile.getRow(), lffTile.getColumn()))) {
						return leftTile.changeBase(mi);
					}
					return leftTile.changeBase(mi) && lffTile.changeBase(b);
				}
			}
		}
		
		return false;
	}
	public boolean moveMovableRight(MovableItems mi) {
		Tile curTile = grid[mi.getRow()][mi.getColumn()];
		if (mi.getColumn() == columns - 1) return false;
		Tile rightTile = grid[curTile.getRow()][curTile.getColumn() + 1];
		if (rightTile.moveTo()) {
			curTile.removeEntity(mi);
			return rightTile.changeBase(mi);
		} else if (rightTile.checkEntity(new Door(mi.getRow(), mi.getColumn() + 1, new Key(0,0)))) {
			if (mi instanceof Player) {
				Player thisp = (Player)mi;
				Key pKey = (Key)thisp.getItem((new Key(0,0)));
				if (pKey == null) return false;
				System.out.println(pKey);
				Door thisDoor = (Door) rightTile.getEntity(new Door(mi.getRow(), mi.getColumn() + 1, new Key(0,0)));
				if (thisDoor.openDoor(pKey)) {
					curTile.removeEntity(mi);
					return rightTile.changeBase(mi);
				}
			}
		} else {
			//System.out.println(upTile.checkEntity(new Boulder(curTile.getRow()-1,curTile.getColumn())));
			Entity b = rightTile.getBoulder('B');
			if (rightTile.containsBoulder()) {
				if (rightTile.getColumn()==columns-1) return false;
				Tile rggTile = grid[rightTile.getRow()][rightTile.getColumn()+1];
				if (rggTile.moveTo()) {
					if (rightTile.removeEntity(b)) {
					}
					if (curTile.removeEntity(mi)) {
					}
					if (rggTile.checkEntity(new Pit(rggTile.getRow(), rggTile.getColumn()))) {
						return rightTile.changeBase(mi);
					}
					return rightTile.changeBase(mi) && rggTile.changeBase(b);
				}
			}
		}
		return false;
	}
	
	public void pickupCollectibles() {
		Tile cur = grid[player.getRow()][player.getColumn()];
		cur.pickedUpEntities(player);
	}
	
	public Tile getTile(int row, int column) {
		return grid[row][column];
	}

	public boolean addEntity(Entity e, int row, int column) {
		if (row >= this.rows || column >= this.columns || row < 0 || column < 0) { 
			System.out.println("You entered an invalid row-column pair. Nothing happened. You can try again.");
			return false; 
		}
		if (e instanceof Enemy) {
			player.addEnemy((Enemy)e);
			return grid[row][column].changeBase(e) && grid[row][column].checkEntity(e);
		}
		return grid[row][column].changeBase(e) && grid[row][column].checkEntity(e);
	}
	

	public boolean containsEnemy() {
		for (int i = 0; i < rows ; i++) {
			for(int j = 0; j < columns; j++) {
				if (grid[i][j].containsEnemy()) {
					System.out.println(i + " " +  j);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean containsTreasure() {
		for (int i = 0; i < rows ; i++) {
			for(int j = 0; j < columns; j++) {
				if (grid[i][j].containsTreasure()) return true;
			}
		}
		return false;
	}
	
	public boolean containsSwitchWithoutBoulder() {
		for (int i = 0; i < rows ; i++) {
			for(int j = 0; j < columns; j++) {
				if (grid[i][j].containsSwitch() && !grid[i][j].containsBoulder()) return true;
			}
		}
		return false;
	}
	
	public void shootArrow(String dir) {
		Arrow pArrow = player.hasArrow();
		if (pArrow != null) {
			System.out.println("Enter direction: (w,a,s,d options for up,left,down,right)");
			int correctDirection = 0;
			//Scanner sc = new Scanner(System.in);
			//String direction = sc.nextLine();
			while (correctDirection == 0) {
				if (dir.equals("w")) {
					ArrowUp();
					correctDirection = 1; 
					//display();
				} else if (dir.equals("a")) {
					ArrowLeft();
					correctDirection = 1; 
					//display();
				} else if (dir.equals("s")) {
					ArrowDown();
					correctDirection = 1; 
					//display();
				} else if (dir.equals("d")) {
					ArrowRight();
					correctDirection = 1; 
					//display();
				} else { continue; }
			}
			// Code to remove the arrow from player inventory
			player.removeArrow(pArrow);
		}
		else {
			System.out.println("You do not have any arrows!");
		}
	}
	
	public void ArrowUp() {
		if (player.getRow() == 0) {
			return;
		}
		int i = player.getRow()-1, j = player.getColumn();
		while (i >= 0) {
			if(grid[i][j].containsEnemy()) {
//				Enemy e = grid[i][j].removeEnemies();
//				player.removeEnemies(e);
				grid[i][j].KillEnemy();
				System.out.println("ENEMY KILLED WITH ARROW!!!");
				break;
			}
			i--;
		}
	}
	
	public void ArrowLeft() {
		if (player.getColumn() == 0) { 
			return; 
		}
		int i = player.getRow(), j = player.getColumn()-1;
		while (j >= 0) {
			if(grid[i][j].containsEnemy()) {
				//Enemy e = grid[i][j].removeEnemies();
				grid[i][j].KillEnemy();
				//player.removeEnemies(e);
				System.out.println("ENEMY KILLED WITH ARROW!!!");
				break;
			}
			j--;
		}
	}
	
	public void ArrowDown() {
		if (player.getRow() == (rows-1)) { 
			return; 
		}
		int i = player.getRow()+1, j = player.getColumn();
		while (i < rows) {
			if(grid[i][j].containsEnemy()) {
				//Enemy e = grid[i][j].removeEnemies();
				//player.removeEnemies(e);
				grid[i][j].KillEnemy();
				System.out.println("ENEMY KILLED WITH ARROW!!!");
				break;
			}
			i++;
		}
	}
	
	public void ArrowRight() {
		if (player.getColumn() == (columns-1)) { 
			return; 
		}
		int i = player.getRow(), j = player.getColumn()+1;
		while (j < columns) {
			if(grid[i][j].containsEnemy()) {
//				Enemy e = grid[i][j].removeEnemies();
//				player.removeEnemies(e);
				grid[i][j].KillEnemy();
				System.out.println("ENEMY KILLED WITH ARROW!!!");
				break;
			}
			j++;
		}
	}
	
	

	

}
