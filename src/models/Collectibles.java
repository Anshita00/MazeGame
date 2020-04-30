package models;


public abstract class Collectibles extends Entity {

	public Collectibles(int row, int col) {
		super(row, col);
		
	}
	public abstract int vanish();
	public abstract int numUses();
	
	
	
}

