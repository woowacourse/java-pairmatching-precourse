package pairmatching.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.constant.Course;
import pairmatching.constant.Hint;
import pairmatching.constant.Level;
import pairmatching.domain.Mission;

public class InputView {

	public static final String MATCHING_INFO_DELIMITER = ", ";

	public static String inputFunctionNumber() {
		System.out.println(Hint.HINT_FUNCTION_SELECTION.getHint());
		return Console.readLine();
	}

	public static Mission inputMatchRequest() {
		System.out.println(Hint.HINT_MATCH_INFO_INPUT.getHint());
		String input = Console.readLine();
		List<String> infoList = Arrays.asList(input.split(MATCHING_INFO_DELIMITER, -1));
		return new Mission(Course.ofName(infoList.get(0)), Level.ofName(infoList.get(1)), infoList.get(2));
	}
}
