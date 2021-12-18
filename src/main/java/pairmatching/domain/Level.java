package pairmatching.domain;

import static javax.swing.JOptionPane.*;

import java.util.Arrays;

public enum Level {
	LEVEL1("레벨1"),
	LEVEL2("레벨2"),
	LEVEL3("레벨3"),
	LEVEL4("레벨4"),
	LEVEL5("레벨5");

	private String name;

	Level(String name) {
		this.name = name;
	}

	public boolean isSame(String name) {
		return this.name.equals(name);
	}

	public static Level find(String name) {
		System.out.println(name);
		return Arrays.stream(values())
			.filter(course -> course.name.equals(name))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE + "올바르지 않은 레벨 입력 값 입니다."));
	}
	// 추가 기능 구현
}
