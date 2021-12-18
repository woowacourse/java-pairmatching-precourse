package pairmatching.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.Constant;
import pairmatching.CourseLevelMissionSplit;
import pairmatching.Function;

public class InputView {
	public static Function getInputOfFunctionType() {
		try {
			OutputView.printFunctionType();
			Function function = Function.of(Console.readLine());
			return function;
		} catch (IllegalArgumentException e) {
			System.out.println(Constant.ERROR + e.getMessage());
			return getInputOfFunctionType();
		}
	}
}
