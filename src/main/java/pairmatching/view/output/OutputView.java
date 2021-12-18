package pairmatching.view.output;

import java.util.Arrays;

import pairmatching.domain.FunctionChoice;

public class OutputView {

	public void printMessage(String message) {
		System.out.println(message);
	}

	public void printFunctionChoice() {
		printMessage("기능을 선택하세요.");
		Arrays.stream(FunctionChoice.values())
			.map(FunctionChoice::toString).forEach(this::printMessage);
	}

	public void printShopLine() {
		printMessage("#############################################");
	}

	public void printEmptyNewLine() {
		String emptyNewLine = "\n";
		printMessage(emptyNewLine);
	}

}
