package models;


public abstract class Enemy extends MovableItems {

	int playerRow;
	int playerColumn;
	public Enemy(int row, int column, int playerRow, int playerColumn) {
		super(row, column);
		this.playerRow = playerRow;
		this.playerColumn = playerColumn;
	}
	
	public int getPlayerRow() {
		return playerRow;
	}

	public int getPlayerColumn() {
		return playerColumn;
	}

	public void update(int playerRow, int playerColumn) {
		this.playerRow = playerRow;
		this.playerColumn = playerColumn;
	}
	abstract public char makeMove(int nrows, int ncols);
	public Enemy(Enemy e) {
		super(e.getRow(), e.getColumn());
		this.playerRow = e.getPlayerRow();
		this.playerColumn = e.getPlayerColumn();
	}
	

}
