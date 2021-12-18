package pairmatching.domain;

import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Pair {


	public boolean handleFunction(String pick) {
		if(pick.equals("1")) {
			matching();
		}

		if(pick.equals("2")) {
			check();
		}

		if(pick.equals("3")) {
			initialize();
		}

		if(pick.equals("Q")) {
			return false;
		}

		OutputView.printProcessMissionLevel();
		return true;
	}


	private void matching() {

	}

	private void check() {

	}

	private void initialize() {

	}


}
