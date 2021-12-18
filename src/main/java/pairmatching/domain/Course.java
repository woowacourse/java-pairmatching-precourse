package pairmatching.domain;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private final String title;

	Course(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public boolean isFrontEnd() {
		return this == Course.FRONTEND;
	}

	public boolean isBackEnd() {
		return this == Course.BACKEND;
	}
}
