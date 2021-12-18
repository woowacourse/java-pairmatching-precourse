package pairmatching.model.enums;

import static pairmatching.constant.SystemMessage.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Assignment {

	ASSIGNMENT_1(Arrays.asList("자동차경주", "로또", "숫자야구게임")),
	ASSIGNMENT_2(Arrays.asList("장바구니", "결제", "지하철노선도")),
	ASSIGNMENT_3(new ArrayList<>()),
	ASSIGNMENT_4(Arrays.asList("성능개선", "배포")),
	ASSIGNMENT_5(new ArrayList<>());

	private List<String> assignment;

	Assignment(List<String> assignment) {
		this.assignment = assignment;
	}

	@Override
	public String toString() {
		return String.join(DELIMITER, assignment);
	}

	public static Assignment getAssignmentByInput(String input) {
		return Arrays.stream(Assignment.values())
			.filter(assignment -> assignment.assignment.contains(input))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("[ERROR] 입력한 미션은 존재하지 않습니다."));
	}
}
