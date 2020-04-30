package models;


public class CompletionConditionBD implements CompletionCondition {

	@Override
	public boolean checkCC(Map map) {
		if (map.containsSwitchWithoutBoulder()) {
			return false;
		} 
		if (map.containsEnemy()) {
			return false;
		}
		return true;	
	}

}
