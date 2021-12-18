package pairmatching.validator;

import java.util.Arrays;

import pairmatching.model.Role;

public class RoleValidator extends Validator {
	private static final String ERROR_INVALID_NUMBER = "[ERROR] 유효하지 않은 번호 입력입니다";
	public static final String ERROR_NOT_EXISTED = "[ERROR] 존재하지 않는 번호입니다.";

	private static void isValidNumber(String number) {
		boolean isNumberNotInRole = Arrays.stream(Role.values()).noneMatch(role -> number.equals(role.getNumber()));
		if (isNumberNotInRole) {
			throw new IllegalArgumentException(ERROR_INVALID_NUMBER);
		}
	}

	@Override
	public String validate(String number) {
		isValidNumber(number);

		return number;
	}
}

