package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.model.Menu;

public class InputView {
	public static final String WRONG_MENU_CHOICE_INPUT = "잘못된 메뉴 정보를 입력하셨습니다.";
	public static final String MISSING_INPUT_FOR_PAIR_MATCHING = "과정, 레벨, 미션을 모두 입력해주세요.";
	public static final String REGEX = ",";
	public static final int INFO_SIZE = 3;

	public static String selectMenu() {
		String choice = Console.readLine();
		validateMenuChoiceInput(choice);

		return choice;
	}

	public static String inputInfoForPairMatching() {
		String inputForPairMatching = Console.readLine();
		validateNotMissiedInfo(inputForPairMatching);

		return inputForPairMatching;
	}

	private static void validateNotMissiedInfo(String inputForPairMatching) {
		if (isInfoMissed(inputForPairMatching)) {
			throw new IllegalArgumentException(MISSING_INPUT_FOR_PAIR_MATCHING);
		}
	}

	private static boolean isInfoMissed(String inputForPairMatching) {
		return inputForPairMatching.split(REGEX).length != INFO_SIZE;
	}

	private static void validateMenuChoiceInput(String choice) {
		if (!Menu.contains(choice)) {
			throw new IllegalArgumentException(WRONG_MENU_CHOICE_INPUT);
		}
	}
}
