package models;

public abstract class Entity implements Displayable, Cloneable {
		private int row;
		private int column;
		public Entity( int row, int column) {
			this.row = row;
			this.column = column;
		}
		
		public Entity (Entity e) {
			this.row = e.row;
			this.column = e.column;
		}
		public abstract boolean moveTo();
		public abstract int strength();
		public int getRow() {
			return row;
		}
		public void setRow(int row) {
			this.row = row;
		}
		public int getColumn() {
			return column;
		}
		public void setColumn(int column) {
			this.column = column;
		}

		@Override
		protected Object clone() throws CloneNotSupportedException {
			return super.clone();
		}

		@Override
		public String display() {
			return "";
			
		}
		
}
