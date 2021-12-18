package pairmatching;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.view.ErrorView;
import pairmatching.view.InputView;

public class PairMatchingController {

	public void start() {
		chooseMainFeature();
		requestFeature();
	}

	private void chooseMainFeature() {
		InputView.printChooseFeature();
	}

	private void requestFeature() {
		try {
			Menu.validateChoose(Console.readLine());
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.print(illegalArgumentException.getMessage());
			requestFeature();
		}
	}
}
