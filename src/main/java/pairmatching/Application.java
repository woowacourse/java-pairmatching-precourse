package pairmatching;

import pairmatching.controller.MatchingController;

public class Application {

	private final AppConfig appConfig = AppConfig.getInstance();

	public static void main(String[] args) {
		Application application = new Application();
		application.run();
	}

	public void run() {
		MatchingController matchingController = appConfig.matchingController;
		matchingController.run();
	}

}
