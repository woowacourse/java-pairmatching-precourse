package pairmatching.domain.input;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	public String getName() {return name;}

	Course(String name) {
		this.name = name;
	}
}