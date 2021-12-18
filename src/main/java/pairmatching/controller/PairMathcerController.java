package pairmatching.controller;

import java.util.Arrays;
import java.util.stream.Collectors;

import pairmatching.domain.PairMatcher;
import pairmatching.domain.input.FunctionType;
import pairmatching.domain.input.Level;
import pairmatching.domain.input.LevelMissionInfo;
import pairmatching.domain.mission.LevelFourMission;
import pairmatching.domain.mission.LevelOneMission;
import pairmatching.domain.mission.LevelTwoMission;
import pairmatching.view.ErrorView;
import pairmatching.view.InputView;

public class PairMathcerController {
	private PairMatcher pairMatcher;
	private LevelMissionInfo levelMissionInfo;

	public PairMathcerController() {
		pairMatcher = new PairMatcher();
		levelMissionInfo = LevelMissionInfo.newInstance();
	}

	public void init() {
		initLevelAndMissionInfo();
		selectFunctionOptions();
		String matchingTarget = InputView.getMatchingTarget(levelMissionInfo);
	}

	private void initLevelAndMissionInfo() {
		levelMissionInfo.addInfo(Level.LEVEL1, Arrays.stream(LevelOneMission.values())
			.map(LevelOneMission::getName)
			.collect(Collectors.toList())
		);
		levelMissionInfo.addInfo(Level.LEVEL2, Arrays.stream(LevelTwoMission.values())
			.map(LevelTwoMission::getName)
			.collect(Collectors.toList())
		);
		levelMissionInfo.addInfo(Level.LEVEL3);
		levelMissionInfo.addInfo(Level.LEVEL4, Arrays.stream(LevelFourMission.values())
			.map(LevelFourMission::getName)
			.collect(Collectors.toList())
		);
		levelMissionInfo.addInfo(Level.LEVEL5);
	}

	private void selectFunctionOptions() {
		try {
			String inputFunctionNumber = InputView.getFunctionNumber();
			run(inputFunctionNumber);
		} catch (IllegalArgumentException e) {
			ErrorView.printErrorMesasge(e.getMessage());
			selectFunctionOptions();
		}
	}

	public void run(String inputFunctionNumber) {
		FunctionType functionType = FunctionType.fromFunctionNumber(inputFunctionNumber);

		if (functionType == FunctionType.MATCH) {
			return;
		}
		if (functionType == FunctionType.VIEW) {
			viewPairs();
			return;
		}
		if (functionType == FunctionType.RESET) {
			resetPairs();
			return;
		}
		if (functionType == FunctionType.EXIT) {
			exit();
		}
	}

	private void matchPairs(String matchingTarget) {
		pairMatcher.matchPairs(matchingTarget);
	}

	private void viewPairs() {}

	private void resetPairs() {
		pairMatcher.resetMatchingInfo();
	}

	private void exit() {
	}

}
