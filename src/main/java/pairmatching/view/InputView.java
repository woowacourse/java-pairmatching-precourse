package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.util.ViewMessage;
import pairmatching.util.validator.MenuValidator;

public class InputView {

	public String enterMainMenu() {
		while (true) {
			try {
				System.out.println(ViewMessage.INPUT_MACHINE_MONEY.getMessage());
				String input = Console.readLine();
				MenuValidator.validateMenu(input);
				return input;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
