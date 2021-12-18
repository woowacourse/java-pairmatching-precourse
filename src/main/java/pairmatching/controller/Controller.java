package pairmatching.controller;

import pairmatching.view.MenuInputView;
import pairmatching.view.OutputView;

public class Controller {

	public static void run() {
		boolean end = false;
		while (!end) {
			OutputView.menuOutput();
			String userinput = MenuInputView.getInput();
			if (userinput.equals("Q")) {
				end = true;
			}
			if (userinput.equals("1")) {
				MatchController.match();
			}
			if (userinput.equals("2")) {
				SeekController.seek();
			}
			if (userinput.equals("3")) {
				InitController.initPair();
			}
		}
	}
}
