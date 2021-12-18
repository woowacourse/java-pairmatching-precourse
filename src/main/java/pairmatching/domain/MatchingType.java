package pairmatching.domain;

import java.util.Objects;

public class MatchingType {
	private Course course;
	private String mission;
	private Level level;

	public MatchingType(Course course, Level level, String mission) {
		this.course = course;
		this.mission = mission;
		this.level = level;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		MatchingType matching = (MatchingType)o;
		return course == matching.course &&
			Objects.equals(mission, matching.mission) &&
			level == matching.level;
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, mission, level);
	}

}
