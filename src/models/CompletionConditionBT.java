package models;


public class CompletionConditionBT implements CompletionCondition {

	@Override
	public boolean checkCC(Map map) {
		if (map.containsSwitchWithoutBoulder()) {
			return false;
		} 
		if (map.containsTreasure()) {
			return false;
		}
		return true;
	}

}
