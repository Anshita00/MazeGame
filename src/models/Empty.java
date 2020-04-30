package models;

public class Empty extends Entity {

	public Empty(int row, int column) {
		super(row, column);
	}

	public Empty(Entity e) {
		 super(e);
	}
	@Override
	public String display() {
		return "View/ground.png";
	}

	@Override
	public boolean moveTo() {
		return true;
	}

	@Override
	public int strength() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (obj instanceof Empty) return true;
		return false;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Empty(this);
	}


	
	
}
