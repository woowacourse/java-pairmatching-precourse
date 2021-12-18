package pairmatching.domain;

public class Curriculum {
	private String course;
	private String level;
	private String mission;

	public Curriculum(String course, String level, String mission) {
		this.course = course;
		this.level = level;
		this.mission = mission;
	}

	public String getCourse() {
		return course;
	}
}
