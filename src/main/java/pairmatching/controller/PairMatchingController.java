package pairmatching.controller;

import java.util.function.Supplier;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
	public void service() {
		OutputView.printMain();
		String option = retryInput(() -> InputView.inputOption("1", "2", "3", "Q"));
	}

	public String retryInput(Supplier<String> supplier) {
		try {
			return supplier.get();
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return retryInput(supplier);
		}
	}
}
