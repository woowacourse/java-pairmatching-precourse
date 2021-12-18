package pairmatching;

import java.io.IOException;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.utils.DataInitializer;
import pairmatching.view.OutputView;

public class Controller {
	private final OutputView outputView = new OutputView();

	private boolean running = true;

	public void initData() {
		DataInitializer dataInitializer = new DataInitializer();
		try {
			dataInitializer.initializeCrew();
		} catch (IOException e) {
			outputView.printError(e);
		}
	}

	public void run() {
		runFunction(chooseFunction());
	}

	public boolean isRunning() {
		return running;
	}

	private Function chooseFunction() {
		outputView.printMain();
		try {
			return Function.findByCode(Console.readLine());
		} catch (IllegalArgumentException e) {
			outputView.printError(e);
			return chooseFunction();
		}
	}

	private void runFunction(Function function) {
		if (function == Function.QUIT) {
			running = false;
			return;
		}
		if (function == Function.MATCHING) {
			// TODO: 페어 매칭
		}
		if (function == Function.INQUIRY) {
			// TODO: 페어 조회
		}
		if (function == Function.INIT) {
			// TODO: 페어 초기화
		}
	}
}
