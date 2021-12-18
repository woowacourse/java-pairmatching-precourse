package pairmatching.io;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.data.ProgramData;
import pairmatching.io.validator.InputValidator;
import pairmatching.type.Course;
import pairmatching.type.CourseLevelMissionInfo;

public class ConsoleInputHandler {

	private ConsoleOutputHandler outputHandler;

	public ConsoleInputHandler(ConsoleOutputHandler outputHandler) {
		this.outputHandler = outputHandler;
	}

	private String read() {
		return Console.readLine();
	}

	public String getValidSelect() {
		outputHandler.printMessage(ProgramData.SELECT_MESSAGE);
		while(true) {
			try {
				return getSelect();
			} catch (IllegalArgumentException iae) {
				outputHandler.printErrorMessage(iae);
			}
		}
	}

	public CourseLevelMissionInfo getValidCourseLevelMissionInfo() {
		outputHandler.printMessage(ProgramData.SELECT_COURSE_LEVEL_MISSION_MESSAGE);
		while(true) {
			try {
				return getCourseLevelMissionInfo();
			} catch (IllegalArgumentException iae) {
				outputHandler.printErrorMessage(iae);
			}
		}
	}

	private CourseLevelMissionInfo getCourseLevelMissionInfo() {
		String[] data = read().split(ProgramData.COURSE_LEVEL_MISSION_SEPARATOR);
		CourseLevelMissionInfo info = new CourseLevelMissionInfo(data);
		System.out.println(info.getCourse());
		return info;
	}

	public boolean getValidDuplicatePairSelect() {
		outputHandler.printMessage(ProgramData.DUPLICATE_PAIR_SELECT_MESSAGE);
		while(true) {
			try {
				return getDuplicatePairSelect();
			} catch (IllegalArgumentException iae) {
				outputHandler.printErrorMessage(iae);
			}
		}
	}

	private String getSelect() {
		String select = read();
		InputValidator.isValidSelect(select);
		return select;
	}

	private boolean getDuplicatePairSelect() {
		String select = read();
		InputValidator.isValidDuplicatePairSelect(select);
		if(select.equals(ProgramData.YES)) {
			return true;
		}
		return false;
	}
}
