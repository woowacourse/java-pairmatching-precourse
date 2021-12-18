package pairmatching.validator;

import static constants.PairMatchingConstants.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class PairBackgroundInfoValidator {

	public static List<String> checkInput(String userInput) {
		checkIsEmpty(userInput);
		isMatchRegex(userInput);
		List<String> PairBackgroundInfo = Arrays.asList(userInput.split(", "));
		isExistValues(PairBackgroundInfo);
		return PairBackgroundInfo;
	}

	private static void checkIsEmpty(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException("d");
		}
	}

	private static void isMatchRegex(String userInput) {
		String REGEX = "[가-힣]{3,}, [가-힣1-5]{3}, [가-힣]{2,}";
		if (!Pattern.matches(REGEX, userInput)) {
			throw new IllegalArgumentException(INPUT_FORMAT_ERROR);
		}
	}

	private static void isExistValues(List<String> pairBackgroundInfo) {
		Course.findByName(pairBackgroundInfo.get(0));
		Level.findByName(pairBackgroundInfo.get(1));
		Mission.findByName(pairBackgroundInfo.get(2));
	}

}
