package pairmatching;

import pairmatching.domain.MainMenu;
import pairmatching.view.InputView;

public class PairMatchingController {
	private static final String PROGRAM_EXIT_COMMAND = "Q";

	public void run() {
		String inputCommand = null;
		do {
			try {
				inputCommand = InputView.getInputCommand();
				MainMenu.findByCommand(inputCommand).run();
			} catch (IllegalArgumentException e) {

			}
		} while (isContinueProgram(inputCommand));
	}

	private boolean isContinueProgram(String inputCommand) {
		if (inputCommand.equals(PROGRAM_EXIT_COMMAND)) {
			return false;
		}

		return true;
	}
}
