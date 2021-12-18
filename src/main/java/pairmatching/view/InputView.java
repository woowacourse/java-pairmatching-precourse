package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.converter.InputConverter;
import pairmatching.domain.Function;
import pairmatching.domain.PairInfo;

public class InputView {

	private OutputView outputView = new OutputView();

	public Function readFunction() {
		while (true) {
			try {
				outputView.printFunctionList();
				return InputConverter.convertFunction(Console.readLine());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public PairInfo readPairInfo() {
		while (true) {
			try {
				outputView.printCourseAndLevelAndMission();
				return InputConverter.convertPairInfo(Console.readLine());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
