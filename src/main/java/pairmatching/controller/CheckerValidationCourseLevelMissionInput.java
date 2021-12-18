package pairmatching.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pairmatching.constant.CheckValidationCourseLevelMissionStatus;

public class CheckerValidationCourseLevelMissionInput {
	String input;
	List<String> courses = new ArrayList<>();
	Map<String, List<String>> levels = new HashMap<>();
	List<String> missions = new ArrayList<>();

	public CheckerValidationCourseLevelMissionInput(String input) {
		this.input = input;

	}

	//TODO: Mission input exception
	public CheckValidationCourseLevelMissionStatus checkValidation() {
		return CheckValidationCourseLevelMissionStatus.VALID;
	}
}
