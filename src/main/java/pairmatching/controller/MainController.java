package pairmatching.controller;

public class MainController {
	public void run() {
		MenuController menuController = new MenuController();
		menuController.select();

		CrewController crewController = new CrewController();
		crewController.loadCrewName();

		ProcessController processController = new ProcessController();
		processController.input();
	}
}
