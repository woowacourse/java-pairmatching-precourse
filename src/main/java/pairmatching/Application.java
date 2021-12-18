package pairmatching;

import pairmatching.controller.MatchingController;

public class Application {
	private static final MatchingController matchingController = new MatchingController();

	public static void main(String[] args) {
		matchingController.start();
	}
}
