package pairmatching.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.model.Role;
import pairmatching.validator.RoleValidator;

public class InputView {

	OutputView outputView = new OutputView();

	public String enterRoleNumber() {
		RoleValidator roleValidator = new RoleValidator();
		outputView.printRoleList();
		String number = Console.readLine();

		try {
			return roleValidator.validate(number);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return enterRoleNumber();
		}
	}
}
