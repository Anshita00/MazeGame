package models;


public class CompletionConditionE implements CompletionCondition {

	@Override
	public boolean checkCC(Map map) {
		return map.playerAtExit();
	}

}
