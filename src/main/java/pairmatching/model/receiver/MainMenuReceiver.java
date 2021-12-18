package pairmatching.model.receiver;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.model.validator.MainMenuValidator;

public class MainMenuReceiver {

	public static final String INIT_VALUE_OF_MAIN_MENU = "init";
	MainMenuValidator mainMenuValidator = new MainMenuValidator();

	public String receive() {
		String input = INIT_VALUE_OF_MAIN_MENU;

		boolean rewindSwitch = true;
		while (rewindSwitch) {
			input = Console.readLine();

			rewindSwitch = mainMenuValidator.validate(input);
		}

		return input;
	}
}
