package pairmatching;

import pairmatching.domain.MainMenu;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
	private static final String PROGRAM_EXIT_COMMAND = "Q";

	public void run() {
		String inputCommand = null;
		do {
			try {
				inputCommand = InputView.getInputCommand();
				OutputView.printLineSeparator();
				MainMenu.findByCommand(inputCommand).run();
			} catch (IllegalArgumentException e) {
				OutputView.printErrorMessage(e);
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
