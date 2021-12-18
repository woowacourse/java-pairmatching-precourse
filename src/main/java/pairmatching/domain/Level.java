package pairmatching.domain;

public enum Level {
	LEVEL1("레벨1"),
	LEVEL2("레벨2"),
	LEVEL3("레벨3"),
	LEVEL4("레벨4"),
	LEVEL5("레벨5");

	private String title;

	Level(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
}
