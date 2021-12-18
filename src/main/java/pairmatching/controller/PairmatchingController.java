package pairmatching.controller;

import pairmatching.domain.Mission;
import pairmatching.domain.MissionRepository;
import pairmatching.utils.Function;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairmatchingController {
	public void run() {
		while(true) {
			Function function = InputView.getInputOfFunctionType();
			if (function == Function.PAIR_MATCHING) {
				doPairMatching();
			}
			if (function == Function.PAIR_SEARCHING) {
				doPairSearching();
			}
			if (function == Function.PAIR_INITIALIZING) {
				doPairInitializing();
			}
			if (function == Function.QUIT) {
				break;
			}
		}
	}

	private void doPairInitializing() {
		MissionRepository.pairInitializing();
	}

	private void doPairSearching() {
		Mission mission = InputView.getInputOfCourseAndLevelAndMission();
		OutputView.printPairs(mission.getPairs());
	}

	private void doPairMatching() {
		Mission mission = InputView.getInputOfCourseAndLevelAndMission();
		if (mission.isNotMatching()) {
			mission.makePairs();
			OutputView.printPairs(mission.getPairs());
			return;
		}
		if (!mission.isNotMatching()) {
			String yesOrNo = InputView.getInputOfRematching();
			if (yesOrNo.equals("네")) {
				mission.makePairs();
			}
		}
	}
}
