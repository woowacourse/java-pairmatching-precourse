package pairmatching.view;

import java.util.Arrays;

import pairmatching.model.Role;

public class OutputView {
	private final String CHOOSE_ROLE = "기능을 선택하세요.";

	public void printRoleList() {
		System.out.println(CHOOSE_ROLE);
		Arrays.stream(Role.values())
			.forEach(role -> System.out.println(role.toString()));
	}
}
