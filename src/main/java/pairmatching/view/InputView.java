package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.util.Symbol;
import pairmatching.util.ViewMessage;
import pairmatching.util.validator.MenuValidator;

public class InputView {

	public String enterMainMenu() {
		while (true) {
			try {
				System.out.println(ViewMessage.SELECT_MENU_MSG.getMessage() + Symbol.NEW_LINE);
				String input = Console.readLine();
				MenuValidator.validateMenu(input);
				return input;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
