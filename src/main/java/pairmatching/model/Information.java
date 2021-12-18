package pairmatching.model;

public class Information {

	private String course;
	private String level;
	private String mission;
	private boolean pairCheck = false;

	public Information(String course, String level, String mission) {
		this.course = course;
		this.level = level;
		this.mission = mission;
	}

	public String getMission() {
		return mission;
	}

	public String getCourse() {
		return course;
	}

	public String getLevel() {
		return level;
	}

	public void checkPaired() {
		this.pairCheck = true;
	}

	public boolean isPaired() {
		return pairCheck;
	}
}
