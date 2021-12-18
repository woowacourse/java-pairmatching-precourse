package pairmatching.controller;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.PairResult;
import pairmatching.domain.PairResults;
import pairmatching.utill.CrewFileReader;
import pairmatching.utill.RandomShuffle;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
	private static final int COURSE_INDEX = 0;
	private static final int LEVEL_INDEX = 1;
	private static final int MISSION_INDEX = 2;
	private static final int MAX_TRY_COUNT = 3;
	private static final int MATCHING_OPTION = 1;
	private static final int GET_INFO_OPTION = 2;
	private static final int INIT_OPTION = 3;
	private static final String MATCHING_FAIL_ERROR_MSG = "매칭에 실패했습니다.";
	private static final String NOT_EXIST_MATCHING_ERROR_MSG = "매칭 이력이 존재하지 않습니다.";

	public void runPairMatching() {
		String option = InputView.inputOption();

		while (!option.equals("Q")) {
			matchOption(Integer.parseInt(option));
			option = InputView.inputOption();
		}
	}

	private void matchOption(int optionNum) {
		if (optionNum == MATCHING_OPTION) {
			executeMatchingSystem();
		}
		if (optionNum == GET_INFO_OPTION) {
			displayMatchingInfo();
		}
		if (optionNum == INIT_OPTION) {
			initializeMatching();
		}
	}

	private void initializeMatching() {
		OutputView.displayInitMsg();
		PairResults.clearPairResults();
	}

	private void displayMatchingInfo() {
		OutputView.displayInfo(getCourseInfo(), getMissionInfo());
		List<String> matchingOption = InputView.inputMatchingOption();
		List<String> result = PairResults.findPairResult(Course.matchValue(matchingOption.get(COURSE_INDEX)),
			Level.matchValue(matchingOption.get(LEVEL_INDEX)),
			matchingOption.get(MISSION_INDEX)).getPairs();
		if (!result.isEmpty()) {
			OutputView.displayMatchingResult(result);
			return;
		}
		OutputView.displayErrorMsg(NOT_EXIST_MATCHING_ERROR_MSG);
	}

	private List<String> getCourseInfo() {
		List<String> courseList = new ArrayList<>();
		for (Course course : Course.values()) {
			courseList.add(course.getName());
		}
		return courseList;
	}

	private List<String> getMissionInfo() {
		List<String> missionList = new ArrayList<>();
		for (Level level : Level.values()) {
			StringBuilder missions = new StringBuilder();
			List<String> levelMission = level.getMission();
			for (int i = 0; i < levelMission.size(); i++) {
				missions.append(levelMission.get(i));
				if (i != levelMission.size() - 1) {
					missions.append(" | ");
				}
			}
			missionList.add(missions.toString());
		}
		return missionList;
	}

	public void executeMatchingSystem() {
		OutputView.displayInfo(getCourseInfo(), getMissionInfo());
		List<String> matchingOption = InputView.inputMatchingOption();
		if (PairResults.isExistPairResult(Course.matchValue(matchingOption.get(COURSE_INDEX)),
			Level.matchValue(matchingOption.get(LEVEL_INDEX)), matchingOption.get(MISSION_INDEX))
			&& InputView.inputMatchingOptionAgain().equals("아니오")) {
			executeMatchingSystem();
			return;
		}
		try {
			OutputView.displayMatchingResult(matchPair(matchingOption));
		} catch (IllegalArgumentException e) {
			OutputView.displayErrorMsg(e.getMessage());
		}
	}

	public List<String> matchPair(List<String> matchingOption) throws IllegalArgumentException {
		int count = 0;
		PairResult pairResult;
		List<String> crewList = CrewFileReader.getCrewList(Course.matchValue(matchingOption.get(COURSE_INDEX)));
		while (count != MAX_TRY_COUNT) {
			crewList = RandomShuffle.shuffleNames(crewList);
			pairResult = createPairs(matchingOption, crewList);
			if (!isAlreadyMatched(matchingOption, pairResult)) {
				PairResults.addPairResult(pairResult);
				return pairResult.getPairs();
			}
			count++;
		}
		throw new IllegalArgumentException(MATCHING_FAIL_ERROR_MSG);
	}

	private boolean isAlreadyMatched(List<String> matchingOption, PairResult pairResult) {
		return PairResults.isExist(matchingOption, pairResult);
	}

	private PairResult createPairs(List<String> matchingOption, List<String> crewList) {
		List<String> pairs = new ArrayList<>();
		for (int i = 0; i < crewList.size() - 1; i += 2) {
			String pair = crewList.get(i) + " : " + crewList.get(i + 1);
			pairs.add(pair);
		}
		if (crewList.size() % 2 == 1) {
			String lastPair = pairs.get(pairs.size() - 1) + " : " + crewList.get(crewList.size() - 1);
			pairs.remove(pairs.size() - 1);
			pairs.add(lastPair);
		}
		return new PairResult(Course.matchValue(matchingOption.get(COURSE_INDEX)),
			Level.matchValue(matchingOption.get(LEVEL_INDEX)), matchingOption.get(MISSION_INDEX), pairs);
	}
}