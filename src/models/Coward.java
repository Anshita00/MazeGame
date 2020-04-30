package models;

import java.awt.event.KeyEvent;

public class Coward extends Enemy {
	


	public Coward(int row, int column, int playerRow, int playerColumn) {
		super(row, column, playerRow, playerColumn);
	}
	
	public Coward(Coward c) {
		super(c);
	}

	@Override
	public void moveUp() {
		this.setRow(this.getRow() - 1);
	}
	
	@Override
	public void moveDown() {
		this.setRow(this.getRow() + 1);
	}

	
	@Override
	public void moveRight() {
		this.setColumn(this.getColumn() + 1);
	}
	
	@Override
	public void moveLeft() {
		this.setColumn(this.getColumn() - 1);
	}
	
	/**
	 * according to the input key to move the player
	 * @param move
	 */
	@Override
	public boolean moveTo() {
		return true;
	}
	@Override
	public int strength() {
		return 2;
	}
	@Override
	public String display() {
		return "View/coward.png";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Coward(this);
	}

	@Override
	public char makeMove(int nrows, int ncols) {
		if (farAway())
			return makeMoveFarAway(nrows, ncols);
		else
			return makeMoveClose(nrows, ncols);
	}
	
	public boolean farAway() {
		if (playerRow - getRow() <= 2 && playerRow - getRow() >= -2 && 
playerColumn - getColumn() <=2 && playerColumn - getColumn() >= -2) {
			return false;
		}
		return true;
	}
	
	public char makeMoveClose(int nrows, int ncols) {
		if (playerRow < getRow() && getRow() != nrows) {
			return 's';
		} else if (playerRow > getRow() && getRow() != 0) {
			return 'w';
		} else if (playerColumn < getColumn()  && getColumn() != ncols) {
			return 'd';
		} else if (playerColumn > getColumn() && getColumn() != 0){
			return 'a';
		}
		return 'z';
	}
	
	public char makeMoveFarAway(int nrows, int ncols) {
		if (playerRow < getRow() && getRow() != 0) {
			return 'w';
		} else if (playerRow > getRow() && getRow() != nrows) {
			return 's';
		} else if (playerColumn < getColumn() &&  getColumn() != 0) {
			return 'a';
		} else if (playerColumn > getColumn() && getColumn() != ncols){
			return 'd';
		}
		return 'z';
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null) return false;
		if (obj.getClass() != this.getClass()) return false;
		Entity e = (Entity)obj;
		if (e.getRow() != this.getRow()) return false;
		if (e.getColumn() != this.getColumn()) return false;
		return true;
	}
	
}