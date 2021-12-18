package pairmatching.dto;

import pairmatching.validator.InputValidator;

public class ChoiceDto {

	public static final int COURSE_INDEX = 0;
	public static final int LEVEL_INDEX = 1;
	public static final int MISSION_INDEX = 2;

	private String course;
	private String level;
	private String mission;

	public ChoiceDto(String items) {
		InputValidator.validateSubMenu(items);
		String[] item = items.split(",");
		course = item[COURSE_INDEX].trim();
		level = item[LEVEL_INDEX].trim();
		mission = item[MISSION_INDEX].trim();
	}

	public String getCourse() {
		return course;
	}

	public String getLevel() {
		return level;
	}

	public String getMission() {
		return mission;
	}
}
