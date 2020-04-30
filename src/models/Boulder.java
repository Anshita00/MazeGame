package models;

import java.awt.event.KeyEvent;

public class Boulder extends MovableItems {

	public Boulder (int initRow, int initCol) {
		super(initRow, initCol);
	}
	/**
	 * according to the input key to move the player
	 * @param move
	 */
	@Override
	public boolean moveTo() {
		return false;
	}
	@Override
	public int strength() {
		return 2;
	}
	@Override
	public String display() {
		return "View/boulder.png";
		
	}
	@Override
	public void moveUp() {
		
	}
	@Override
	public void moveDown() {
		
	}
	@Override
	public void moveRight() {
		
	}
	@Override
	public void moveLeft() {
		
	}

}