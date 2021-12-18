package pairmatching.domain;

public class Menu {
	private Course course;
	private Level level;
	private Mission mission;

	public Menu(Course course, Level level, Mission mission) {
		this.course = course;
		this.level = level;
		this.mission = mission;
	}

	public Menu() {
	}

	public Course getCourse() {
		return course;
	}

	public Level getLevel() {
		return level;
	}

	public Mission getMission() {
		return mission;
	}
}
