package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private OutputView outputView = new OutputView();

	public String readFunction() {
		while (true) {
			try {
				outputView.printFunctionList();
				return Console.readLine();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
