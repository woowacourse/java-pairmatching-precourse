package pairmatching.controller;

import java.util.List;

public class MainController {
	public void run() {
		MenuController menuController = new MenuController();
		menuController.select();

		CrewController crewController = new CrewController();
		crewController.loadCrewName();

		if(!menuController.run()) {
			return;
		}
	}
}
