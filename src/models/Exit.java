package models;

public class Exit extends Entity {

	public Exit(int row, int column) {
		super(row, column);
	}

	public Exit(Entity e) {
		super(e);
	}
	@Override
	public String display() {
		return "View/exit.png";
	}

	@Override
	public boolean moveTo() {
		return true;
	}

	@Override
	public int strength() {
		return 2;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null) return false;
		
		if (obj.getClass() != this.getClass()) return false;
		Exit e = (Exit)obj;
		if (e.getRow() != this.getRow()) return false;
		if (e.getColumn() != this.getColumn()) return false;
		return true;
	}

}
