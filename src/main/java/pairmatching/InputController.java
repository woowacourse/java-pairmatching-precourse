package pairmatching;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputController {
	private static final int LEVEL_INDEX = 1;
	private static final String INVALID_REMATCH_RESPONSE = "[ERROR] 응답은 네 혹은 아니오여야만 합니다.";

	InputController() {
	}

	public static String getFunctionChoice() {
		String choice = Console.readLine();
		//validate
		return choice;
	}

	public static List<String> getCourseTupleChoice() {
		String choice = Console.readLine();
		String[] words = choice.split(Constants.COMMA);
		return Arrays.stream(words).map(String::trim).collect(Collectors.toList());
		//validate
	}

	public static boolean getReMatchResponse() throws IllegalArgumentException {
		String response = Console.readLine();
		if (response.equals("네")) {
			return true;
		}
		if (response.equals("아니오")) {
			return false;
		}
		throw new IllegalArgumentException(INVALID_REMATCH_RESPONSE);
	}
}
