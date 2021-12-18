package pairmatching;

import pairmatching.maching.MachingController;
import pairmatching.maching.MachingService;

public class Application {
	public static void main(String[] args) {
		MachingController machingController = new MachingController();

		MachingService machingService = new MachingService();

		machingController.run();

	}
}
