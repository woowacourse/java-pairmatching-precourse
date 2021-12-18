package pairmatching;

import pairmatching.controller.FileInputController;
import pairmatching.controller.MissionController;

public class Application {
	public static void main(String[] args) {
		// TODO 구현 진행
		initApplication();
	}

	private static void initApplication() {
		FileInputController.setCrewMembers();
		MissionController.initLevelToMission();
	}
}
