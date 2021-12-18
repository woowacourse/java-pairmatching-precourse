package pairmatching.controller;

public class PairRetrieveController {
	public void run() {
		ProcessController processController = new ProcessController();
		do {
			processController.input();

		} while (!validate());
	}

	private boolean validate() {
		return false;
	}
}
