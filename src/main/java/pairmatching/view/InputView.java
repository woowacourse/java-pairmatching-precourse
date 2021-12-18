package pairmatching.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.model.Role;
import pairmatching.validator.CourseLevelMissionValidator;
import pairmatching.validator.RoleValidator;

public class InputView {

	OutputView outputView = new OutputView();

	public String enterRoleNumber() {
		RoleValidator validator = new RoleValidator();
		outputView.printRoleList();
		String number = Console.readLine();

		try {
			return validator.validate(number);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return enterRoleNumber();
		}
	}

	public String enterCourseLevelMission() {
		CourseLevelMissionValidator validator = new CourseLevelMissionValidator();
		outputView.printCourseLevelMission();
		String courseLevelMission = Console.readLine();

		try {
			return validator.validate(courseLevelMission);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return enterCourseLevelMission();
		}
	}
}
