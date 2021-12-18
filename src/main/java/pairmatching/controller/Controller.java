package pairmatching.controller;

import pairmatching.model.PairMatching;
import pairmatching.model.receiver.PairMatchingReceiver;
import pairmatching.model.receiver.MainMenuReceiver;
import pairmatching.model.receiver.RePairMatchingAskReceiver;
import pairmatching.model.service.PairService;
import pairmatching.view.View;

public class Controller {

	View view = new View();
	MainMenuReceiver mainMenuReceiver = new MainMenuReceiver();
	PairMatchingReceiver pairMatchingReceiver = new PairMatchingReceiver();
	PairService pairService = new PairService();
	RePairMatchingAskReceiver rePairMatchingAskReceiver = new RePairMatchingAskReceiver();

	public void run() {
		mainMenu();
	}

	public void mainMenu() {
		view.mainMenu();

		String mainMenuInput = mainMenuReceiver.receive();

		if (mainMenuInput.equals("1")) {
			pairMatching();
		}

		if (mainMenuInput.equals("Q")) {
		}
	}

	public void pairMatching() {
		view.courseLevelMissionInfo();

		String pairMatchingInput = "";

		boolean rewindSwitch = true;
		while (rewindSwitch) {
			view.selectCourseLevelMission();

			pairMatchingInput = pairMatchingReceiver.receive();

			if (pairService.isAlreadyPairMatching(pairMatchingInput)) {
				view.rePairMatching();
				String answer = rePairMatchingAskReceiver.receive();
				if (answer.equals("아니오")) {
					continue;
				}
				if (answer.equals("네")) {
					PairMatching pairMatching = pairService.findPairMatching(pairMatchingInput);
					pairMatching.getPairList().clear();
					rewindSwitch = false;
				}
			}

			pairService.makePairMatching(pairMatchingInput);
		}

		view.pairMatchingResult();

		mainMenu();
	}
}
