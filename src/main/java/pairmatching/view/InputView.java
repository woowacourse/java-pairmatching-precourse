package pairmatching.view;

import static pairmatching.utils.Constant.*;
import static pairmatching.view.Message.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static String inputPairMode() {
		FUNCTION_SELECT.forEach(System.out::println);
		return Console.readLine().trim();
	}

	public static String inputPairMatchingInfo() {
		return getUserStringInput(SELECT_PAIR_MATCHING_LIST);
	}

	private static String getUserStringInput(String message) {
		System.out.println(message);
		return Console.readLine().trim().replaceAll(SPACE, EMPTY);
	}

	public static String inputRematchingAnswer() {
		return getUserStringInput(ASK_REMATCHING);
	}
}
