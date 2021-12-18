package pairmatching.domain;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private final String name;

	Course(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public boolean isFrontEnd() {
		return this == Course.FRONTEND;
	}

	public boolean isBackEnd() {
		return this == Course.BACKEND;
	}
}
