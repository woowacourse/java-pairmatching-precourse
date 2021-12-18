package pairmatching.model;

public enum Course {
	BACKEND("백엔드"), FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}

	public static Course valueByName(String name) {
		if (name.equals("백엔드")) {
			return BACKEND;
		}
		return FRONTEND;
	}

	public String getName() {
		return name;
	}
}
