package models;


public class CompletionConditionB implements CompletionCondition {

	@Override
	public boolean checkCC(Map map) {
		if (map.containsSwitchWithoutBoulder()) {
			return false;
		} else {
			return true;
		}
	}

}
