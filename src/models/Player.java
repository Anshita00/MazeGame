package models;


import java.util.Iterator;
import java.util.ArrayList;


public class Player extends MovableItems {
	/**
	 * type int would be replaced by Item class
	 * in the future.
	 */
	private ArrayList<Collectibles> items; 
	private ArrayList<Enemy> enemies;
	/**
	 * create a player
	 * @param name the name of the player
	 * @param mazeSize the size of the maze
	 */
	public Player(int initRow, int initCol){
		super(initRow, initCol);
		this.items = new ArrayList<Collectibles>();
		this.enemies = new ArrayList<Enemy>();
	}
	
	public void removeEnemies(Enemy e) {
		this.enemies.remove(e);
	}
	
	public void notiFy() {
		for (Enemy e: this.enemies) {
			e.update(this.getRow(),this.getColumn());
		}
	}
	public boolean hasSword() {
		for (Entity E:this.items) {
			if (E instanceof Sword) {
				return true;
			}
		}
		return false;
	}
	
	public boolean invincible() {
		
		for (Collectibles i : this.items) {
			if(i instanceof InvincibilityPotion) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean hover() {
		for (Collectibles i : this.items) {
			if(i instanceof HoverPotion) {
				return true;
			}
		}
		return false;
	}


	public Player(Player p) {
		super(p.getRow(), p.getColumn());
		this.items = new ArrayList<Collectibles>();
		this.enemies = new ArrayList<Enemy>();
		for (Collectibles i : p.items) {
			this.items.add(i);
		}
		try {
			for (Enemy e: p.enemies) {
				this.enemies.add((Enemy) e.clone());
			}
		} catch (Exception e) {
			System.out.println("Clone of enemies in player didn't work");
		}
	}
	

	public void swordUse() {
		if(this.items.size() != 0) {
			for(Collectibles e : this.items){
				if(e instanceof Sword) {
					if(e.vanish() == 1) {
						this.items.remove(e);
						break;
					}
				}
			}
		}
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Player(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj == this) return true;
		if (obj.getClass() != this.getClass()) return false;
		
		Player p = (Player)obj;
		return (p.getColumn() == this.getColumn() && p.getRow() == this.getRow());
	}

	private void removeEmpty() {	
		Iterator<Collectibles> iter = items.iterator();
		while (iter.hasNext()) {
			Collectibles cur = iter.next();
			if (cur.numUses() == 0) {
				iter.remove();
			}
		}
	}
	
	public void dropBomb() {
		Bomb myBomb = (Bomb)this.getItem(new Bomb(0,0));
		myBomb.vanish();
		removeEmpty();

	}
	

	@Override
	public void moveUp() {

		//for loop to delete the potion from inventory once it's time is up
		decPotionTime();
		this.setRow(this.getRow() - 1);
		removeEmpty();
		this.notiFy();
	}
	
	@Override
	public void moveDown() {
		// maybe would have to check some conditions
		// in the future
		decPotionTime();
		this.setRow(this.getRow() + 1);
		removeEmpty();
		this.notiFy();
	}
	

	@Override
	public void moveRight() {
		// maybe would have to check some conditions
		// in the future
		decPotionTime();
		this.setColumn(this.getColumn() + 1);
		removeEmpty();
		this.notiFy();
	}
	
	public void decPotionTime(){
			
		if(this.items.size() != 0) {
			for(Collectibles e : items){
				if(e instanceof InvincibilityPotion) {
					InvincibilityPotion o = (InvincibilityPotion)e;
					if(o.vanish() == 0) {
						items.remove(o);
						break;
					}
				}
			}
		}	
	}
	
	@Override
	public void moveLeft() {
		// maybe would have to check some conditions
		// in the future
		decPotionTime();
		this.setColumn(this.getColumn() - 1);
		removeEmpty();
		this.notiFy();
	}
	

	@Override
	public int strength() {
		return 3;
	}

	@Override
	public String display() {
		return "View/player.png";

	}
	
	public boolean pickUp(Entity e) {
		if (e instanceof Collectibles) {
			if (e instanceof Key || e instanceof Sword) {
				if (hasItem(e)) {
					return false;
				}
			} else if (e instanceof Bomb) {
				Bomb b = (Bomb)e;
				if (b.numUses() == 0) return false;
			} else if (e instanceof Arrow) {
				Arrow a = (Arrow) e;
			}
			this.items.add((Collectibles) e);
			return true;
		}
		return false;
	} 
	
	public boolean hasItem(Entity e) {
		if (!(e instanceof Collectibles)) return false;
		Collectibles c = (Collectibles)e;
		for (Collectibles pc: this.items) {
			if (pc.equals(c)) return true;
		}
		return false;
	}
	
	public Collectibles getItem (Entity e) {
		if (!(e instanceof Collectibles)) return null;
		Collectibles c = (Collectibles)e;
		for (Collectibles pc: this.items) {
			if (pc.equals(c)) return pc;
		}
		return null;
	}


	@Override
	public boolean moveTo() {
		return true;
	}
	
	public Arrow hasArrow() {
		Arrow useArrow = null;
		for (Collectibles a: items) {
			if (a instanceof Arrow) {
				
				useArrow = (Arrow)a;
				break;
			}
		}
		return useArrow;
	}
	
//	public void hasArrow() {
//		boolean cArrow = false;
//		Arrow usedArrow = null;
//		for (Collectibles a: items) {
//			if (a instanceof Arrow) {
//				cArrow = true;
//				usedArrow = (Arrow)a;
//				break;
//			}
//		}
//	}
	
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}
	
	public void addEnemy(Enemy e) {
		this.enemies.add(e);
	}
	
	public void removeArrow(Arrow a) {
		items.remove(a);
	}
	
	public ArrayList<Collectibles> getItems() {
		return items;
	}
}








