package pairmatching.condition;

import java.util.Arrays;

public enum Answer {
	YES("네"),
	NO("아니오");

	private static final String ERROR_NOT_FOUND = "해당 입력은 사용할 수 없습니다.";

	private String answer;

	Answer(String answer) {
		this.answer = answer;
	}

	public String toString() {
		return answer;
	}

	public static Answer validateChoose(String inputAnswer) {
		return Arrays.stream(Answer.values())
			.filter(answer -> answer.answer.equals(inputAnswer))
			.findFirst()
			.orElseThrow(() ->
				new IllegalArgumentException(ERROR_NOT_FOUND));
	}
}
