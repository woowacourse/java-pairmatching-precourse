package pairmatching;

import pairmatching.view.InputView;

public class PairMatchingController {
	public void run() {
		String inputCommand = null;
		do {
			try {
				inputCommand = InputView.getInputCommand();
			} catch (IllegalArgumentException e) {

			}
		} while (true);
	}
}
