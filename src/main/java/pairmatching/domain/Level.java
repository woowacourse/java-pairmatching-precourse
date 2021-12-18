package pairmatching.domain;

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

	// 추가 기능 구현
	public String getName() {
		return name;
	}

	public static Level getInstance(String name) {
		if (name.equals(Level.LEVEL1.getName()))
			return Level.LEVEL1;
		if (name.equals(Level.LEVEL2.getName()))
			return Level.LEVEL2;
		if (name.equals(Level.LEVEL3.getName()))
			return Level.LEVEL3;
		if (name.equals(Level.LEVEL4.getName()))
			return Level.LEVEL4;
		if (name.equals(Level.LEVEL5.getName()))
			return Level.LEVEL5;

		return null;
	}
}
