package pairmatching.domain;

import java.util.Arrays;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private static final String ERROR_NOT_COURSE = " 과정은 없습니다.";
	private String name;

	Course(String name) {
		this.name = name;
	}

	public static pairmatching.domain.Course findByCourse(String command) {
		return Arrays.stream(pairmatching.domain.Course.values())
			.filter(course -> course.name.equals(command))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(command + ERROR_NOT_COURSE));
	}

	public boolean isValidateBackend() {
		return name.equals("백엔드");
	}

	public boolean isValidateFrontend() {
		return name.equals("프론트엔드");
	}
}
