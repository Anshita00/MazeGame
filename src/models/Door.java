package models;


public class Door extends Entity {

	public boolean closed;
	Key myKey;
	
	public Door(int row, int column, Key k) {
		super(row, column);
		closed = true;
		myKey = k;
	}

	@Override
	public String display() {
		if (closed) {
			return "View/closedDoor.png";
		} else {
			return "View/openDoor.png";
		}
	}


	@Override
	public boolean moveTo() {
		return !closed;
	}

	@Override
	public int strength() {
		return 2;
	}
	
	public boolean openDoor(Key k) {
		if (k.getId() == myKey.getId()) {
			System.out.println("Same key");
			closed = false;
			k.vanish();
			myKey.vanish();
			return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj == this) return true;
		if (obj instanceof Door) return true;
		return false;
	}
	
	
}
