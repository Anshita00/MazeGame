package models;

import java.util.ArrayList;
import java.util.Iterator;

public class Tile extends Entity implements Cloneable{

	private ArrayList<Entity> objects;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Tile newTile = new Tile(getRow(),getColumn());
		for (Entity e : getObjects()) {
			newTile.getObjects().add((Entity) e.clone());
		}
		return newTile;
	}
	public Tile(int row, int column) {
		super(row,column);
		setObjects(new ArrayList<Entity>());
		getObjects().add(new Empty(row, column));
	}
	@Override
	public String display() {
		if (containsEmpty()) {
			System.out.println("it has ground");
		} else {
			System.out.println("it destory ground");
		}
		Entity stronger = getObjects().get(0);
		for (Entity e: getObjects()) {
			if (e.strength() > stronger.strength()) {
				stronger = e;
			}
		}
		System.out.println(stronger);
		return stronger.display();
	}

	@Override
	public boolean moveTo() {
		for (Entity e: getObjects()) {
			if (!e.moveTo()) {
				return false;
			}
		}
		return true;
	}
	@Override
	public int strength() {
		Entity stronger = getObjects().get(0);
		for (Entity e: getObjects()) {
			if (e.strength() > stronger.strength()) {
				stronger = e;
			}
		}
		return stronger.strength();
	}
	public boolean changeBase(Entity newEntity) {

		if (newEntity == null) return false;
		for (Entity e: this.objects) {

			if (e instanceof Empty) {
				getObjects().remove(e);
				getObjects().add(newEntity);
				return true;
			} else {
				getObjects().add(newEntity);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean checkEntity (Entity e) {	
		return getObjects().contains(e);
	}
	
	public Entity getEntity(Entity e) {
		for (Entity te: this.getObjects()) {
			if (te.equals(e)) {
				return te;
			}
		}
		return null;
	}
	public void showEntity () {
		for (Entity e: getObjects()) {
			e.display();
			System.out.println(" ");
		}
	}
	

	public Entity getBoulder(char a) {
		
		if (a=='B') {
			for (Entity e: getObjects()) {
				if (e instanceof Boulder) {
					return e;
				}
			}
		}
		return new Empty(this.getRow(),this.getColumn());
	}

	public boolean removeEntity(Entity e) {
		if (getObjects().contains(e)) {
			getObjects().remove(e);
			System.out.println("REMOVE SUCCESSFUL");
			if (getObjects().isEmpty()) {
				getObjects().add(new Empty(this.getRow(), this.getColumn()));
			}
			return true;
		}
		return false;
	}
	

	public void pickedUpEntities(Player p) {
		Iterator<Entity> iter = objects.iterator();
		while (iter.hasNext()) {
			Entity e = iter.next();
			if (p.pickUp(e)) {
				iter.remove();
			}
		}
	}
	
	public Enemy removeEnemies() {
		Iterator<Entity> iter = getObjects().iterator();
		while (iter.hasNext()) {
			Entity e = iter.next();
			if (e instanceof Enemy) {
				Enemy enemy = (Enemy)e; 
				iter.remove();
				return enemy;
			}
		}
		return null;
	}

	public void destroy() {
		Iterator<Entity> iter = getObjects().iterator();
		boolean hasRemoved = false;
		while (iter.hasNext()) {
			Entity e = iter.next();
			if (e instanceof MovableItems) {
				if (e instanceof Player ) System.out.println("palyer");
				iter.remove();
				hasRemoved = true;
			}
		}
		if (hasRemoved) {
			getObjects().add(new Empty(this.getRow(), this.getColumn()));
		}
	}

	public boolean containsEnemy() {
		for (Entity a: getObjects()) {
			if (a instanceof Coward) {
				System.out.println("Coward" + a.getColumn() + a.getRow() + "p:"+getColumn()+getRow());
				return true;
			}
			if (a instanceof Hound )  {
				System.out.println("Hound" + a.getColumn() + a.getRow() + "p:"+getColumn()+getRow());
				return true;
			}
			if (a instanceof Hunter) {
				System.out.println("Hunter" + a.getColumn() + a.getRow() + "p:"+getColumn()+getRow());
				return true;
			}
			if (a instanceof Strategist) {
				System.out.println("Strategist" + a.getColumn() + a.getRow() + "p:"+getColumn()+getRow());
				return true;
			}
		}
		return false;
	}
	
	public boolean containsTreasure() {
		for (Entity a: getObjects()) {
			if (a instanceof Treasure) return true;
		}
		return false;
	}
	
	public boolean containsSwitch() {
		for (Entity a: getObjects()) {
			if (a instanceof FloorSwitch) return true;
		}
		return false;
	}
	
	public boolean containsBoulder() {
		for (Entity a: getObjects()) {
			if (a instanceof Boulder) return true;
		}
		return false;
	}
	
	public boolean containsEmpty() {
		for (Entity a: getObjects()) {
			if (a instanceof Empty) return true;
		}
		return false;
	}
	
	public boolean canAddEntity() {
		if (getObjects().size() == 0 || (getObjects().size() == 1 && containsEmpty())) {
			return true;
		}
		return false;
	}
	
	public void KillEnemy() {
		Entity enemy = null;
		for (Entity a: getObjects()) {
			if (a instanceof Coward) {
				enemy = a; break;
			}
			if (a instanceof Hound ) {
				enemy = a; break;
			}
			if (a instanceof Hunter) {
				enemy = a; break;
			}
			if (a instanceof Strategist) {
				enemy = a; break;
			}
		}
		if (enemy != null) {
			removeEntity(enemy);
		}	
	}
	public ArrayList<Entity> getObjects() {
		return objects;
	}
	public void setObjects(ArrayList<Entity> objects) {
		this.objects = objects;
	}
	
}
