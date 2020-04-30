package models;


public class FloorSwitch extends Entity {
	public FloorSwitch(int row, int column) {
		super(row, column);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String display() {
		return "View/FloorSwitch.png";
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

}
