package models;



public class Hound extends Enemy {

	int hunterRow;
	int hunterColumn;
	public Hound(int row, int column, int playerRow, int playerColumn, Hunter h) {
		super(row, column, playerRow, playerColumn);
		hunterRow = h.getRow();
		hunterColumn = h.getColumn();
	}
	
	public void update(int hunterRow, int hunterColumn) {
		this.hunterRow = hunterRow;
		this.hunterColumn = hunterColumn;
	}

	public Hound(Hound hound) {
		super(hound);
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
		return "View/hound.png";
	}

	@Override
	public char makeMove(int nrows, int ncols) {
		
			// Use mid-point formula to find out what row I should be in
			int houndRow = playerRow*2 - hunterRow;
			int houndColumn = playerColumn*2 - hunterColumn;
			return moveTowards(houndRow, houndColumn, nrows, ncols);
		
	}
	public boolean isFar() {
		if (hunterRow - getRow() <= 1 && hunterRow - getRow() >= -1 && 
hunterColumn - getColumn() <=1 && hunterColumn - getColumn() >= -1) {
			return false;
		}
		return true;
	}
	public char moveTowards(int row, int col, int nrows, int ncols) {
		
		if (col<= getColumn() && getColumn() != 0) {
			return 'a';
		} else if (col > getColumn()){
			return 'd';
		} else if (row <= getRow() && getRow() != 0) {
			return 'w';
		} else if (row > getRow()) {
			return 's';
		} 
		return 'z';
		
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null) return false;
		if (obj.getClass() != this.getClass()) return false;
		return true;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Hound(this);
	}
}