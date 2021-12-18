package pairmatching.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import pairmatching.models.Course;
import pairmatching.models.Level;
import pairmatching.models.Mission;

public class DataValidation {

	private static final Integer COURSE_LEVEL_MISSION_LENGTH = 3;

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

	private void validateCourse(final List<String> courseList, final String selectedCourse) {
		boolean correctCourse = false;
		for(String course : courseList) {
			if (selectedCourse.equals(course)) {
				correctCourse = true;
				break;
			}
		}
		if(!correctCourse) {
			errorMessage = PairMatchingMessage.wrongCourseError(selectedCourse);
			throw new IllegalArgumentException(errorMessage);
		}
	}

	private void validateLevel(final List<String> levels, final String selectedLevel) {
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

	private void validateMission(final List<String> missions, final String selectedMission) {
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

	private List<String> makeLevelList(final List<Mission> missions) {
		final List<String> levels = new ArrayList<>();
		return missions.stream()
			.map(Mission::getLevel)
			.collect(Collectors.toList());
	}

	private List<String> makeMissionList(final List<Mission> missions, final String level) {
		List<String> missionList = new ArrayList<>();
		for(Mission mission : missions) {
			if(mission.getLevel().equals(level)) {
				missionList = mission.getMissionList();
				break;
			}
		}
		return missionList;
	}

	public void validateCourseLevelMission(final List<String> courseList
			, final List<Mission> missions, final String courseLevelMission) {
		String[] inputtedData = courseLevelMission.split(",");
		if(inputtedData.length != COURSE_LEVEL_MISSION_LENGTH) {
			errorMessage = PairMatchingMessage
				.getDistinguishCourseLevelMissionError(courseLevelMission);
			throw new IllegalArgumentException(errorMessage);
		}
		final String course = inputtedData[0].trim();
		final String level = inputtedData[1].trim();
		final String mission = inputtedData[2].trim();
		validateCourse(courseList, course);
		validateLevel(makeLevelList(missions), level);
		validateMission(makeMissionList(missions, level), mission);
	}

	public void validateRematchingPairOption(final String selectedOption) {
		if(!selectedOption.equals(PairMatchingMessage.YES)
				&& !selectedOption.equals(PairMatchingMessage.NO)) {
			errorMessage = PairMatchingMessage
				.resetMatchingInformationError(selectedOption);
			throw new IllegalArgumentException(errorMessage);
		}
	}
}
