package models;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Strategist extends Enemy {

	public Strategist(int row, int column, int playerRow, int playerColumn) {
		super(row, column, playerRow, playerColumn);
	}

	public Strategist(Strategist strategist) {
		super(strategist);
	}

	@Override
	public void moveUp() {
		// maybe would have to check some conditions
		// in the future
		this.setRow(this.getRow() - 1);
	}
	
	@Override
	public void moveDown() {
		// maybe would have to check some conditions
		// in the future
		this.setRow(this.getRow() + 1);
	}

	
	@Override
	public void moveRight() {
		// maybe would have to check some conditions
		// in the future
		this.setColumn(this.getColumn() + 1);
	}
	
	@Override
	public void moveLeft() {
		// maybe would have to check some conditions
		// in the future
		this.setColumn(this.getColumn() - 1);
	}
	public char thinkingStrategy(char[] a) {
		String strategy = new String();
		int[] count = {0};
		char[] result = {'W','A','S','D'};
		for (int i =0;i < 5;i++) {
			if (a[i] == 'W') count[0]++;
			if (a[i] == 'A') count[1]++;
			if (a[i] == 'S') count[2]++;
			if (a[i] == 'D') count[3]++;
		}
		int max = 0;
		int maxi = 0;
		for (int i = 0;i < 4;i++) {
			if (count[i] > max) {
				max = count[i];
				maxi = i;
			}
		}
		
		return result[maxi];
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
		return "View/strategist.png";
	}

	@Override
	public char makeMove(int nrows, int ncols) {
		if (playerRow < getRow()) {
			return 'w';
		} else if (playerRow > getRow()) {
			return 's';
		} else if (playerColumn < getColumn()) {
			return 'a';
		} else if (playerColumn > getColumn()){
			return 'd';
		}
		return 'z';
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Strategist(this);
	}

}