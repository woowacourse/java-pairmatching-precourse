package pairmatching;

import java.util.Arrays;

public enum Menu {
	MATCHING("1. 페어 매칭", "1"),
	FIND("2. 페어 조회", "2"),
	RESET("3. 페어 조회", "3"),
	QUIT("Q. 종료", "Q");

	private static final String ERROR_NOT_FOUND = "해당 기능은 존재하지 않습니다.";
	
	private String name;
	private String feature;

	Menu(String name, String feature) {
		this.name = name;
		this.feature = feature;
	}

	public String toString() {
		return name;
	}

	public static void validateChoose(String inputFeature) {
		if (!Arrays.stream(Menu.values()).anyMatch(menu -> menu.feature.equals(inputFeature))) {
			throw new IllegalArgumentException(ERROR_NOT_FOUND);
		}
	}
}
