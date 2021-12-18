package pairmatching.controller;

import java.util.ArrayList;

import pairmatching.model.CrewList;
import pairmatching.model.receiver.PairMatchingReceiver;
import pairmatching.model.receiver.MainMenuReceiver;
import pairmatching.view.View;

public class Controller {

	View view = new View();
	MainMenuReceiver mainMenuReceiver = new MainMenuReceiver();
	PairMatchingReceiver pairMatchingReceiver = new PairMatchingReceiver();
	CrewList crewList = new CrewList();

	ArrayList<String> backCrewList = crewList.getBackendCrewList();
	ArrayList<String> frontCrewList = crewList.getFrontendCrewList();

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
	}
}
