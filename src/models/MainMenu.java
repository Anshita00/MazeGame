package models;

import java.util.Scanner;

public class MainMenu implements State {
	
	private AppSystem app;
	
	// Constructor
	public MainMenu(AppSystem app) {
		this.app = app;
	}
	
	
	@Override
	public void enterMainMenu() {
		System.out.println("You are already in the main menu!");
	}

	
	@Override
	public void enterPlayMode() {
		app.changeState(app.getPlayMode());
		app.enterPlayMode();	
	}

	
	@Override
	public void enterDesignMode() {
		app.changeState(app.getDesignMode());
		app.enterDesignMode();
	}
	

	@Override
	public void execute() {
		System.out.println("Welcome to the MainMenu!");
		System.out.println("Press p to Play a Map");
		System.out.println("Press d to Design a map");
		
		Scanner sc = new Scanner(System.in);
		String result = sc.nextLine();
		
		if (result.equals("p")) {
			enterPlayMode();
		}
		else if (result.equals("d")) {
			enterDesignMode();
		}	
		
	}
	
}







