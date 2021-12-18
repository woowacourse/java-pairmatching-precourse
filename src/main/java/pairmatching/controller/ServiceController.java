package pairmatching.controller;

import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class ServiceController {
	public static void run() {
		String choice = askFunction();

	}

	private static String askFunction() {
		OutputView.askFunction();
		return InputView.askFunction();
	}
}
