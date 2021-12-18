package pairmatching.view.output;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.Course;
import pairmatching.domain.FunctionChoice;
import pairmatching.domain.Level;
import pairmatching.view.input.Delimiter;

public class OutputView {

	public void printMessage(String message) {
		System.out.println(message);
	}

	public void printErrorMessage(String message) {
		printMessage(ErrorMessage.TAG + message);
	}

	public void printFunctionChoice() {
		printMessage(OutputMessage.REQUEST_FUNCTION_CHOICE);
		Arrays.stream(FunctionChoice.values())
			.map(FunctionChoice::toString).forEach(this::printMessage);
	}

	public void printEmptyNewLine() {
		printMessage(Delimiter.getNewLine());
	}

	public void printDetails() {
		printShopLine();
		printCourses();
		printMission();
		printShopLine();
	}

	public void printShopLine() {
		printMessage(OutputMessage.SHOP_LINE);
	}

	private void printCourses() {
		String result = OutputMessage.PRINT_COURSE_INTRO;
		result += Delimiter.joinWithVerticalLine(
			Arrays.stream(Course.values()).map(Course::getName).collect(Collectors.toList())
		);
		printMessage(result);
	}

	private void printMission() {
		printMessage(OutputMessage.PRINT_MISSION_INTRO);
		Arrays.stream(Level.values()).map(Level::toString).forEach(this::printMessage);
	}

	public void printRequestMatchOptions() {
		printMessage(OutputMessage.REQUEST_CHOOSE_MATCHING_OPTIONS);
		printMessage(OutputMessage.EXAMPLE_CHOOSE_MATCHING_OPTIONS);
	}

	public void printMatchResult(List<String> results) {
		printMessage(OutputMessage.PRINT_RESULT_MATCHING);
		results.forEach(this::printMessage);
	}

	public void printRequestYesOrNow() {
		printMessage(OutputMessage.REQUEST_AGAIN_MATCHING_OPTIONS_INTRO);
		printMessage(OutputMessage.REQUEST_AGAIN_MATCHING_OPTIONS);
	}

}
