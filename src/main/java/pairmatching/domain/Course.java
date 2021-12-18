package pairmatching.domain;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private static final String INFO = "과정: 백엔드 | 프론트엔드";
	private String name;

	Course(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return INFO;
	}
}