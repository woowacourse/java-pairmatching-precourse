package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.controller.ServiceController;
import pairmatching.validator.ChoiceFormatValidator;
import pairmatching.validator.MatchingInfoFormatValidator;

public class InputView {
	public static String askFunction() {
		return ChoiceFormatValidator.isValidChoice(Console.readLine());
	}

	public static String[] askMatchingInfo() {
		String input = Console.readLine();
		String[] matchingInfo = splitMatchingInfo(input);
		return isExist(matchingInfo);
	}

	private static String[] isExist(String[] matchingInfo) {
		MatchingInfoFormatValidator.isInCourse(matchingInfo[0]);
		MatchingInfoFormatValidator.isInLevel(matchingInfo[1]);
		MatchingInfoFormatValidator.isInMission(ServiceController.missions, matchingInfo[2]);
		return matchingInfo;
	}

	private static String[] splitMatchingInfo(String input) {
		String[] matchingInfo = input.split(", ");
		return MatchingInfoFormatValidator.isNumberOfInfo3(matchingInfo);
	}
}
