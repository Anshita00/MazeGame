package models;


public interface State {
	
	public void enterMainMenu();
	
	public void enterPlayMode();
	
	public void enterDesignMode();
	
	public void execute();

}
