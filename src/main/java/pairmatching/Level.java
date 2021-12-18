package pairmatching;

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
	public String getName(){
		return this.name;
	}

	public static Level getLevel(String name) {
		for (Level level : Level.values()) {
			if (level.getName().equals(name)) {
				return level;
			}
		}
		throw new IllegalArgumentException("[ERROR]존재하지 않는 코스입니다.");
	}
}