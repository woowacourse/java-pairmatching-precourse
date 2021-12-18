package pairmatching.view.output;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.Course;
import pairmatching.domain.FunctionChoice;
import pairmatching.domain.Level;

public class OutputView {

	public void printMessage(String message) {
		System.out.println(message);
	}

	public void printErrorMessage(String message) {
		printMessage("[ERROR] " + message);
	}

	public void printFunctionChoice() {
		printMessage("기능을 선택하세요.");
		Arrays.stream(FunctionChoice.values())
			.map(FunctionChoice::toString).forEach(this::printMessage);
	}

	public void printEmptyNewLine() {
		String emptyNewLine = "\n";
		printMessage(emptyNewLine);
	}

	public void printDetails() {
		printShopLine();
		printCourses();
		printMission();
		printShopLine();
	}

	public void printShopLine() {
		printMessage("#############################################");
	}

	private void printCourses() {
		String result = "과정: ";
		result += String.join(" | ", Arrays.stream(Course.values()).map(Course::getName).collect(Collectors.toList()));
		printMessage(result);
	}

	private void printMission() {
		printMessage("미션: ");
		Arrays.stream(Level.values()).map(Level::toString).forEach(this::printMessage);
	}

	public void printRequestMatchOptions() {
		printMessage("과정, 레벨, 미션을 선택하세요.");
		printMessage("ex) 백엔드, 레벨1, 자동차경주");
	}

	public void printMatchResult(List<String> results) {
		printMessage("페어 매칭 결과입니다.");
		results.forEach(this::printMessage);
	}

	public void printRequestYesOrNow() {
		printMessage("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
		printMessage("네 | 아니오");
	}

}
