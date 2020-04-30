package models;


public class CompletionConditionT implements CompletionCondition {

	@Override
	public boolean checkCC(Map map) {
		if (map.containsTreasure()) {
			return false;
		} else {
			return true;
		}
	}

}
