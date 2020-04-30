package models;


public class Pit extends Entity{

	public Pit(int row, int column) {
		super(row, column);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String display() {
		return "View/pit.png";
	}

	@Override
	public boolean moveTo() {
		return true;
	}

	@Override
	public int strength() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null) return false;
		
		if (obj.getClass() != this.getClass()) return false;
		Pit p = (Pit)obj;
		if (p.getRow() != this.getRow()) return false;
		if (p.getColumn() != this.getColumn()) return false;
		return true;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Pit(getRow(), getColumn());
	}
}
