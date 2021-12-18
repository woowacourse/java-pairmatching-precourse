package pairmatching;

import pairmatching.controller.MenuController;

public class Application {
	public static final MenuController menuController = new MenuController();

	public static void main(String[] args) {
		menuController.inputMainMenu();
	}
}
