package models;


public class CompletionConditionBDT implements CompletionCondition {

	@Override
	public boolean checkCC(Map map) {
		if (map.containsSwitchWithoutBoulder()) {
			return false;
		} 
		if (map.containsTreasure()) {
			return false;
		}
		if (map.containsEnemy()) {
			return false;
		}
		return true;
	}
	
}
