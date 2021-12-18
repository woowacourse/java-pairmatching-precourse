package pairmatching;

import pairmatching.controller.MainController;
import pairmatching.initialize.CrewInitialize;

public class Application {
	public static void main(String[] args) {
		CrewInitialize.readFiles();
		MainController mainController = new MainController();
		mainController.inputMenu();
	}
}
