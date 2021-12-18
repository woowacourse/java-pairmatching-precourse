package pairmatching.exceptions;

import static pairmatching.constant.ErrorMessages.*;
import static pairmatching.constant.NumberConstant.*;
import static pairmatching.constant.ViewMessage.*;

public class UserInputException {

	public static void isEmpty(String userInput) {
		if (userInput.trim().isEmpty()) {
			throw new IllegalArgumentException(INPUT_NULL + LINE_BREAK);
		}
	}
	public static void isMission(String userInput) {
		isEmpty(userInput);
		String[] missionDetails = userInput.split(MISSION_DETAIL_DIVIDER);
		containDetails(missionDetails);
	}

	private static void containDetails(String[] userInput) {
		if (userInput.length != MISSION_DETAIL_LENGTH) {
			throw new IllegalArgumentException(MISSION_DETAIL_NULL + LINE_BREAK);
		}
	}
}
