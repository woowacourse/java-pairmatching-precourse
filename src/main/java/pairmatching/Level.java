package pairmatching;

public enum Level {
	LEVEL1("레벨1"),
	LEVEL2("레벨2"),
	LEVEL3("레벨3"),
	LEVEL4("레벨4"),
	LEVEL5("레벨5");

	private String name;
	private static final Level[] LEVELLIST = Level.values();

	Level(String name) {
		this.name = name;
	}

	public static Level[] getLevelList() {
		return LEVELLIST;
	}

	public String getName() {
		return name;
	}
}
