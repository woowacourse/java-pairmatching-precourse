package pairmatching.controller;

import java.io.IOException;

import pairmatching.domain.Crews;
import pairmatching.domain.Menu;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

	public void run() {
		Crews crews = generateCrews();
		while (true) {
			Menu menu = selectMenu();
			if (menu.isFinish()) {
				break;
			}

		}
	}

	private Menu selectMenu() {
		try {
			OutputView.printInputMainMenu();
			return InputView.inputMenu();
		} catch (IllegalArgumentException exception) {
			OutputView.printException(exception);
			return selectMenu();
		}
	}

	private Crews generateCrews() {
		try {
			return InputView.generateCrews();
		} catch (IOException e) {
			e.printStackTrace();
			return generateCrews();
		}
	}
}
