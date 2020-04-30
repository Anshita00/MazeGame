package models;


public class Sword extends Collectibles {

	
	private int use = 100;
	public Sword(int row, int column) {
		super(row, column);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String display() {
		return "View/sword.png";	
	}

	@Override
	public boolean moveTo() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int strength() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int vanish() {
		// TODO Auto-generated method stub
		return this.use--;
	}

	@Override
	public int numUses() {
		// TODO Auto-generated method stub
		return this.use;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null) return false;
		
		if (obj.getClass() != this.getClass()) return false;
		return true;
	}

}
