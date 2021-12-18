package pairmatching.controller;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.repository.PairMap;
import pairmatching.service.PairMatchingService;
import pairmatching.service.Validator;
import pairmatching.view.ErrorMessage;
import pairmatching.view.PairView;

public class PairController {

	private static final int INPUT_SIZE = 3;
	private static final String SPLIT_REGEX = ", ";
	private static final boolean MATCH_START = false;
	private static final String YES = "네";

	public static void startPairMatching() {

		PairView.printGuideMessage();
		List<String> input = getCourseLevelMission();
		PairMatchingService.match(input);
	}

	private static boolean askRematch(List<String> input) {
		String course = input.get(0);
		String level = input.get(1);
		String mission = input.get(2);

		if (PairMap.contains(course, level, mission)) {
			return askInput();
		}
		return MATCH_START;
	}

	private static boolean askInput() {
		PairView.printRematchAsk();
		try {
			String input = Console.readLine();
			Validator.checkValidYesOrNo(input);
			if (input.equals(YES)) {
				return MATCH_START;
			}
			return true;
		} catch (IllegalArgumentException e) {
			ErrorMessage.print(e.getMessage());
			return askInput();
		}
	}

	private static List<String> getCourseLevelMission() {
		PairView.printInputGuideMessage();
		try {
			String inputString = Console.readLine();
			List<String> inputList = getValidStringList(inputString);
			if (askRematch(inputList) != MATCH_START) {
				return getCourseLevelMission();
			}
			return inputList;
		} catch (IllegalArgumentException e) {
			ErrorMessage.print(e.getMessage());
			return getCourseLevelMission();
		}

	}

	private static List<String> getValidStringList(String inputString) {
		Validator.validateFormat(inputString);
		List<String> inputList = Arrays.asList(inputString.split(SPLIT_REGEX));
		Validator.checkListSize(inputList, INPUT_SIZE);
		Validator.checkExistence(inputList);
		return inputList;
	}
}
