package pairmatching.utils;

import java.util.List;

import pairmatching.models.Course;
import pairmatching.models.Mission;

public class DataValidation {

	private String errorMessage;

	public DataValidation() {
		this.errorMessage = "";
	}

	public void validateFunction(final String selectedFunction) {
		if(!selectedFunction.equals("1") && !selectedFunction.equals("2")
				&& !selectedFunction.equals("3") && !selectedFunction.equals("Q")) {

			errorMessage = PairMatchingMessage.wrongFunctionError(selectedFunction);
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public void validateCourse(final String selectedCourse) {
		if(!selectedCourse.equals(Course.FRONTEND.getName())
				&& !selectedCourse.equals(Course.BACKEND.getName())) {

			errorMessage = PairMatchingMessage.wrongCourseError(selectedCourse);
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public void validateLevel(final List<String> levels, final String selectedLevel) {
		boolean correctLevel = false;
		for(String level : levels) {
			if (selectedLevel.equals(level)) {
				correctLevel = true;
				break;
			}
		}
		if(!correctLevel) {
			errorMessage = PairMatchingMessage.wrongLevelError(selectedLevel);
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public void validateMission(final List<String> missions, final String selectedMission) {
		boolean correctMission = false;
		for(String mission : missions) {
			if(selectedMission.equals(mission)) {
				correctMission  =true;
				break;
			}
		}

		if(!correctMission) {
			errorMessage = PairMatchingMessage.wrongMissionError(selectedMission);
			throw new IllegalArgumentException(errorMessage);
		}
	}

}
