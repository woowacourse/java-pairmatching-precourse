package pairmatching.model;

import java.util.Objects;

public class Mission {
	private Course course;
	private Level level;
	private String name;

	private Mission(Course course, Level level, String name) {
		this.course = course;
		this.level = level;
		this.name = name;
	}

	public static Mission of(Course course, Level level, String name) {
		return new Mission(course, level, name);
	}

	@Override
	public String toString() {
		return "Mission{" +
			"level=" + level +
			", name='" + name + '\'' +
			'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Mission mission = (Mission) o;
		return course == mission.course && level == mission.level && Objects.equals(name, mission.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, level, name);
	}

	public String getName() {
		return name;
	}

	public Level getLevel() {
		return level;
	}

	public Course getCourse() {
		return course;
	}
}
