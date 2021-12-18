package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.validator.InputValidator;

public class InputView {

	public static final String INPUT_ENTRY_MENU = "기능을 선택하세요.\n"
		+ "1. 페어 매칭\n"
		+ "2. 페어 조회\n"
		+ "3. 페어 초기화\n"
		+ "Q. 종료\n";

	public static String chooseEntryMenu() {
		System.out.println(INPUT_ENTRY_MENU);
		String input = Console.readLine();
		InputValidator.validateEntryMenu(input);
		return input;
	}

}
