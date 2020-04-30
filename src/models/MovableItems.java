package models;



public abstract class MovableItems extends Entity {
	
	public MovableItems(int row, int column) {
		super(row, column);
	}
	public abstract void moveUp();
	public abstract void moveDown();
	public abstract void moveRight();
	public abstract void moveLeft();
	
	/**
	 * according to the input key to move the player
	 * @param e  the direction of the movement
	 */
	
	public void move(char c) {
		switch(c) {
			case 'w': this.moveUp();
					   break;
			case 'a': this.moveDown();
					  break;
			case 's': this.moveLeft();
			  break;
			case 'd': this.moveRight();
			  break;
		}
		
		
	}
		
}
