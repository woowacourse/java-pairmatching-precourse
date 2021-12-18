package pairmatching.controller;

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
	}

	public void pairMatching() {
		view.courseLevelMissionInfo();

		boolean rewindSwitch = true;
		while (rewindSwitch) {
			view.selectCourseLevelMission();

			String pairMatchingInput = pairMatchingReceiver.receive();

			if (pairService.isAlreadyPairMatching(pairMatchingInput)) {
				view.rePairMatching();

				String answer = rePairMatchingAskReceiver.receive();
				if (answer.equals("아니오")) {
					continue;
				}
				if (answer.equals("네")) {
					rewindSwitch = false;
				}
			}

			pairService.makePairMatching(pairMatchingInput);
			break;
		}

		view.pairMatchingResult();
	}
}
