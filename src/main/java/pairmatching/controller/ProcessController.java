package pairmatching.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.util.Constants;
import pairmatching.util.ExceptionHandler;
import pairmatching.validator.InputValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class ProcessController {
	public void input() {
		OutputView.printProcess(
			String.join("\n", Arrays.asList(
				Constants.PROCESS_OUT_LINE
				, Constants.PROCESS_COURSE + coursesToString()
				, Constants.PROCESS_MISSION + levelsToString()
				, Constants.PROCESS_OUT_LINE)
			));

		String process = "";
		do {
			process = InputView.inputProcess();
		} while (!validate(process));
	}

	private String coursesToString() {
		List<String> courseList = new ArrayList<>();
		Stream.of(Course.values())
			.forEach(course -> courseList.add(course.toString()));
		return String.join(Constants.PROCESS_SEPARATOR, courseList);
	}

	private String levelsToString() {
		List<String> levelList = new ArrayList<>();
		Stream.of(Level.values())
			.forEach(level -> levelList.add(level.toString()));
		return String.join("\n", levelList);
	}

	private boolean validate(String process) {
		List<String> processList = Arrays.asList(process.split(Constants.PROCESS_INPUT_SEPARATOR));
		boolean isValid = processList.size() == Constants.PROCESS_LIST_INPUT_SIZE
			&& processList.stream().allMatch(InputValidator::isNotEmpty)
			&& validateCourse(processList.get(0))
			&& validateLevel(processList.get(1))
			&& validateMission(processList.get(2));
		ExceptionHandler.handleInputError(isValid, Constants.ERROR_MESSAGE_INPUT_PROCESS);
		return isValid;
	}

	private boolean validateCourse(String course) {
		return Arrays.stream(Course.values())
			.anyMatch(c -> c.isEqual(course));
	}

	private boolean validateLevel(String level) {
		return Arrays.stream(Level.values())
			.anyMatch(l -> l.isEqualLevel(level));
	}

	private boolean validateMission(String mission) {
		return Arrays.stream(Level.values())
			.anyMatch(l -> l.isEqualMission(mission));
	}
}
