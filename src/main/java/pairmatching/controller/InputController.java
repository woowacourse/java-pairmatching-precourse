package pairmatching.controller;

import java.util.List;

import pairmatching.models.Mission;
import pairmatching.utils.DataValidation;
import pairmatching.view.PairMachineInput;

public class InputController {

	private final PairMachineInput input;

	private final DataValidation validation;

	public InputController(final PairMachineInput input, final DataValidation validation) {
		this.input = input;
		this.validation = validation;
	}

	public String selectFunction() {
		while(true) {
			try {
				final String selectedFunction = input.selectFunction();
				validation.validateFunction(selectedFunction);
				return selectedFunction;
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}

	public String[] selectCourseAndMission(final List<String> courseList,
			final List<Mission> missions) {
		while(true) {
			try {
				final String courseLevelMission =
					input.selectCourseAndMission(courseList, missions);
				validation.validateCourseLevelMission(courseList, missions, courseLevelMission);
				return courseLevelMission.split(",");
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}

	public String selectRematchPairOrNot() {
		while(true) {
			try {
				final String selectedOption = input.selectRematchPairOrNot();
				validation.validateRematchingPairOption(selectedOption);
				return selectedOption;
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}
}
