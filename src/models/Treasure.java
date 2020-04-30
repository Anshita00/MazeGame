package models;


public class Treasure extends Collectibles{

	
	private int use = 0;
	public Treasure(int row, int col) {
		super(row, col);
		// TODO Auto-generated constructor stub
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
			return 1;
		}
		

		@Override
		public String display() {
			return "View/treasure.png";
		}

		@Override
		public boolean moveTo() {
			return true;
		}

		@Override
		public int strength() {
			return 1;
		}

	}
		
