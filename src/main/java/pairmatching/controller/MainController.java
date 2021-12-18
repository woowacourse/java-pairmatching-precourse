package pairmatching.controller;

public class MainController {

	public void run() {
		MatchingService matchingService = new MatchingService();
		matchingService.makeList();
		matchingService.selectFunction();
	}

}
