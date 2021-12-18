package pairmatching.view.input;

import camp.nextstep.edu.missionutils.Console;

import pairmatching.domain.FunctionChoice;


public class InputView {

	public FunctionChoice requestFunctionChoice() {
		String inputString = Console.readLine();
		return FunctionChoice.of(inputString.trim());
	}

}
