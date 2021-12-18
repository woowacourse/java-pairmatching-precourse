package utils.validator;

public class ProcessValidator {

	private ProcessValidator() {
	}

	public static boolean isValidProcess(String process) {
		if (process.equals("백엔드") || process.equals("프론트엔드")) {
			return true;
		}
		throw new IllegalArgumentException("[ERROR] 입력한 과정이 올바른 입력(백엔드 또는 프론트엔드)가 아니다.");
	}
}
