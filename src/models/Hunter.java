package models;


public class Hunter extends Enemy {

	private Hound h;
	public Hunter (int initRow, int initCol, int playerRow, int playerColumn) {
		super(initRow, initCol, playerRow, playerColumn);
		h = null;
	}
	public Hunter(Hunter hunter) {
		super(hunter);
	}
	@Override
	public void moveUp() {
		// maybe would have to check some conditions
		// in the future
		this.setRow(this.getRow() - 1);
		if (h != null) {
			this.notiFy();
		}
	}
	
	@Override
	public void moveDown() {
		// maybe would have to check some conditions
		// in the future
		this.setRow(this.getRow() + 1);
		if (h != null) {
			this.notiFy();
		}
	}
	public void addHound(Hound h) {
		this.h = h;
	}
	
	@Override
	public void moveRight() {
		// maybe would have to check some conditions
		// in the future
		this.setColumn(this.getColumn() + 1);
		if (h != null) {
			this.notiFy();
		}
	}
	
	@Override
	public void moveLeft() {
		// maybe would have to check some conditions
		// in the future
		this.setColumn(this.getColumn() - 1);
		if (h != null) {
			this.notiFy();
		}
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
	
	public void notiFy() {
		this.h.update(getRow(), getColumn());
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
		return 3;
	}
	@Override
	public String display() {
		return "View/hunter.png";
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Hunter(this);
	}
}