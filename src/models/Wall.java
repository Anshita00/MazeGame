package models;


public class Wall extends Entity {

	public Wall(int row, int column) {
		super(row, column);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String display() {
		return "View/wall.png";
		
	}

	@Override
	public boolean moveTo() {
		return false;
	}

	@Override
	public int strength() {
		return 3;
	}

}
