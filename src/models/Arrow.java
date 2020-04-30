package models;

import java.awt.event.KeyEvent;

public class Arrow extends Collectibles {

	public Arrow (int initRow, int initCol) {
		super(initRow, initCol);
	}

	@Override
	public String display() {
		return "View/Arrow.png";
	}

	@Override
	public int vanish() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numUses() {
		// TODO Auto-generated method stub
		return 1;
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