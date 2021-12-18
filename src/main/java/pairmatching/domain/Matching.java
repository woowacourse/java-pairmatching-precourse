package pairmatching.domain;

import java.util.List;
import java.util.Objects;

import pairmatching.domain.unit.Course;
import pairmatching.domain.unit.Level;
import pairmatching.domain.unit.Mission;

public class Matching {
	private Course course;
	private Level level;
	private Mission mission;
	private List<String> names;

	public Matching(Course course, Level level, Mission mission, List<String> names) {
		this.course = course;
		this.level = level;
		this.mission = mission;
		this.names = names;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Matching matching = (Matching)o;
		return course == matching.course && level == matching.level && mission == matching.mission;
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, level, mission);
	}
}
