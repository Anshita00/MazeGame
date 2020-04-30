package models;

//import java.util.ArrayList;

public class InvincibilityPotion extends Collectibles{

	private int use = 10;
	
	public InvincibilityPotion(int row, int col) {
		super(row, col);
		//super();
	}
	

	//vanish from the maze
	@Override
	public int vanish() {
		if(this.use == 0) {
			return 0;
		}
		return this.use--;
	}

	//unlimited time for hover potion
	@Override
	public int numUses() {
		return this.use;
	}
	

	@Override
	public String display() {
		return "View/invincPotion.png";
	}

	@Override
	public boolean moveTo() {
		return true;
	}

	@Override
	public int strength() {
		return 1;
	}
	
//	public boolean hasIP(Player p) {
//		
//		for(ArrayList<Object> e = p.items) {
//			if(e instanceof InvincibilityPotion) {
//				return true;
//			}
//		}
//		
//		return false;
//	}
	
	

}
	

