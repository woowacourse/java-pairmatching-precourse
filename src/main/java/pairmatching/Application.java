package pairmatching;

import pairmatching.controller.CrewMatchingController;

public class Application {
	public static void main(String[] args) {
		CrewMatchingController crewMatchingController = new CrewMatchingController();
		crewMatchingController.start();
	}
}
