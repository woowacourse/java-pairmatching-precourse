package pairmatching.controller;

import static pairmatching.constant.ErrorMessages.*;
import static pairmatching.constant.ViewMessage.*;

import java.util.Optional;

import pairmatching.domains.crew.BackendCrews;
import pairmatching.domains.crew.CrewPair;
import pairmatching.domains.crew.FrontendCrews;
import pairmatching.domains.mission.Mission;
import pairmatching.domains.mission.Missions;
import pairmatching.domains.programfunc.ProgramSelection;
import pairmatching.exceptions.UserInputException;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController {
	private FrontendCrews frontendCrews;
	private BackendCrews backendCrews;
	private Missions missions;

	public PairController(FrontendCrews frontendCrews, BackendCrews backendCrews,
		Missions missions) {
		this.frontendCrews = frontendCrews;
		this.backendCrews = backendCrews;
		this.missions = missions;
	}

	public void initiate() {
		frontendCrews.setFrontendCrews();
		backendCrews.setBackendCrews();
		missions.loadMission();

		run();
	}

	private void run() {
		try {
			OutputView.printSelection();
			ProgramSelection userSelect = InputView.getUserSelect();
			doSelection(userSelect);
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR_PREFIX + e.getMessage());
			run();
		}
	}

	private void doSelection(ProgramSelection selection) {
		if (selection == ProgramSelection.MATCHING) {
			matching();
		} else if (selection == ProgramSelection.FIND_PAIR) {
			findPair();
		} else if (selection == ProgramSelection.CLEAR) {
			clearAll();
		} else if (selection == ProgramSelection.QUIT) {
			return;
		}
		run();
	}

	private void matching() {
		Mission userMission = getUserMission();
		checkShuffled(userMission);

	}

	private void checkShuffled(Mission mission) {
		String shuffleMessage = YES_MESSAGE;
		if (mission.isShuffled()) {
			shuffleMessage = InputView.printShuffleMessage();
		}
		try {
			UserInputException.checkYesOrNo(shuffleMessage);
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR_PREFIX + e.getMessage());
		}
		if (shuffleMessage.equals(NO_MESSAGE)) {
			return;
		}
		mission.shufflePairs();
	}

	private void findPair() {
		Mission userMission = getUserMission();
		if (!userMission.isShuffled()) {
			OutputView.printMatchedYet();
			return;
		}
	}

	private Mission getUserMission() {
		try {
			OutputView.printTechCourseState();
			return InputView.getUserMission(missions);
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR_PREFIX + e.getMessage());
			getUserMission();
		}
		return null;
	}

	private void clearAll() {
		missions.clearAllMatching();
	}


}
