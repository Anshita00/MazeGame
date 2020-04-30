package models;


public class HoverPotion extends Collectibles{

	
	
	public HoverPotion(int row, int col) {
		super(row, col);
		// TODO Auto-generated constructor stub
	}


	private int use = 500;
	
	

	//vanish from the maze
	@Override
	public int vanish() {
		return 1;
	}

	
	//unlimited time for hover potion
	@Override
	public int numUses() {
		return this.use;
	}


	@Override
	public String display() {
		// TODO Auto-generated method stub
		return "View/hoverPotion.png";
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
