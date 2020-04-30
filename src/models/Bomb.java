package models;


public class Bomb extends Collectibles {

	private int use = 1;
	private int timeLeft = 4;
	public Bomb(int row, int col) {
		super(row, col);
	}

	@Override
	public int vanish() {
		if(this.use == 0) {
			return 0;
		}
		return this.use--;
	}

	@Override
	public int numUses() {
		return this.use;
	}

	@Override
	public String display() {
		if (use == 1)
			return "View/bomb.png";
		else if (timeLeft == 0){
			return "View/bombExplode.png";
		} else if (timeLeft == 1){
			return "View/bomb2.png";
		} else if (timeLeft == 2){
			return "View/bomb1.png";
		} else {
			return "View/ground.png";
		}
	}

	@Override
	public boolean moveTo() {
		return true;
	}

	@Override
	public int strength() {
		return 2;
	}
	
	public void useBomb() {
		timeLeft--;
	}
	
	public boolean canExplode() {
		return (timeLeft == 0);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj == this) return true;
		if (obj instanceof Bomb) return true;
		return false;
	}

	
}
