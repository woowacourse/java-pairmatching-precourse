package pairmatching;

import pairmatching.controller.FileInputController;
import pairmatching.controller.MainMenuController;
import pairmatching.controller.MissionController;

public class Application {
	public static void main(String[] args) {
		// TODO 구현 진행
		initApplication();
		startMainMenu();
	}

	private static void startMainMenu() {
		MainMenuController.mainMenuStart();
	}

	private static void initApplication() {
		FileInputController.setCrewMembers();
		MissionController.initLevelToMission();


	}
}
