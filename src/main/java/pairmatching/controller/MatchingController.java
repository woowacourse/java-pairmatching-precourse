package pairmatching.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.common.Course;
import pairmatching.common.Level;
import pairmatching.common.Mission;
import pairmatching.common.RematchOption;
import pairmatching.domain.Backends;
import pairmatching.domain.Frontends;
import pairmatching.domain.Pair;
import pairmatching.domain.Pairs;
import pairmatching.domain.PairsRecord;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {
	private static final int NUMBER_OF_TYPE = 3;
	private static final int COURSE_INDEX = 0;
	private static final int LEVEL_INDEX = 1;
	private static final int MISSION_INDEX = 2;
	private static final String REMATCH_YES = "네";
	private static final String REMATCH_NO = "아니오";
	private static final String ERROR = "[ERROR]: ";
	private static final String ERROR_INVALID_INPUT_FORMAT = ERROR + "과정, 레벨, 미션 세 단위로 입력해야 합니다.";
	private static final String ERROR_INVALID_COURSE_TYPE = ERROR + "존재하지 않는 과정입니다.";
	private static final String ERROR_INVALID_LEVEL_TYPE = ERROR + "존재하지 않는 레벨입니다.";
	private static final String ERROR_INVALID_MISSION_TYPE = ERROR + "존재하지 않는 미션입니다.";

	private static final List<String> CourseList = Arrays.stream(Course.values())
		.map(Course::getCourse)
		.collect(Collectors.toList());
	private static final List<String> LevelList = Arrays.stream(Level.values())
		.map(Level::getLevel)
		.collect(Collectors.toList());
	private static final List<String> MissionList = Arrays.stream(Mission.values())
		.map(Mission::getMission)
		.collect(Collectors.toList());

	private final InputView inputView;
	private final OutputView outputView;
	private PairsRecord pairsRecord = new PairsRecord();

	public MatchingController(final InputView inputView, final OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		outputView.printCoursesAndMissions();
		outputView.printEnterConditionRequest();
		List<String> condition = getPairCondition();
		match(condition);
		// if (pairsRecord.isExistent(condition)) {
		// 	String option = askRematchChoice();
		// 	if (option.equals(REMATCH_YES)) {
		//
		// 	}
		// 	if (option.equals(REMATCH_NO)) {
		// 	}
		// }

	}

	private String askRematchChoice() {
		List<RematchOption> rematchOptionList = Arrays.stream(RematchOption.values()).collect(Collectors.toList());
		try {
			return inputView.selectRematchOption(rematchOptionList);
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return askRematchChoice();
		}
	}

	private List<String> getPairCondition() {
		try {
			List<String> condition = enterCondition();
			validate(condition);
			return condition;
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return getPairCondition();
		}
	}

	private List<String> enterCondition() {
		List<String> condition = inputView.scanPairCondition();
		if (condition.size() != NUMBER_OF_TYPE) {
			throw new IllegalArgumentException(ERROR_INVALID_INPUT_FORMAT);
		}
		return condition;
	}

	private void validate(List<String> condition) {
		System.out.println(condition);
		if (!CourseList.contains(condition.get(COURSE_INDEX))) {
			throw new IllegalArgumentException(ERROR_INVALID_COURSE_TYPE);
		}
		if (!LevelList.contains(condition.get(LEVEL_INDEX))) {
			throw new IllegalArgumentException(ERROR_INVALID_LEVEL_TYPE);
		}
		if (!MissionList.contains(condition.get(MISSION_INDEX))) {
			throw new IllegalArgumentException(ERROR_INVALID_MISSION_TYPE);
		}
	}

	private void match(List<String> condition) {
		List<String> crewName = new ArrayList<>();
		if (condition.get(COURSE_INDEX).equals(Course.BACKEND.getCourse())) {
			crewName = Randoms.shuffle(Backends.getCrews());
			Pairs pairs = makePairs(condition, crewName);
			outputView.printMatchResult(pairs);
			if (condition.get(COURSE_INDEX).equals(Course.FRONTEND.getCourse())) {
				crewName = Randoms.shuffle(Frontends.getCrews());
				Pairs pairs2 = makePairs(condition, crewName);
				outputView.printMatchResult(pairs2);
			}

		}
	}

	private Pairs makePairs(List<String> condition, List<String> crewName) {
		Pairs pairs = new Pairs(condition);
		for (int i = 0; i < crewName.size(); i++) {
			List<String> temp = new ArrayList<>();
			temp.add(crewName.get(i));
			temp.add(crewName.get(i + 1));
			pairs.add(new Pair(temp));
		}
		return pairs;
	}

}
