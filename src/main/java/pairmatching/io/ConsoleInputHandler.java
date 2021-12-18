package pairmatching.io;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.data.ProgramData;
import pairmatching.io.validator.InputValidator;

public class ConsoleInputHandler {

	private ConsoleOutputHandler outputHandler;

	public ConsoleInputHandler(ConsoleOutputHandler outputHandler) {
		this.outputHandler = outputHandler;
	}

	private String read() {
		return Console.readLine();
	}

	public String getValidSelect() {
		outputHandler.printMessage(ProgramData.SELECT_MESSAGE);
		while(true) {
			try {
				return getSelect();
			} catch (IllegalArgumentException iae) {
				outputHandler.printErrorMessage(iae);
			}
		}
	}

	private String getSelect() {
		String select = read();
		InputValidator.isValidSelect(select);
		return select;
	}

}
