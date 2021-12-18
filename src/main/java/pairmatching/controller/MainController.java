package pairmatching.controller;

import pairmatching.view.Input;
import pairmatching.view.Output;

public class MainController {
	public MainController() {
		InitializeController.initCrews();
		run();
	}

	private void run() {
		Option option;
		do {
			Output.mainOption();
			option = getOption();
		} while (!option.equals(Option.QUIT));
	}

	private Option getOption() {
		Option option;
		do {
			try {
				option = Option.getByValue(Input.readLine());
				break;
			} catch (IllegalArgumentException e) {
				Output.printError(e.getMessage());
			}
		} while (true);

		return option;
	}
}
