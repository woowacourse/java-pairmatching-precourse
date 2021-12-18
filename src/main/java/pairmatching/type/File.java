package pairmatching.type;

public enum File {
	PATH("./src/main/resources/"),
	BACK_END("backend-crew.md"),
	FRONT_END("frontend-crew.md");

	private String name;

	File(String name) {
		this.name = name;
	}

	public String getName() {
		return File.PATH.name + this.name;
	}
}
