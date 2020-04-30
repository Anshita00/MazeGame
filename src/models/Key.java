package models;


public class Key extends Collectibles{

	static int KeyID = 0;
	int id;
	private int use = 1;
	public Key(int row, int col) {
		super(row, col);
		id = KeyID;
		KeyID++;
	}

	@Override
	public int vanish() {
		if(this.use == 0) {
			return 0;
		}
		return this.use--;
	}

	public int getId() {
		return id;
	}


	@Override
	public int numUses() {
		return this.use;
	}



	@Override
	public String display() {
		return "View/key.png";
	}



	@Override
	public boolean moveTo() {
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj == this) return true;
		if (!(obj instanceof Key)) return false;
		return true;
	}



	@Override
	public int strength() {
		return 1;
	}
	
	
}
