package pairmatching.domain;

public class Mission {
	private final String name;
	private final Course course;
	private final Level level;

	public Mission(String name, Course course, Level level) {
		this.name = name;
		this.course = course;
		this.level = level;
	}

	public boolean isSameName(String name) {
		return this.name.equals(name);
	}

	public boolean isSameLevel(Level level) {
		return this.level.equals(level);
	}

	public boolean isSameCourse(Course course) {
		return this.course.equals(course);
	}
}
