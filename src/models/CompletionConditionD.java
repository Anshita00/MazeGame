package models;


public class CompletionConditionD implements CompletionCondition {

	@Override
	public boolean checkCC(Map map) {
		if (map.containsEnemy()) {
			return false;
		} else {
			return true;
		}
	}

}
