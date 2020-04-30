package models;


public class CompletionConditionDT implements CompletionCondition {

	@Override
	public boolean checkCC(Map map) {
		if (map.containsTreasure()) {
			return false;
		}
		if (map.containsEnemy()) {
			return false;
		}
		return true;
	}

}
