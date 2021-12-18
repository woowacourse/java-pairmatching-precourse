package pairmatching.validator;

public class PairValidator {

	private static final String INPUT_LENGTH_ERROR = "{ERROR] 과정, 레벨, 미션 3가지를 입력해야 합니다.";

	public void validateLength(String input) {
		if (input.split(", ").length != 3) {
			throw new IllegalArgumentException(INPUT_LENGTH_ERROR);
		}
	}
}
