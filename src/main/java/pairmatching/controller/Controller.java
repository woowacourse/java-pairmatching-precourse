package pairmatching.controller;

import pairmatching.model.receiver.MainMenuReceiver;
import pairmatching.view.View;

public class Controller {

	View view = new View();
	MainMenuReceiver mainMenuReceiver = new MainMenuReceiver();

	public void run() {
		mainMenu();
	}

	public void mainMenu () {
		view.mainMenu();

		String menuInput = mainMenuReceiver.receive();
	}
}
