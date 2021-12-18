package pairmatching.Domain;

import java.util.Arrays;

public enum Level {
	LEVEL1("레벨1",1),
	LEVEL2("레벨2",2),
	LEVEL3("레벨3",3),
	LEVEL4("레벨4",4),
	LEVEL5("레벨5",5);

	private String name;
	private int number;

	Level(String name, int number) {
		this.name = name;
		this.number = number;
	}

	// 추가 기능 구현
	@Override
	public String toString() {
		return "  - " + name + ": ";
	}

	public String getName() {
		return this.name;
	}

	public int getNumber() {
		return this.number;
	}

	public static Level findLevel(String input) {
		return Arrays.stream(Level.values()).findFirst().filter(level -> level.getName().equals(input)).orElse(null);
	}
}
