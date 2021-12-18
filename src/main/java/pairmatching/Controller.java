package pairmatching;

import java.io.IOException;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.utils.DataInitializer;
import pairmatching.view.OutputView;

public class Controller {
	private final OutputView outputView = new OutputView();

	public void initData() {
		DataInitializer dataInitializer = new DataInitializer();
		try {
			dataInitializer.initializeCrew();
		} catch (IOException e) {
			outputView.printError(e);
		}
	}

	public void run() {
		chooseFunction();
	}

	private void chooseFunction() {
		outputView.printMain();
		try {
			Function chosenFunction = Function.findByCode(Console.readLine());
		} catch (IllegalArgumentException e) {
			outputView.printError(e);
			chooseFunction();
		}
	}
}
