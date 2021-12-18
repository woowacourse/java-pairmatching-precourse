package pairmatching.controller;

import pairmatching.model.receiver.PairMatchingReceiver;
import pairmatching.model.receiver.MainMenuReceiver;
import pairmatching.model.service.PairService;
import pairmatching.view.View;

public class Controller {

	View view = new View();
	MainMenuReceiver mainMenuReceiver = new MainMenuReceiver();
	PairMatchingReceiver pairMatchingReceiver = new PairMatchingReceiver();
	PairService pairService = new PairService();

	public void run() {
		mainMenu();
	}

	public void mainMenu() {
		view.mainMenu();

		String mainMenuInput = mainMenuReceiver.receive();

		if (mainMenuInput.equals("1")) {
			pairMatching();
		}
	}

	public void pairMatching() {
		view.pairMatching();

		String pairMatchingInput = pairMatchingReceiver.receive();

		if (pairService.isAlreadyPairMatching(pairMatchingInput)) {
			view.rePairMatching();
		}

		pairService.makePairMatching(pairMatchingInput);
	}
}
